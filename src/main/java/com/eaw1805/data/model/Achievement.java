package com.eaw1805.data.model;


import java.io.Serializable;

/**
 * Achievement object holds all data for the user achievements.
 */
public class Achievement implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Unique Achievement ID.
     */
    private int achievementID;

    /**
     * User Id.
     */
    private User user;

    /**
     * Achievement's category.
     */
    private int category;

    /**
     * Achievement's level.
     */
    private int level;

    /**
     * Achievement's points.
     */
    private int achievementPoints;

    /**
     * Achievement's victory points.
     */
    private int victoryPoints;

    /**
     * If this a new Achievement.
     */
    private boolean firstLoad;

    /**
     * If this achievement announced to Facebook.
     */
    private boolean announced;

    /**
     * Achievement's description.
     */
    private String description;

    /**
     * Return the Achievement's ID.
     *
     * @return an int with the ID.
     */
    public int getAchievementID() {
        return achievementID;
    }

    /**
     * Set the Achievement's id.
     *
     * @param value an int with the ID.
     */
    public void setAchievementID(final int value) {
        this.achievementID = value;
    }

    /**
     * Returns the User of the specific achievement.
     *
     * @return a user object..
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the User of the specific achievement.
     *
     * @param value a User object.
     */
    public void setUser(final User value) {
        this.user = value;
    }

    /**
     * Return the category of the Achievement.
     *
     * @return an int with the Category.
     */
    public int getCategory() {
        return category;
    }

    /**
     * Set the category of the achievement.
     *
     * @param value an int with the Category.
     */
    public void setCategory(final int value) {
        this.category = value;
    }

    /**
     * Return the level of the Achievement.
     *
     * @return an int with the level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the level of the Achievement.
     *
     * @param value an int with the level.
     */
    public void setLevel(final int value) {
        this.level = value;
    }

    /**
     * Return the Achievement Points.
     *
     * @return an int with the AP.
     */
    public int getAchievementPoints() {
        return achievementPoints;
    }

    /**
     * Set the achievement points.
     *
     * @param value an int with the AP.
     */
    public void setAchievementPoints(final int value) {
        this.achievementPoints = value;
    }

    /**
     * Return the VPs.
     *
     * @return an int with the VPs.
     */
    public int getVictoryPoints() {
        return victoryPoints;
    }

    /**
     * Set the VPs.
     *
     * @param value an int with the VPs.
     */
    public void setVictoryPoints(final int value) {
        this.victoryPoints = value;
    }

    /**
     * True, if this is a new achievement.
     *
     * @return a boolean with the value.
     */
    public boolean isFirstLoad() {
        return firstLoad;
    }

    /**
     * Set to true if this is a new achievement.
     *
     * @param value a boolean with the value.
     */
    public void setFirstLoad(final boolean value) {
        firstLoad = value;
    }

    /**
     * Return true if the achievement was already announced to FB.
     *
     * @return a boolean with the value.
     */
    public boolean isAnnounced() {
        return announced;
    }

    /**
     * Set true when the achievement is announced to fb.
     *
     * @param value a boolean with the valuw.
     */
    public void setAnnounced(final boolean value) {
        this.announced = value;
    }

    /**
     * Return achievement's description.
     *
     * @return a String with the Description.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Set Achievements description.
     *
     * @param value a String with the description.
     */
    public void setDescription(final String value) {
        this.description = value;
    }

    /**
     * Get the title of the description.
     *
     * @return The title of the description.
     */
    public String getDescriptionTitle() {
        if (description == null) {
            return "";
        }
        String title = description.split("Achievement")[0];
        title = title.substring(1, title.length() - 2);
        return title;
    }

    /**
     * Get the body of the description.
     *
     * @return The body of the description.
     */
    public String getDescriptionBody() {
        if (description == null) {
            return "";
        }
        String body = description.split("Achievement")[1];
        body = body.substring(1, body.length() - 1);
        return body;
    }
}
