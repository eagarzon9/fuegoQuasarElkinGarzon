package com.solucionOperaQuasar.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Elkin Garzon
 *
 */
public class Position {

	@ApiModelProperty(value = "Posición X", name = "x", dataType = "double", required = false)
	private double x;

	@ApiModelProperty(value = "Posición  Y", name = "y", dataType = "double", required = false)
	private double y;

	@JsonIgnore
	public double[] getPoint() {
		return new double[] { x, y };
	}
	
	public Position(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}



	
	
}
