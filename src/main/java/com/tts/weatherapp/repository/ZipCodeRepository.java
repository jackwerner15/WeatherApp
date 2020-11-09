package com.tts.weatherapp.repository;

import java.util.List;

import com.tts.weatherapp.model.ZipCode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {
    List<ZipCode> findAll();
    
}
