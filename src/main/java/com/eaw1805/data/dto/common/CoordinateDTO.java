package com.eaw1805.data.dto.common;


public class CoordinateDTO
        implements com.google.gwt.user.client.rpc.IsSerializable {

    /**
     * The x coordinate.
     */
    private int coordX;

    /**
     * The y coordinate.
     */
    private int coordY;

    private String path;

    /**
     * The elevation level.
     */
    private int elevation;

    public CoordinateDTO() {
        super();
        path = "";
    }

    public CoordinateDTO(final int posX,
                         final int posY,
                         final String valuePath,
                         final int level) {
        super();
        this.coordX = posX;
        this.coordY = posY;
        this.path = valuePath;
        this.elevation = level;
    }

    /**
     * Get the x coordinate.
     *
     * @return the x coordinate.
     */
    public int getX() {
        return coordX;
    }

    /**
     * Set the x coordinate.
     *
     * @param xCoord the x coordinate.
     */
    public void setX(final int xCoord) {
        this.coordX = xCoord;
    }

    /**
     * Get the y coordinate.
     *
     * @return the y coordinate.
     */
    public int getY() {
        return coordY;
    }

    /**
     * Set the y coordinate.
     *
     * @param yCoord the y coordinate.
     */
    public void setY(final int yCoord) {
        this.coordY = yCoord;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(final int level) {
        this.elevation = level;
    }

    public String getPath() {
        return path;
    }

    public void setPath(final String path) {
        this.path = path;
    }


}

