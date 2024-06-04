package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

   @Autowired
   ChocolateService chocolateService;

   @Autowired
   EstateService estateService;


   @Override
    public void run (ApplicationArguments args) throws Exception {

      Estate london = new Estate("London Estate", "UK");
      estateService.addNewEstate(london);
      Estate birmingham = new Estate("Birmingham Estate", "UK");
      estateService.addNewEstate(birmingham);
      Estate edinbrugh = new Estate("Edinbrugh Estate", "UK");
      estateService.addNewEstate(edinbrugh);
      Estate paris = new Estate("Paris Estate", "France");
      estateService.addNewEstate(paris);
      Estate buenosAries = new Estate("Buenos Aries Estate", "Argentina");
      estateService.addNewEstate(buenosAries);

       chocolateService.addNewChocolate(new Chocolate("bounty",10, london));
       chocolateService.addNewChocolate(new Chocolate("Mars",30, edinbrugh));
       chocolateService.addNewChocolate(new Chocolate("cadbury",70, birmingham));
       chocolateService.addNewChocolate(new Chocolate("Kinder Bueno",20, paris));
   }

}
