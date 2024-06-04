package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {


    @Autowired
    ChocolateRepository chocolateRepository;


//    Add new Chocolate
    public Chocolate addNewChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }

//    Get all the chocolates
    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }

//    Get chocolate by id
    public Optional<Chocolate> getChocolateById(long id){
        return chocolateRepository.findById(id);
    }

//    Get ALL chocolates that are less than a certain value

    public List<Chocolate> getChocolatesWithCocoaPercentageLessThan(int cocoaPercentage){
        return chocolateRepository.findByCocoaPercentageLessThan(cocoaPercentage);
    }



}
