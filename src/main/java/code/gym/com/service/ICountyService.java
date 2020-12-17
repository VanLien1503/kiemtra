package code.gym.com.service;

import code.gym.com.model.Country;

public interface ICountyService {
    Iterable<Country>findAll();
    Country findById (Long id);
    void save (Country country);
    void remove(Long id);
}
