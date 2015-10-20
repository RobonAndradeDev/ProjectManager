package Bussiness;

public class Tarefa {
	private String descricao;
	private int horasPrevistas;
	private int prioridade;
	private Project projeto;
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setHorasPrevistas(int horasPrevistas) {
		this.horasPrevistas = horasPrevistas;
	}
	public int getHorasPrevistas() {
		return horasPrevistas;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setProjeto(Project projeto) {
		this.projeto = projeto;
	}
	public Project getProjeto() {
		return projeto;
	}
}
