package code.gym.com.service.impl;

import code.gym.com.model.City;
import code.gym.com.model.Country;
import code.gym.com.repository.ICityRepository;
import code.gym.com.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

    @Autowired
    private ICityRepository cityRepository;
    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOneById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);

    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Iterable<City> findByCountry(Country country) {
        return cityRepository.findAllByCountry(country);
    }
}
