package com.capgemini.wsb.fitnesstracker.training.internal;

/**
 * Represents the types of activities that can be tracked in the fitness
 * tracker.
 */
public enum ActivityType {

    RUNNING("Running"),

    CYCLING("Cycling"),

    WALKING("Walking"),

    SWIMMING("Swimming"),

    TENNIS("Tennis");

    private final String displayName;

    ActivityType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display name of the activity type.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

}
