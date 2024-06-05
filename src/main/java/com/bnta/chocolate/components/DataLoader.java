package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    EstateRepository estateRepository;

   @Autowired
    ChocolateRepository chocolateRepository;


   @Override
    public void run (ApplicationArguments args) throws Exception {

      Estate london = new Estate("London Estate", "UK");
      estateRepository.save(london);
      Estate birmingham = new Estate("Birmingham Estate", "UK");
      estateRepository.save(birmingham);
      Estate edinbrugh = new Estate("Edinbrugh Estate", "UK");
      estateRepository.save(edinbrugh);
      Estate paris = new Estate("Paris Estate", "France");
      estateRepository.save(paris);
      Estate buenosAries = new Estate("Buenos Aries Estate", "Argentina");
      estateRepository.save(buenosAries);

       chocolateRepository.save(new Chocolate("bounty",10, london));
       chocolateRepository.save(new Chocolate("Mars",30, edinbrugh));
       chocolateRepository.save(new Chocolate("cadbury",70, birmingham));
       chocolateRepository.save(new Chocolate("Kinder Bueno",20, paris));
   }

}
