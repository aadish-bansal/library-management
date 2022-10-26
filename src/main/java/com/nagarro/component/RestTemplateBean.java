package com.nagarro.component;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateBean {
    public  RestTemplate restTemplate= new RestTemplate();

}
