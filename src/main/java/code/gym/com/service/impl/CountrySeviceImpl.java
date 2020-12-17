package code.gym.com.service.impl;

import code.gym.com.model.Country;
import code.gym.com.repository.ICountryRepository;
import code.gym.com.service.ICountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountrySeviceImpl implements ICountyService {

    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findOneById(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);

    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
}
