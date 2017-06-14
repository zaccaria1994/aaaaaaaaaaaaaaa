package it.polito.tdp.artsmia.model;

public class Coppia {
	Exhibitions e1;
	Exhibitions e2;
	public Exhibitions getE1() {
		return e1;
	}
	public void setE1(Exhibitions e1) {
		this.e1 = e1;
	}
	public Exhibitions getE2() {
		return e2;
	}
	public void setE2(Exhibitions e2) {
		this.e2 = e2;
	}
	public Coppia(Exhibitions e1, Exhibitions e2) {
		super();
		this.e1 = e1;
		this.e2 = e2;
	}
	@Override
	public String toString() {
		return "Coppia [e1=" + e1.getExhibition_id() + ", e2=" + e2.getExhibition_id() + "]";
	}
	

}
