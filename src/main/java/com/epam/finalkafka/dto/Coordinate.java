package com.epam.finalkafka.dto;

import lombok.*;

import java.io.Serializable;

/**
 * This class @code{Coordinate} represents two-dimensional coordinate.
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate implements Serializable {
    private double latitude;
    private double longitude;

}