package bms.controller;

import bms.domain.City;
import bms.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
