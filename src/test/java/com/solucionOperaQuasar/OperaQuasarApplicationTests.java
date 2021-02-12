package com.solucionOperaQuasar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.solucionOperaQuasar.entity.Satellites;
import com.solucionOperaQuasar.repository.ISatelliteRepository;
import com.solucionOperaQuasar.rest.OperationRequest;
import com.solucionOperaQuasar.rest.OperationResponse;
import com.solucionOperaQuasar.rest.Position;
import com.solucionOperaQuasar.rest.Satellite;
import com.solucionOperaQuasar.service.IInterceptionSatelliteQuasar;
import com.solucionOperaQuasar.service.SMessageSatelliteQuasar;
import com.solucionOperaQuasar.utilities.ExceptionRestUtil;

@SpringBootTest
class OperaQuasarApplicationTests {

	/*Logger log = Logger.getLogger("test");

	@Autowired
	SMessageSatelliteQuasar smessage;

	@Autowired
	ISatelliteRepository sateliteRepo;

	@Autowired
	IInterceptionSatelliteQuasar interceptorService;

	public void intercept() throws Exception {

		var request = new OperationRequest();

		var satellites = new ArrayList<Satellite>();

		satellites.add(new Satellite(null, "kenobi", Arrays.asList("Este", "", "", "mensaje"), Double.valueOf(100.0)));
		satellites.add(
				new Satellite(null, "skywalker", Arrays.asList("", "es", "", "", "secreto"), Double.valueOf(115.5)));
		satellites.add(new Satellite(null, "sato", Arrays.asList("Este", "", "un", "", ""), Double.valueOf(142.7)));

		request.setSatellites(satellites);

		var response = interceptorService.transmitionSecret(request);

		assertEquals(response, new OperationResponse(new Position(-58.315, -69.551), response.getMessage()));

	}

	public void notEnoughTransmissions() throws Exception {

		var request = new OperationRequest();

		var satellites = new ArrayList<Satellite>();

		satellites.add(new Satellite(null, "kenobi", Arrays.asList("Este", "", "", "mensaje"), Double.valueOf(100.0)));
		satellites.add(
				new Satellite(null, "skywalker", Arrays.asList("", "es", "", "", "secreto"), Double.valueOf(115.5)));

		request.setSatellites(satellites);

		try {
			interceptorService.transmitionSecret(request);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Faltan Transmisiones");
		}

	}

	public void notEnoughMessages() throws Exception {

		var request = new OperationRequest();

		var satellites = new ArrayList<Satellite>();

		satellites.add(new Satellite(null, "kenobi", Arrays.asList("Este", "", "", "mensaje"), Double.valueOf(100.0)));
		satellites.add(
				new Satellite(null, "skywalker", Arrays.asList("", "es", "", "", "secreto"), Double.valueOf(115.5)));
		satellites.add(new Satellite(null, "sato", null, Double.valueOf(142.7)));
		request.setSatellites(satellites);

		try {
			interceptorService.transmitionSecret(request);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Un mensaje no logro ingresar");
		}

	}

	@Test
	public void singleSatellite() {
		Satellites sat = new Satellites();
		sat.setName("kenobi");
		sat.setDistance(142.7);
		List<String> message = Arrays.asList("este", "", "un", "", "");
		sat.setMessage(String.join(",", message));

		try {
			sateliteRepo.save(sat);
		} catch (Exception e) {

			assertEquals(e.getMessage(), "Error en el satelite enviado");
		}

	}

	@Test
	public void challengeExampleTest() throws ExceptionRestUtil {

		var messageList = new ArrayList<List<String>>();

		messageList.add(Arrays.asList("Este", "", "", "mensaje", ""));
		messageList.add(Arrays.asList("", "es", "", "", "secreto"));
		messageList.add(Arrays.asList("Este", "", "un", "", ""));

		String message = smessage.getMessage(messageList);

		assertEquals(message, "Este es un mensaje secreto");

	}*/

}
