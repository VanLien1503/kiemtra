package code.gym.com.repository;

import code.gym.com.model.City;
import code.gym.com.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICityRepository extends PagingAndSortingRepository<City,Long> {
    Iterable<City>findAllByCountry(Country country);
    City findOneById (Long id);
}
