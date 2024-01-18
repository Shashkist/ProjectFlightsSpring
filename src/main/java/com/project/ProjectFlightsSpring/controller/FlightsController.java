package com.project.ProjectFlightsSpring.controller;

import com.project.ProjectFlightsSpring.data.FlightsRepository;
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

    @GetMapping(value = "/" )
    public String flightsPage(Model model) {
//        model.addAttribute("flights", flightsRepository.findAll());
        return "flights";
    }

   @GetMapping(value = "/deleteFlight/{id}")
   public String deleteFlight(@PathVariable("id") String param) {
        flightsRepository.deleteById(Long.valueOf(param));
        return "redirect:/api/flight/";
   }

    @GetMapping(value = "/addFlight/")
    public String addFlight(@ModelAttribute Flight flight) {
        return "editFlight";
    }


    @PostMapping(value ="/editFlight/{id}")
    public String editFlight(@PathVariable("id") String param, Model model) {
        List<Flight> flightList = (List<Flight>) model.getAttribute("flights");
        Flight flight = flightList.stream().filter((f) -> f.getId().equals(Long.valueOf(param))).findFirst().get();
        model.addAttribute("flight", flight);
        return "editFlight";
    }


    @PostMapping(value = "/finishUpdate/{id}")
    public String finishUpdateFlight(@PathVariable(name = "id", required = false)  String param, @ModelAttribute Flight flight) {
        flight.getId();
        flightsRepository.save(flight);

        return "redirect:/api/flight/";
    }

    @PostMapping(value = "/finishUpdate/")
    public String finishAddFlight(@PathVariable(name = "id", required = false)  String param, @ModelAttribute Flight flight) {
        flight.getId();
        flightsRepository.save(flight);

        return "redirect:/api/flight/";
    }

    @ModelAttribute("flights")
    public Iterable<Flight> populateflights() {
        return  flightsRepository.findAll();
    }

}
