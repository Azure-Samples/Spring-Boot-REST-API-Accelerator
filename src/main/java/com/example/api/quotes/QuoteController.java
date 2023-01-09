package com.example.api.quotes;

import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    private final QuoteService quoteService;
    private final Environment environment;

    public QuoteController(QuoteService quoteRepository, Environment environment) {
        this.quoteService = quoteRepository;
        this.environment = environment;
    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public Quote randomQuote()
    {
        Quote result = quoteService.randomQuote();
        if(CloudPlatform.KUBERNETES.isActive(environment)) {
            result.setK8s(true);
        }
        return result;
    }
}
