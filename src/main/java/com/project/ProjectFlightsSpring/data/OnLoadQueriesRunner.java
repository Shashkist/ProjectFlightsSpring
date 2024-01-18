package com.project.ProjectFlightsSpring.data;

import com.project.ProjectFlightsSpring.model.Country;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OnLoadQueriesRunner {

    @Bean
    public CommandLineRunner dataLoader(CountryRepository repo) {
        return args -> {
            repo.save(new Country("1","India"));
            repo.save(new Country("2","Armenia"));
            repo.save(new Country("3","Israel"));
            repo.save(new Country("4", "Camerun"));
            repo.save(new Country("5","USA"));
            repo.save(new Country("6","United Kigndom"));
            repo.save(new Country("7","Albania"));

        };
    }
}
