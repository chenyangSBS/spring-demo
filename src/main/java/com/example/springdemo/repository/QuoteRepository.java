package com.example.springdemo.repository;

import com.example.springdemo.entity.QuoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<QuoteEntity, Long> {
}
