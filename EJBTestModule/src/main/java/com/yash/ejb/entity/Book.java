package com.yash.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 4731478485822491194L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name="id")
	
	private int id;
	private String name;
	
	   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	   
	   
	

}
