package com.project.ProjectFlightsSpring.controller;

import com.project.ProjectFlightsSpring.View.SearchFlightPVO;
import com.project.ProjectFlightsSpring.data.FlightsRepository;
import com.project.ProjectFlightsSpring.model.Flight;
import com.project.ProjectFlightsSpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/flight")
public class FlightsController {

    @Autowired
    FlightsRepository flightsRepository;

    @GetMapping(value = "/" )
    public String flightsPage(Model model,@ModelAttribute("registeredUser") User registeredUser) {
        model.addAttribute("registeredUser", registeredUser);
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

    @GetMapping(value = "/searchFlight/")
    public String searchFlight(@ModelAttribute SearchFlightPVO searchFlightPVO, Model model) {

        return "searchFlight";
    }

    @PostMapping(value = "/filterFlights/")

    public String presentFilteredFlights(Model model, SearchFlightPVO searchFlightPVO) {

        model.addAttribute("filteredFlights", filterFlights(searchFlightPVO, model));

        return "searchFlight";
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


    private List<Flight> filterFlights(SearchFlightPVO searchFlightPVO, Model model) {
        List<Flight> flights = (List<Flight>) model.getAttribute("flights");
        List<Flight> filteredFlights = new ArrayList<>();
        if (flights != null && searchFlightPVO != null) {
            filteredFlights = flights.stream().
                    //filter for number of tickets
                    filter(flight -> {
                        // Perform null checks for properties of the Flight object and the SearchFlightPVO object
                        return  searchFlightPVO.getNumberOfTickets() != null &&
                                flight != null &&
                                searchFlightPVO.getNumberOfTickets() < flight.getRemainingTickets();
                    }).
                    //filter for origin name
                    filter(flight -> {
                        // Perform null checks for properties of the Flight object and the SearchFlightPVO object
                        return  (searchFlightPVO.getFrom() == null || "".equals(searchFlightPVO.getFrom())) ||
                                (flight.getOriginCountry() != null &&
                                searchFlightPVO.getFrom().equals(flight.getOriginCountry().getName()));
                    }).
                    collect(Collectors.toList());
            //TODO add more filters
        }
        return filteredFlights;
    }

    @ModelAttribute("flights")
    public Iterable<Flight> populateflights() {
        return  flightsRepository.findAll();
    }




}
