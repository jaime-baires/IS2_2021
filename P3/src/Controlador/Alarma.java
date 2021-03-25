package Controlador;

import java.util.Date;

public class Alarma implements Comparable<Alarma> {

	private String id;
	private Date hora;

	public Alarma(String id, Date hora) {
		super();
		this.id = id;
		this.hora = hora;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	@Override
	public int compareTo(Alarma o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object a) {
		// TODO Auto-generated method stub
		Alarma d = (Alarma) a;
		return (d.getHora().equals(this.hora) && d.getId().equals(this.id));
	}

}
