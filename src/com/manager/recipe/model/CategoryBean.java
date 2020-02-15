package com.manager.recipe.model;

import java.io.Serializable;

public class CategoryBean  implements Serializable{

private static final long serialVersionUID = -8549592960594887791L;
private int idCategoria;
private String nomeCategoria;
private String descrizioneCategoria;

public CategoryBean() {
	super();
}

public int getIdCategoria() {
	return idCategoria;
}
public void setIdCategoria(int idCategoria) {
	this.idCategoria = idCategoria;
}
public String getNomeCategoria() {
	return nomeCategoria;
}
public void setNomeCategoria(String nomeCategoria) {
	this.nomeCategoria = nomeCategoria;
}
public String getDescrizioneCategoria() {
	return descrizioneCategoria;
}
public void setDescrizioneCategoria(String descrizioneCategoria) {
	this.descrizioneCategoria = descrizioneCategoria;
}

}
