package com.deliveryboy.controller;

import com.deliveryboy.service.KafkaService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private KafkaService service;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        this.service.updateLocation("("+Math.round(Math.random()*100)+" , "+Math.round(Math.random()*100)+")");
        this.logger.info("Location Recevied");
        return new ResponseEntity<>(Map.of("Message","LocationUpdated"), HttpStatus.OK);

    }

}
