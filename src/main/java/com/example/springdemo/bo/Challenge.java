package com.example.springdemo.bo;

import lombok.*;

/**
 * This class represents a Challenge to solve a Multiplication (a * b).
 * domain/business object
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Challenge {
    private int factorA;
    private int factorB;
}
