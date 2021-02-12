package com.solucionOperaQuasar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucionOperaQuasar.entity.Satellites;
import com.solucionOperaQuasar.repository.ISatelliteRepository;
import com.solucionOperaQuasar.rest.OperationRequest;
import com.solucionOperaQuasar.rest.OperationResponse;
import com.solucionOperaQuasar.rest.Satellite;
import com.solucionOperaQuasar.utilities.ExceptionRestUtil;

/**
 * @author Elkin Garzón
 *
 */
@Service
public class SInterceptionSateliteQuasar implements IInterceptionSatelliteQuasar {

	@Autowired
	SLocationSatelliteQuasar sLocationSatelliteQuasar;

	@Autowired
	SMessageSatelliteQuasar sMessageSatelliteQuasar;

	@Autowired
	ISatelliteRepository iSatelliteRepository;

	@Autowired
	ISatelliteRepository sateliteRepo;

	Logger log = Logger.getLogger("test");

	/**
	 * Método para manejo de posición y decodificación del mensaje para transmisión
	 * de los satélites
	 * 
	 * @param request
	 * @return result
	 * @exception ExceptionRestUtil
	 */
	@Override
	public OperationResponse transmitionSecret(OperationRequest request) throws ExceptionRestUtil {
		OperationResponse result = new OperationResponse();
		result.setPosition(sLocationSatelliteQuasar.getInterception(request));
		result.setMessage(sMessageSatelliteQuasar.getMessage(request.getMessages()));
		return result;
	}

	/**
	 * Método para manejo de posición y decodificación del mensaje para transmisión
	 * de un satélite
	 * 
	 * @param request
	 * @param satelliteName
	 * @return Satellite
	 * @exception ExceptionRestUtil
	 */
	@Override
	public Satellite transmisionSplitPost(Satellite request, String satelliteName) throws ExceptionRestUtil {
		initialDates(satelliteName);
		Optional<Satellites> satellitesOptional = iSatelliteRepository.findById(satelliteName);
		if (satellitesOptional.isPresent()) {
			Satellites satellites = satellitesOptional.get();
			satellites.setDistance(request.getDistance());
			satellites.setMessage(String.join(",", request.getMessage()));
			iSatelliteRepository.save(satellites);
			return new Satellite(satellites);
		} else {
			throw new ExceptionRestUtil("Error: No existe el satellite, no se puede procesar la información");
		}
	}

	/**
	 * Método para manejo de posición y decodificación del mensaje para transmisión
	 * de un satélite
	 * 
	 * @return Satellite
	 */
	@Override
	public OperationResponse transmitionSecretSplit() throws ExceptionRestUtil {
		List<Satellites> satellitesList = iSatelliteRepository.findAll();
		List<Satellite> satelliteList = new ArrayList<>();
		satellitesList.forEach(satellites -> satelliteList.add(new Satellite(satellites)));
		return transmitionSecret(new OperationRequest(satelliteList));
	}

	/**
	 * Método para cargar satélites Base Meli
	 *
	 */
	public void initialDates(String satelliteName) {
		List<Satellites> satelittes = new ArrayList<Satellites>();
		Optional<Satellites> satellitesOptional = iSatelliteRepository.findById(satelliteName);
		if (satellitesOptional.isPresent()) {
			if (satelliteName.equals("kenobi"))
				satelittes.add(new Satellites(satelliteName, null, Double.valueOf(-500), Double.valueOf(-200), null));
			if (satelliteName.equals("skywalker"))
				satelittes.add(new Satellites(satelliteName, null, Double.valueOf(100), Double.valueOf(-100), null));
			if (satelliteName.equals("sato"))
				satelittes.add(new Satellites(satelliteName, null, Double.valueOf(500), Double.valueOf(100), null));
			sateliteRepo.saveAll(satelittes);
		}

		
	}

}
