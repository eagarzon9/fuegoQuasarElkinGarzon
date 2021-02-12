package com.solucionOperaQuasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solucionOperaQuasar.rest.OperationResponse;
import com.solucionOperaQuasar.rest.Satellite;
import com.solucionOperaQuasar.service.IInterceptionSatelliteQuasar;
import com.solucionOperaQuasar.utilities.ExceptionRestUtil;

import io.swagger.annotations.ApiOperation;

/**
 * @author Elkin Garzón RestController para servicio /topsecret_split/ 
 * POST:
 *         Detección de un mensaje por un satélite Transmisión única. 
 * GET:
 *         Decodificación de los últimos mensajes que no fueron decodificados o
 *         deprecados por antiguedad. *
 */
@RestController
@RequestMapping(path = "/topsecret_split/")
public class QuasarTransmisionSplitController {

	@Autowired
	IInterceptionSatelliteQuasar interceptionSatelite;

	@ApiOperation(value = "Intercepción mediante un satélite de una transmisión única")
	@RequestMapping(value = "{satellite_name}", method = RequestMethod.POST)
	public ResponseEntity<Satellite> topSecretSplit(@PathVariable("satellite_name") String satelliteName,
			@RequestBody Satellite request) {

		if (request == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		try {
			Satellite result = interceptionSatelite.transmisionSplitPost(request, satelliteName);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (ExceptionRestUtil e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@ApiOperation(value = "Ultimas transmisiones recibidas para decodificar ")
	@GetMapping
	public ResponseEntity<OperationResponse> topSecretSplitGet() {
		OperationResponse result;

		try {
			result = interceptionSatelite.transmitionSecretSplit();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (ExceptionRestUtil e) {
			result = new OperationResponse();
			result.setMessage("No hay suficiente información");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
	}

}
