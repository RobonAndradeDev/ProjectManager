package com.soberuh.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by robson.andrade on 30/11/2015.
 */
public class MysqlConHibernate {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("projectmanager");
    private static EntityManager manager;

    public MysqlConHibernate(){
     /*   EntityManagerFactory factory = Persistence.createEntityManagerFactory("projectmanager");
        EntityManager manager = factory.createEntityManager();
        Project pro = new Project();

        pro.setNome("Projeto loko");
        manager.getTransaction().begin();
        manager.persist(pro);
        manager.getTransaction().commit();
        manager.close();
        */
    }

    private EntityManager factoryEntityManager(){
        if(manager == null){
            manager =  factory.createEntityManager();
        }
        return manager;
    }

    protected void insertData(Object obj){
        EntityManager manager = this.factoryEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
        }catch (Exception e){
            manager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }finally {
            manager.close();
        }
    }
}
