package com.eaw1805.data.model;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;

import java.util.List;
import java.util.Random;

/**
 * Generic Methods that should be implemented by all engines.
 */
public interface Engine {

    /**
     * Game object of the turn processed.
     *
     * @return the game object.
     */
    Game getGame();

    /**
     * Get list of alive nations.
     *
     * @return a list of alive nations.
     */
    List<Nation> getAliveNations();

    /**
     * Get the random number generator.
     *
     * @return the random number generator.
     */
    Random getRandomGen();

}
