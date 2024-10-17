package com.example.springdemo.controller;

import com.example.springdemo.entity.QuoteEntity;
import com.example.springdemo.repository.QuoteRepository;
import com.example.springdemo.vo.QuoteVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class QuoteController {
    private final static QuoteEntity NONE = new QuoteEntity("None");
    private final static Random RANDOMIZER = new Random();

    private final QuoteRepository repository;

    public QuoteController(QuoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/{id}")
    public QuoteVO getOne(@PathVariable Long id) {
        return repository.findById(id)
                .map(quote -> new QuoteVO(quote, "success"))
                .orElse(new QuoteVO(NONE, "Quote " + id + " does not exist"));
    }

    @GetMapping("/api/random")
    public QuoteVO getRandomOne() {
        return getOne(nextLong(1, repository.count() + 1));
    }

    private long nextLong(long lowerRange, long upperRange) {
        return (long) (RANDOMIZER.nextDouble() * (upperRange - lowerRange)) + lowerRange;
    }
}
