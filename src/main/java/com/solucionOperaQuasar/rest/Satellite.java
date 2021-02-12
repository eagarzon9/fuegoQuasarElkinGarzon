package com.solucionOperaQuasar.rest;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solucionOperaQuasar.entity.Satellites;

import io.swagger.annotations.ApiModelProperty;

public class Satellite {

	@ApiModelProperty(value = "Lugar situado del Satélite", name = "position", required = false)
	private Position position;

	@ApiModelProperty(notes = "Nombre del Satélite", name = "name", required = false)
	private String name;

	@ApiModelProperty(notes = "Mensaje recibido", name = "message", required = false)
	private List<String> message;

	@ApiModelProperty(notes = "Distancia del mensaje", name = "distance", required = false)
	private double distance;

	@JsonIgnore
	public Satellite(Satellites entity) {
		this.position = new Position(entity.getX(), entity.getY());
		this.name = entity.getName();
		this.message = Arrays
				.asList(entity.getMessage() != null ? entity.getMessage().split(",", -1) : new String[] {});
		this.distance = entity.getDistance() != null ? entity.getDistance() : 0;
	}

	public Satellite() {

	}

	public Satellite(Position position, String name, List<String> message, double distance) {
		super();
		this.position = position;
		this.name = name;
		this.message = message;
		this.distance = distance;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
