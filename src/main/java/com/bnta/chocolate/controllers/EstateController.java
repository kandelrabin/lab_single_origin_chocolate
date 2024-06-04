package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estate")
public class EstateController {


    @Autowired
    EstateService estateService;


    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstate(){
        List<Estate> estates = estateService.getAllEstates();
        if(estates.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(estates, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estate> getEstateById(@PathVariable long id){
        Optional<Estate> estateOptional = estateService.getEstateById(id);

        if (estateOptional.isPresent()){
            return new ResponseEntity<>(estateOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
