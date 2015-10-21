package com.soberuh.Bussiness;

import java.sql.Date;

public class Hora {
	private Date dia;
	private double horasTrabalhadas;
	
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Date getDia() {
		return dia;
	}
	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	
}
