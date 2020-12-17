package code.gym.com.controller;

import code.gym.com.model.City;
import code.gym.com.model.Country;
import code.gym.com.service.ICityService;
import code.gym.com.service.ICountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountyService countyService;
    // Tao Moi Quoc Gia
    @GetMapping("/creat-country")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/country/creatCountry");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }
    @PostMapping("/create-country")
    public ModelAndView saveProvince(@ModelAttribute("country") Country country){
        countyService.save(country);
        ModelAndView modelAndView = new ModelAndView("/country/creatCountry");
        modelAndView.addObject("country", new Country());
        modelAndView.addObject("message", "Them moi 1 PROVINCE Thanh Cong");
        return modelAndView;
    }

    // list city
    @GetMapping("/listCity")
    public ModelAndView listCustomers(){
        Iterable<City> cityIterable = cityService.findAll();
        Iterable<Country>countryIterable=countyService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("city", cityIterable);
        modelAndView.addObject("country", countryIterable);
        return modelAndView;
    }
    //edit
    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        City city = cityService.findById(id);
            ModelAndView modelAndView = new ModelAndView("city/edit");
            modelAndView.addObject("city", city);
            return modelAndView;

    }


}
