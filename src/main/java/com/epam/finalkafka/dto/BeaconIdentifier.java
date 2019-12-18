package com.epam.finalkafka.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Default comment.
 **/
public class BeaconIdentifier implements Serializable {
    private String uuid;
    private long major;
    private long minor;

    public BeaconIdentifier() {
    }

    /**
     * Constructs beacon identifier.
     *
     * @param uuid  beacon uuid
     * @param major beacon major
     * @param minor beacon minor
     */


    public BeaconIdentifier(String uuid, long major, long minor) {
        this.uuid = uuid;
        this.major = major;
        this.minor = minor;
    }

    /**
     * Getter for uuid.
     *
     * @return java.lang.String
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Setter for uuid.
     *
     * @param uuid value
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for major.
     *
     * @return java.lang.String
     */
    public long getMajor() {
        return major;
    }

    /**
     * Setter for major.
     *
     * @param major value
     */
    public void setMajor(long major) {
        this.major = major;
    }

    /**
     * Getter for minor.
     *
     * @return java.lang.String
     */
    public long getMinor() {
        return minor;
    }

    /**
     * Setter for minor.
     *
     * @param minor value
     */
    public void setMinor(long minor) {
        this.minor = minor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BeaconIdentifier)) {
            return false;
        }
        BeaconIdentifier that = (BeaconIdentifier) o;
        return major == that.major
                && minor == that.minor
                && Objects.equals(uuid, that.uuid);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(uuid, major, minor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "BeaconIdentifier{"
                + "uuid='" + uuid + '\''
                + ", major=" + major
                + ", minor=" + minor
                + '}';
    }
}
