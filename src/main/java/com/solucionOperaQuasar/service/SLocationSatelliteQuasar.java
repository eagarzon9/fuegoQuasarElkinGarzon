package com.solucionOperaQuasar.service;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.solucionOperaQuasar.rest.OperationRequest;
import com.solucionOperaQuasar.rest.Position;
import com.solucionOperaQuasar.rest.Satellite;
import com.solucionOperaQuasar.utilities.ExceptionRestUtil;
import com.solucionOperaQuasar.utilities.TrilaterationUtil;

/**
 * @author Elkin Garzón
 *
 */
@Service
public class SLocationSatelliteQuasar {

	@Autowired
	Environment environment;

	/**
	 * Método para tener la posicion X Y de un satélite
	 * 
	 * @param request
	 * @return Position
	 * @exception ExceptionRestUtil
	 */
	public Position getInterception(OperationRequest request) throws ExceptionRestUtil {
		if (request.getSatellites().size() != 3) {
			throw new ExceptionRestUtil("Ups!!, No se encontró tres satélites");
		}
		replacePosition(request);
		double[] distances = request.getDistances();
		double[][] locations = request.getPositions();
		double[] point = TrilaterationUtil.getLocation(locations, distances);
		return new Position(point[0], point[1]);
	}

	/**
	 * Método para obtener la información base de los satélite, se lee archivo en el
	 * environment para leer la información de las posiciones del satélite.
	 * Utilizando algoritmo Lambda to convert Number[][] to double[][]
	 * 
	 * @param request
	 * @return x.y
	 * @exception ExceptionRestUtil
	 */
	private void replacePosition(OperationRequest request) {
		for (Satellite satellite : request.getSatellites()) {
			String[] pos = Objects.requireNonNull(environment.getProperty("satellite." + satellite.getName()))
					.split(",");
			double[] position = Arrays.stream(pos).mapToDouble(Double::parseDouble).toArray();
			satellite.setPosition(new Position(position[0], position[1]));
		}
	}

}
