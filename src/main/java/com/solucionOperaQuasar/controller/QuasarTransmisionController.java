package com.solucionOperaQuasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucionOperaQuasar.rest.OperationRequest;
import com.solucionOperaQuasar.rest.OperationResponse;
import com.solucionOperaQuasar.service.IInterceptionSatelliteQuasar;
import com.solucionOperaQuasar.utilities.ExceptionRestUtil;

import io.swagger.annotations.ApiOperation;

/*
* @author Elkin Garzon
* 
* Controller - Servicio /topsecret/
* POST: Detección de un mensaje entre satélites
* 		transmisión múltiple y tratamiento de decodificación.
* 
*/
@RestController
@RequestMapping(path = "/topsecret/")
public class QuasarTransmisionController {

	@Autowired
	IInterceptionSatelliteQuasar interceptionSatelite;

	@ApiOperation(value = "Paso de la prueba para Nivel 2 fuego de Quasar, Recepción y decodificación de la trasmisión múltiple ")
	@PostMapping
	public ResponseEntity<OperationResponse> topSecret(@RequestBody OperationRequest request) {

		if (request == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		try {
			OperationResponse result = interceptionSatelite.transmitionSecret(request);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (ExceptionRestUtil e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
