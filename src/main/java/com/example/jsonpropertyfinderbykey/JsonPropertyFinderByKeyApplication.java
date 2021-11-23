package com.example.jsonpropertyfinderbykey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JsonPropertyFinderByKeyApplication
{

    public static void main(String[] args)
    {
        ConfigurableApplicationContext run = SpringApplication.run(
            JsonPropertyFinderByKeyApplication.class, args);
        run.getBean(JsonObjectProcessComponent.class).printData();
    }

}
