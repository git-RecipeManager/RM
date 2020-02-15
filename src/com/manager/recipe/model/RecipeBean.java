package com.manager.recipe.model;

import java.io.Serializable;

public class RecipeBean  implements Serializable{

private static final long serialVersionUID = -8549592960594887791L;
private int idRicetta;
private String immagine;
private String titolo;
private String descrizione;
private int idUtente;

public RecipeBean() {
	super();
}

public int getIdRicetta() {
	return idRicetta;
}

public void setIdRicetta(int idRicetta) {
	this.idRicetta = idRicetta;
}

public String getImmagine() {
	return immagine;
}

public void setImmagine(String immagine) {
	this.immagine = immagine;
}

public String getTitolo() {
	return titolo;
}

public void setTitolo(String titolo) {
	this.titolo = titolo;
}

public String getDescrizione() {
	return descrizione;
}

public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}

public int getIdUtente() {
	return idUtente;
}

public void setIdUtente(int idUtente) {
	this.idUtente = idUtente;
}


}
