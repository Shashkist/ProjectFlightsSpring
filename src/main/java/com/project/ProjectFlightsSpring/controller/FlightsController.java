package com.project.ProjectFlightsSpring.controller;

import com.project.ProjectFlightsSpring.data.AirlineCompanyRepository;
import com.project.ProjectFlightsSpring.data.CountryRepository;
import com.project.ProjectFlightsSpring.data.FlightsRepository;
import com.project.ProjectFlightsSpring.model.AirlineCompany;
import com.project.ProjectFlightsSpring.model.Country;
import com.project.ProjectFlightsSpring.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller()
@RequestMapping("/api/flight")
public class FlightsController {

    @Autowired
    FlightsRepository flightsRepository;
    @Autowired
    CountryRepository countryRepository;

    @Autowired
    AirlineCompanyRepository airlineCompanyRepository;

    @GetMapping(value = "/" )
    public String flightsPage(Model model) {
//        model.addAttribute("flights", flightsRepository.findAll());
        return "flights";
    }

   @GetMapping(value = "/deleteFlight/{id}")
   public String deleteFlight(@PathVariable("id") String param) {
        flightsRepository.deleteById(param);
        return "redirect:/api/flight/";
   }

    @GetMapping(value = "/addFlight/")
    public String addFlight(@ModelAttribute Flight flight) {
        return "editFlight";
    }


    @PostMapping(value ="/editFlight/{id}")
    public String editFlight(@PathVariable("id") String param, Model model) {
        Flight fl = flightsRepository.findById(param).get();
        model.addAttribute("flight", fl);
        return "editFlight";
    }


    @PostMapping(value = "/finishUpdate/{id}")
    public String finishUpdateFlight(@PathVariable(name = "id", required = false)  String param, @ModelAttribute Flight flight) {
        if (flight.getId().equals("")) {
            flight.setId(null);
        }
        flightsRepository.save(flight);

        return "redirect:/api/flight/";
    }

    @PostMapping(value = "/finishUpdate/")
    public String finishAddFlight(@PathVariable(name = "id", required = false)  String param, @ModelAttribute Flight flight) {

        if (flight.getId().equals("")) {
            flight.setId(null);
        }
        flightsRepository.save(flight);

        return "redirect:/api/flight/";
    }

    @ModelAttribute("flights")
    public Iterable<Flight> populateflights() {
        return  flightsRepository.findAll();
    }

    public Country saveOrUpdateCountry(Country country, Flight flight) {
        Country newCountry = country;
        if (country != null) {
            // Country exists, use the existing country as a reference
            flight.setOriginCountry(country);
        } else {
            // Country doesn't exist, create a new one
            newCountry = new Country(flight.getOriginCountry().getName());
            countryRepository.save(newCountry);
            flight.setOriginCountry(newCountry);
        }
        return country;
    }
}
