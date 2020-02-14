package com.manager.recipe.model;

import java.io.Serializable;

public class ListingProductBean implements Serializable {

	private static final long serialVersionUID = -789406114388837959L;
	private int idProdotto;
	private String nomeProdotto;
	private String descrizioneBreveProdotto;
	private String descrizioneDettagliataProdotto;
	private String imgThumbProdotto;
	private String imgFullProdotto;
	private double prezzoProdotto;
	private int Categoria_idCategoria;
	private String unita_misura;
	private int valore_misurato;
	
	public int getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	public String getDescrizioneBreveProdotto() {
		return descrizioneBreveProdotto;
	}
	public void setDescrizioneBreveProdotto(String descrizioneBreveProdotto) {
		this.descrizioneBreveProdotto = descrizioneBreveProdotto;
	}
	public String getDescrizioneDettagliataProdotto() {
		return descrizioneDettagliataProdotto;
	}
	public void setDescrizioneDettagliataProdotto(String descrizioneDettagliataProdotto) {
		this.descrizioneDettagliataProdotto = descrizioneDettagliataProdotto;
	}
	public String getImgThumbProdotto() {
		return imgThumbProdotto;
	}
	public void setImgThumbProdotto(String imgThumbProdotto) {
		this.imgThumbProdotto = imgThumbProdotto;
	}
	public String getImgFullProdotto() {
		return imgFullProdotto;
	}
	public void setImgFullProdotto(String imgFullProdotto) {
		this.imgFullProdotto = imgFullProdotto;
	}
	public double getPrezzoProdotto() {
		return prezzoProdotto;
	}
	public void setPrezzoProdotto(double prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}
	public int getCategoria_idCategoria() {
		return Categoria_idCategoria;
	}
	public void setCategoria_idCategoria(int categoria_idCategoria) {
		Categoria_idCategoria = categoria_idCategoria;
	}
	public String getUnita_misura() {
		return unita_misura;
	}
	public void setUnita_misura(String unita_misura) {
		this.unita_misura = unita_misura;
	}
	public int getValore_misurato() {
		return valore_misurato;
	}
	public void setValore_misurato(int valore_misurato) {
		this.valore_misurato = valore_misurato;
	}
	
	
}
