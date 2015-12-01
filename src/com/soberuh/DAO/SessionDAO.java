package com.soberuh.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Classe utilitaria para manipulacao das sessoes com o Hibernate.
 */
@SuppressWarnings({"deprecation"})
public class SessionDAO {
    /**
     * Logger da classe.
     */
   // protected static Logger log = Logger.getLogger(StringConstants.APPLICATION_APPENDER);

    /**
     * Fábrica de sessões com Hibernate.
     */
    private static SessionFactory sessionFactory;

    /**
     * Faz o controle da sessão com o Hibernate para cada Thread de requisição.
     */
    private static final ThreadLocal<Session> sessionThread = new ThreadLocal<Session>();

    /**
     * Faz o controle da transação gerenciada pelo Hibernate para cada Thread de
     * requisição.
     */
    private static final ThreadLocal<Transaction> transactionThread = new ThreadLocal<Transaction>();

    /**
     * @return Sessao com o Hibernate da Thread atual.
     */
    public static Session currentSession() {
        if (sessionThread.get() == null) {
            Session session = sessionFactory.openSession();
            sessionThread.set(session);
        }
        return sessionThread.get();
    }

    /**
     * Fecha sessao atual com o Hibernate.
     */
    public static void closeSession() {

        Session session = sessionThread.get();

        if (session != null)
            session.close();

        sessionThread.set(null);
    }

    /**
     * Cria uma nova sessao.
     */
    public static void openSession() {
        if (SessionDAO.sessionFactory != null) {
            try {
                sessionThread.set(sessionFactory.openSession());

                Session session = sessionThread.get();

                /**
                 * Existe um bug do Hibernate 3 para conexões com o Microsoft
                 * SqlServer 2005, onde operações batch (processamentos em lote)
                 * podem lançar {@link org.hibernate.StaleStateException}, pois
                 * a operação do Hibernate "verifyOutcome" espera 1 como
                 * resultado para ganratir que  a atualização foi correta. Como
                 * NOCOUNT está ligado, -1 sempre retornado.
                 */
                /*
                 session.connection().createStatement().execute("SET NOCOUNT OFF");
                 session.connection().createStatement().execute("SET ARITHABORT ON");
                */
            } catch (final Exception e) {
               // SessionDAO.log.warning("Erro em SessionDAO.openSession: " + e.getMessage());
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    /**
     * Marca o início da transação. Apartir desta chamada, todas as operações
     * efetuadas estarão automaticamente gerenciadas pela mesma.
     */
    public static void beginTransaction() {
        Transaction transaction = currentSession().beginTransaction();
        transactionThread.set(transaction);
    }

    public static Transaction getCurrentTransaction() {
        return transactionThread.get();
    }

    /**
     * Executa o commit das operações controladas pela transação da Thread
     * atual.
     */
    public static void commitTransaction() {
        /*
        Transaction transaction = transactionThread.get();
        try{
            if (transaction != null && !transaction.wasCommitted()
                    && !transaction.wasRolledBack()) {
                transaction.commit();
            }
        }catch (Exception e){
            log.error("Erro ao realizar commit. "+ e.getMessage());
        }finally {
            transactionThread.set(null);
        }
        */
    }

    /**
     * Executa o rollback das operações controladas pela transação da Thread
     * atual.
     */
    public static void rollbackTransaction() {
        /*
        Transaction transaction = transactionThread.get();
        try {
            if (transaction != null && !transaction.wasCommitted()
                    && !transaction.wasRolledBack()) {
                transaction.rollback();
            }
        }catch (Exception e){
            log.error("Erro ao realizar rollback. " + e.getMessage());
        } finally {
            transactionThread.set(null);
        }
        */
    }

    public static void hsqlCleanup(final Session s) {
        /*
        try {
            s.connection().createStatement().execute("SHUTDOWN");
        } catch (final Exception e) {
            SessionDAO.log.error("Erro em SessionDAO.hsqlCleanup: ", e);
        }
        */
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        SessionDAO.sessionFactory = sessionFactory;
    }

}

