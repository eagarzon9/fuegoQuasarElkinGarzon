package com.solucionOperaQuasar.service;

import com.solucionOperaQuasar.rest.OperationRequest;
import com.solucionOperaQuasar.rest.OperationResponse;
import com.solucionOperaQuasar.rest.Satellite;
import com.solucionOperaQuasar.utilities.ExceptionRestUtil;

/**
 * @author Elkin Garzón
 *
 */
public interface IInterceptionSatelliteQuasar {

	public OperationResponse transmitionSecret(OperationRequest request) throws ExceptionRestUtil;

	public Satellite transmisionSplitPost(Satellite request, String satelliteName) throws ExceptionRestUtil;

	public OperationResponse transmitionSecretSplit() throws ExceptionRestUtil;
}
