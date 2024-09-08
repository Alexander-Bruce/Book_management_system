package bms.service.impl;

import bms.domain.City;
import bms.mapper.CityMapper;
import bms.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper citymapper;

    @Override
    public List<City> findAllCities() {
        return citymapper.findAllCities();
    }
}
