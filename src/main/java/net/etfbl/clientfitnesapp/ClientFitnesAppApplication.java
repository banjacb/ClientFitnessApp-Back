package net.etfbl.clientfitnesapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientFitnesAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientFitnesAppApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper()
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper;
    }
}
