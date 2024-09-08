package bms.controller;

import bms.domain.City;
import bms.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import bms.service.city.cityImpl.CityFindAllImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;


    @GetMapping("/find")
    public List<City> findAllCities() {
        return cityService.findAllCities();
    }

}
