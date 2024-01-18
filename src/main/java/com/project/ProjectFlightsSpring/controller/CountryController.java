package com.project.ProjectFlightsSpring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.ProjectFlightsSpring.data.CountryRepository;
import com.project.ProjectFlightsSpring.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller()
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    CountryRepository repo ;

    @GetMapping(value = "", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String helloWorld() {
        return "here country controller";
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Country helloWorld(@PathVariable("id") String param) throws JsonProcessingException {
        Optional<Country> country = repo.findById(param);
        System.out.println(country.getClass().getName());
        /*HashMap map = new HashMap<>();
        map.put("id", country.getId());
        map.put("name", country.getName());*/

        return  country.isPresent() ? country.get() : null;
    }

}
