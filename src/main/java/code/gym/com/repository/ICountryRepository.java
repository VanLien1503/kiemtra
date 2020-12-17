package code.gym.com.repository;

import code.gym.com.model.City;
import code.gym.com.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICountryRepository extends PagingAndSortingRepository<Country ,Long> {
    Country findOneById (Long id);

}
