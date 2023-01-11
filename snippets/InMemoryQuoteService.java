package com.example.api.quotes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

@Service
class InMemoryQuoteService implements QuoteService {

   private final Quote[] quotes;
   private final Random random = new Random();

    public InMemoryQuoteService() throws IOException {
        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("quotes.json");

        ObjectMapper mapper = new ObjectMapper();
        this.quotes = mapper.readValue(in,Quote[].class);
    }

    public Quote randomQuote() {
        int index = this.random.nextInt(quotes.length);
        return quotes[index];
    }
}
