package com.solucionOperaQuasar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="satellite")
public class Satellites {

	@Id
	@Column(name = "name")
	private String name;
	@Column(name = "distance")
	private Double distance;
	@Column(name = "x")
	private Double x;
	@Column(name = "y")
	private Double y;
	@Column(name = "message")
	private String message;
	
	public Satellites(){
		
	}

	public Satellites(String name, Double distance, Double x, Double y, String message) {
		super();
		this.name = name;
		this.distance = distance;
		this.x = x;
		this.y = y;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
