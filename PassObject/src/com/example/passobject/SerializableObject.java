package com.example.passobject;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SerializableObject implements Serializable{

	 private final String text;
	
	 public SerializableObject(String text){
	  this.text = text;
	 }
	
	 public String getText(){
	  return text;
	 }

}
