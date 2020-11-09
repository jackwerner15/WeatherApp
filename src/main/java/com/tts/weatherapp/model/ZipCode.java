package com.tts.weatherapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ZipCode {
    
    @OneToOne(cascade = CascadeType.ALL)
    private List<ZipCode> zipCodes;

}
