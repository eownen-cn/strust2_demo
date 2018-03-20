package com.example.struts.bean;

import java.io.Serializable;

public class Fruit implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id ;
	private String name ;
	private double price ;
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final double getPrice() {
		return price;
	}
	public final void setPrice(double price) {
		this.price = price;
	}
	public Fruit(String id, String name, double price) {
		this(name,price) ;
		this.id = id;
	}
	public Fruit(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public Fruit() {
		super();
	}
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
