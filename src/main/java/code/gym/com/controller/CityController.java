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
public class CityController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountyService countyService;

    @ModelAttribute("Country")
    public Iterable<Country>countryIterable(){
        return countyService.findAll();
    }
    // Tao 1 city
    @GetMapping("/creat-city")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("city/creatCity");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/creat-city")
    public ModelAndView saveCity(@ModelAttribute("city") City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/creatCity");
        modelAndView.addObject("customer", new City());
        modelAndView.addObject("message", "Them Thanh Cong");
        return modelAndView;
    }
    @PostMapping("/edit-city")
    public ModelAndView updatecity(@ModelAttribute("city") City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "xua Thanh Cong");
        return modelAndView;
    }
    @GetMapping("/delete-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        cityService.remove(id);
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("city", cities);
        return modelAndView;

    }

}
