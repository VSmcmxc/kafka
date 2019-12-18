package com.epam.finalkafka.dto;

/**
 * Describes entity with coordinates.
 */
public interface HasCoordinate {
    /**
     * Get coordinate of object.
     * @return coordinate instance
     */
    Coordinate getCoordinate();
}
