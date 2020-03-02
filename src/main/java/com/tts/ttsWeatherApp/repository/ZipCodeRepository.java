package com.tts.ttsWeatherApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.ttsWeatherApp.model.ZipCodes;


@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCodes, Long>{
	
}
