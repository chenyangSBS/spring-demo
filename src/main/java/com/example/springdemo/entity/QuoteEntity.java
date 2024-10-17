package com.example.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
public class QuoteEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String quote;

    public QuoteEntity(String quote) {
        this.quote = quote;
    }

    protected QuoteEntity() {}

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof QuoteEntity))
            return false;
        QuoteEntity quote1 = (QuoteEntity) o;
        return Objects.equals(id, quote1.id) && Objects.equals(quote, quote1.quote);
    }
}
