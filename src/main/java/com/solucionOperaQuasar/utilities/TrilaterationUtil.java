package com.solucionOperaQuasar.utilities;

import org.springframework.stereotype.Component;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

/**
 * @author Elkin Garzon - Implementación de la librería Trilateration segun fuente
 *         de Git Documentación
 */
@Component
public class TrilaterationUtil {

	/**
	 * Función que retorna la posición dando las coordenadas "location" y las
	 * distancias "distances"
	 * 
	 * @param locations
	 * @param distances
	 * 
	 * @return posicionamiento (x,y) del que emite el mensaje
	 */
	public static double[] getLocation(double[][] locations, double[] distances) {

		TrilaterationFunction trilaterationFunction = new TrilaterationFunction(locations, distances);
		NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction,
				new LevenbergMarquardtOptimizer());

		return nSolver.solve().getPoint().toArray();
	}
}
