package com.example.wsbfinalproject2023.config;

import com.example.wsbfinalproject2023.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class Boostrap implements InitializingBean {

    private PersonService personService;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Startujemy...");

        personService.saveAdmin();
    }
}
