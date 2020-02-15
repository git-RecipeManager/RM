package com.manager.recipe.model;

import java.io.Serializable;

public class IngredientBean  implements Serializable{

private static final long serialVersionUID = -8549592960594887792L;
private int idIngrediente;
private String nome;
private String metrica;
private int quantità;

public IngredientBean() {
	super();
}

public int getIdIngrediente() {
	return idIngrediente;
}
public void setIdIngrediente(int idIngrediente) {
	this.idIngrediente = idIngrediente;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getMetrica() {
	return metrica;
}
public void setMetrica(String metrica) {
	this.metrica = metrica;
}

public int getQuantità() {
	return quantità;
}

public void setQuantità(int quantità) {
	this.quantità = quantità;
}

}
