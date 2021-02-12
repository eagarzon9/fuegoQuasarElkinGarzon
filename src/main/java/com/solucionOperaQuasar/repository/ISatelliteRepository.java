package com.solucionOperaQuasar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solucionOperaQuasar.entity.Satellites;

/**
 * @author Elkin Garzon
 *
 */
public interface ISatelliteRepository extends JpaRepository<Satellites, String> {	
		
}
