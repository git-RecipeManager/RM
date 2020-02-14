package com.manager.recipe.controller;

import java.io.Serializable;

public class Prompt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -6431065258473302569L;
	
	public Prompt() {}
public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getShortMessage() {
		return shortMessage;
	}
	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.message;
	}

private String message;
private int code;
private String shortMessage;
private int line;
private String url;
}
