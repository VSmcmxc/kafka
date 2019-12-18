package com.epam.finalkafka.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Default comment.
 **/
public class Location implements Serializable {
    private  EntityId buildingId;
    private  EntityId levelId;

    public Location() {

    }



    /**
     * Constructs beacon location.
     *
     * @param buildingId buildingId
     * @param levelId    levelId
     */
    public Location(EntityId buildingId, EntityId levelId) {
        this.buildingId = buildingId;
        this.levelId = levelId;
    }


    public void setBuildingId(EntityId buildingId) {
        this.buildingId = buildingId;
    }

    public void setLevelId(EntityId levelId) {
        this.levelId = levelId;
    }

    /**
     * Getter for buildingId.
     *
     * @return com.epam.beacons.cloud.common.core.id.EntityId
     */
    public EntityId getBuildingId() {
        return buildingId;
    }

    /**
     * Getter for levelId.
     *
     * @return com.epam.beacons.cloud.common.core.id.EntityId
     */
    public EntityId getLevelId() {
        return levelId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Location)) {
            return false;
        }
        Location location = (Location) o;
        return Objects.equals(buildingId, location.buildingId)
                && Objects.equals(levelId, location.levelId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(buildingId, levelId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Location{"
                + "buildingId=" + buildingId
                + ", levelId=" + levelId
                + '}';
    }
}
