package com.epam.finalkafka.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for Flat Beacon position.
 */
@Getter
@Setter
public class FlatBeaconPositionDto extends ObjectDto implements HasCoordinate, Serializable {

    private Instant timestamp;
    private Location location;
    private EntityId visitorId;
    private Coordinate coordinate;
    private BeaconIdentifier beaconIdentifier;

    public FlatBeaconPositionDto() {
    }

    public FlatBeaconPositionDto(Instant timestamp, Location location, EntityId visitorId, Coordinate coordinate, BeaconIdentifier beaconIdentifier) {
        this.timestamp = timestamp;
        this.location = location;
        this.visitorId = visitorId;
        this.coordinate = coordinate;
        this.beaconIdentifier = beaconIdentifier;
    }

    public FlatBeaconPositionDto(Instant timestamp) {
        this.timestamp = timestamp;
        this.location = new Location(ObjectId.getInstance("buildingId"), ObjectId.getInstance("levelId"));
        this.visitorId = ObjectId.getInstance("visitorId");
        this.coordinate = new Coordinate(1.1, 2.2);
        this.beaconIdentifier = new BeaconIdentifier("uuid", 1l, 2l);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FlatBeaconPositionDto)) {
            return false;
        }
        FlatBeaconPositionDto that = (FlatBeaconPositionDto) o;
        return Objects.equals(timestamp, that.timestamp)
                && Objects.equals(location, that.location)
                && Objects.equals(visitorId, that.visitorId)
                && Objects.equals(coordinate, that.coordinate)
                && Objects.equals(beaconIdentifier, that.beaconIdentifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(timestamp, location, visitorId, coordinate, beaconIdentifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "FlatBeaconPositionDto{"
                + "timestamp=" + timestamp
                + ", location=" + location
                + ", visitorId=" + visitorId
                + ", coordinate=" + coordinate
                + ", beaconIdentifier=" + beaconIdentifier
                + '}';
    }
}
