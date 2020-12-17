package code.gym.com.service;

import code.gym.com.model.City;
import code.gym.com.model.Country;

public interface ICityService {
    Iterable<City> findAll();
    City findById (Long id);
    void save (City city);
    void remove(Long id);
    Iterable<City>findByCountry(Country country);
}
