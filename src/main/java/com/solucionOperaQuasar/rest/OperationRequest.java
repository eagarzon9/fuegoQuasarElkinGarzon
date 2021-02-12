package com.solucionOperaQuasar.rest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Asesoftware
 * Clase que manipula las operaciones del satélite 
 *
 */
public class OperationRequest {

	private List<Satellite> satellites;

	public OperationRequest(List<Satellite> satellites) {
		super();
		this.satellites = satellites;
	}

	public OperationRequest() {
 
	}

	public double[][] getPositions() {
		List<Position> positions = satellites.stream().map(Satellite::getPosition).collect(Collectors.toList());
		double[][] points = new double[positions.size()][];
		for (int i = 0; i < positions.size(); i++) {
			points[i] = positions.get(i).getPoint();
		}
		return points;
	}

	public double[] getDistances() {
		List<Double> distances = satellites.stream().map(Satellite::getDistance).collect(Collectors.toList());
		return distances.stream().mapToDouble(d -> d).toArray();
	}

	public List<List<String>> getMessages() {
		return satellites.stream().map(Satellite::getMessage).collect(Collectors.toList());
	}

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}

}
