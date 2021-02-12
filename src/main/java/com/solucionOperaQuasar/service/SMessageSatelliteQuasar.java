package com.solucionOperaQuasar.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.solucionOperaQuasar.utilities.ExceptionRestUtil;
/**
 * @author Elkin Garzón
 *
 */
@Service
public class SMessageSatelliteQuasar {
	
	/**
	 * @param messages
	 * @return mensaje
	 * @throws ExceptionRestUtil
	 */
	public String getMessage(List<List<String>> messages) throws ExceptionRestUtil {
		if (messages.size() != 3)
			throw new ExceptionRestUtil("Upss!!, Se necesitan tres mensajes");
		return decryptMessage(messages);
	}

	
	private String decryptMessage(List<List<String>> messages) {
		List<String> decryptionMessage = new ArrayList<>();
		for (List<String> message : messages) {
			for (int i = 0; i < message.size(); i++) {
				if (decryptionMessage.size() <= i)
					decryptionMessage.add("");
				if (!"".equals(message.get(i))) {
					decryptionMessage.set(i, message.get(i));
				}
			}
		}

		return String.join(" ", decryptionMessage);
	}

}
