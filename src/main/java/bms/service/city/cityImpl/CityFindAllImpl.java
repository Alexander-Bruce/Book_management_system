package bms.service.city.cityImpl;

import bms.domain.City;
import bms.mapper.CityMapper;
import bms.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityFindAllImpl implements CityService {

    @Autowired
    private CityMapper mapper;

    @Override
    public List<City> findAllCities() {
        return mapper.findAllCities();
    }
}
