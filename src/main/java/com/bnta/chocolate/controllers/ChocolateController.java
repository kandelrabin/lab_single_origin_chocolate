package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/chocolate")
public class ChocolateController {


    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;


    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam Optional<Integer> cocoaPercentage){
        List<Chocolate> chocolates;

        if(cocoaPercentage.isPresent()){
            chocolates = chocolateService.getChocolatesWithCocoaPercentageLessThan(cocoaPercentage.get());

        } else {
            chocolates = chocolateService.getAllChocolates();
        }
        return new ResponseEntity<>(chocolates,HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable long id){
        Optional<Chocolate> chocolateOptional = chocolateService.getChocolateById(id);

        if (chocolateOptional.isPresent()){
            return new ResponseEntity<>(chocolateOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Chocolate> addNewChocolate(@RequestBody ChocolateDTO chocolateDTO){
        String name = chocolateDTO.getName();
        int cocoaPercentage = chocolateDTO.getCocoaPercentage();
        long estateId = chocolateDTO.getEstateId();
        Estate estate = estateService.getEstateById(estateId).get();
        Chocolate chocolate = new Chocolate(name, cocoaPercentage, estate);
        chocolateService.addNewChocolate(chocolate);
        return new ResponseEntity<>(chocolate, HttpStatus.OK);
    }



}
