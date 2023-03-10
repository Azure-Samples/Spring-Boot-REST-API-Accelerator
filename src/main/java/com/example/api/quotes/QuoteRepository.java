package com.example.api.quotes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface QuoteRepository extends JpaRepository<QuoteEntity,Integer> {

    @Query( nativeQuery = true, value =
            "SELECT id,quote,author FROM quotes ORDER BY RANDOM() LIMIT 1")
    QuoteEntity findRandomQuote();
}
