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
            repo.save(new Country(1l,"India"));
            repo.save(new Country(2L,"Armenia"));
            repo.save(new Country(3l,"Israel"));
            repo.save(new Country(4l, "Camerun"));
            repo.save(new Country(5l,"USA"));
            repo.save(new Country(6l,"United Kigndom"));
            repo.save(new Country(7l,"Albania"));

        };
    }
}
