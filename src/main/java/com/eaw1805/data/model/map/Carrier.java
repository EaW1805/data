package com.eaw1805.data.model.map;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.constants.GoodConstants;
import com.eaw1805.data.managers.army.BrigadeManager;
import com.eaw1805.data.managers.army.CommanderManager;
import com.eaw1805.data.managers.army.SpyManager;
import com.eaw1805.data.model.army.Battalion;
import com.eaw1805.data.model.army.Brigade;
import com.eaw1805.data.model.army.Commander;
import com.eaw1805.data.model.army.Spy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Keeps information regarding goods and troops carried by carrier units.
 */
public class Carrier implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * Stored goods.
     */
    protected Map<Integer, Integer> storedGoods;

    /**
     * Non-persistent flag indicating if carrier is carrying a commander.
     */
    protected boolean hasCommander;

    /**
     * Non-persistent flag indicating if carrier is carrying a spy.
     */
    protected boolean hasSpy;

    /**
     * Non-persistent flag indicating if carrier is carrying a battalion.
     */
    protected boolean hasTroops;

    /**
     * Get the stored goods.
     *
     * @return the stored goods.
     */
    public Map<Integer, Integer> getStoredGoods() {
        return storedGoods;
    }

    /**
     * Set the stored goods.
     *
     * @param value the stored goods.
     */
    public void setStoredGoods(final Map<Integer, Integer> value) {
        this.storedGoods = value;
    }

    /**
     * Get the Non-persistent flag indicating if carrier is carrying a commander.
     *
     * @return true if carrier is carrying a commander.
     */
    public boolean getHasCommander() {
        return hasCommander;
    }

    /**
     * Set the Non-persistent flag indicating if carrier is carrying a commander.
     *
     * @param value true if carrier is carrying a commander.
     */
    public void setHasCommander(final boolean value) {
        this.hasCommander = value;
    }

    /**
     * Get the Non-persistent flag indicating if carrier is carrying a spy.
     *
     * @return true if carrier is carrying a spy.
     */
    public boolean getHasSpy() {
        return hasSpy;
    }

    /**
     * Set the Non-persistent flag indicating if carrier is carrying a spy.
     *
     * @param value true if carrier is carrying a spy.
     */
    public void setHasSpy(final boolean value) {
        this.hasSpy = value;
    }

    /**
     * Get the Non-persistent flag indicating if carrier is carrying a battalion.
     *
     * @return true if carrier is carrying a battalion.
     */
    public boolean getHasTroops() {
        return hasTroops;
    }

    /**
     * Set the Non-persistent flag indicating if carrier is carrying a battalion.
     *
     * @param value true if carrier is carrying a battalion.
     */
    public void setHasTroops(final boolean value) {
        hasTroops = value;
    }

    /**
     * Initialize values of non-persistent flags.
     */
    public void initializeVariables() {
        // Check if the entity is carrying units, and update their position too
        for (Map.Entry<Integer, Integer> loadedUnit : getStoredGoods().entrySet()) {
            final int key = loadedUnit.getKey();
            if (key > GoodConstants.GOOD_LAST) {
                // Check type of unit
                if (loadedUnit.getKey() >= ArmyConstants.SPY * 1000) {
                    setHasSpy(true);

                } else if (loadedUnit.getKey() >= ArmyConstants.COMMANDER * 1000) {
                    setHasCommander(true);

                } else if (loadedUnit.getKey() >= ArmyConstants.BRIGADE * 1000) {
                    setHasTroops(true);
                }
            }
        }
    }

    /**
     * Update the position of loaded entities.
     *
     * @param newPosition the new position.
     */
    public void updatePosition(final Position newPosition) {
        List<Integer> unusedSlots = null;
        for (Map.Entry<Integer, Integer> loadedUnit : getStoredGoods().entrySet()) {
            if (loadedUnit.getKey() > GoodConstants.GOOD_LAST) {
                if (loadedUnit.getKey() >= ArmyConstants.SPY * 1000) {
                    final Spy thisSpy = SpyManager.getInstance().getByID(loadedUnit.getValue());
                    if (thisSpy != null) {
                        thisSpy.setPosition(newPosition);
                        SpyManager.getInstance().update(thisSpy);
                    } else {
                        // something is wrong
                        if (unusedSlots == null) {
                            unusedSlots = new ArrayList<Integer>();
                        }

                        unusedSlots.add(loadedUnit.getKey());
                    }

                } else if (loadedUnit.getKey() >= ArmyConstants.COMMANDER * 1000) {
                    final Commander thisComm = CommanderManager.getInstance().getByID(loadedUnit.getValue());
                    if (thisComm != null) {
                        thisComm.setPosition(newPosition);
                        CommanderManager.getInstance().update(thisComm);
                    } else {
                        // something is wrong
                        if (unusedSlots == null) {
                            unusedSlots = new ArrayList<Integer>();
                        }

                        unusedSlots.add(loadedUnit.getKey());
                    }

                } else if (loadedUnit.getKey() >= ArmyConstants.BRIGADE * 1000) {
                    final Brigade thisBrigade = BrigadeManager.getInstance().getByID(loadedUnit.getValue());
                    if (thisBrigade != null) {
                        thisBrigade.setPosition(newPosition);
                        BrigadeManager.getInstance().update(thisBrigade);

                    } else {
                        // something is wrong
                        if (unusedSlots == null) {
                            unusedSlots = new ArrayList<Integer>();
                        }

                        unusedSlots.add(loadedUnit.getKey());
                    }
                }
            }
        }

        // remove unused slots
        if (unusedSlots != null) {
            for (Integer slot : unusedSlots) {
                storedGoods.remove(slot);
            }
        }
    }

    /**
     * Update the movement and engage counters of loaded entities.
     *
     * @param willBattle the unit will engage in a battle.
     */
    public void updateMoveEngageCounters(boolean willBattle) {
        List<Integer> unusedSlots = null;
        for (Map.Entry<Integer, Integer> loadedUnit : getStoredGoods().entrySet()) {
            if (loadedUnit.getKey() > GoodConstants.GOOD_LAST) {
                if (loadedUnit.getKey() >= ArmyConstants.BRIGADE * 1000
                        //be sure this only runs for brigade entries.
                        && loadedUnit.getKey() <= (ArmyConstants.BRIGADE*1000 + 1000)) {

                    final Brigade thisBrigade = BrigadeManager.getInstance().getByID(loadedUnit.getValue());
                    if (thisBrigade != null) {
                        for (Battalion movedItem : thisBrigade.getBattalions()) {
                            // raise flag
                            movedItem.setHasMoved(true);
                            movedItem.setHasEngagedBattle(willBattle);
                        }
                        BrigadeManager.getInstance().update(thisBrigade);

                    } else {
                        // something is wrong
                        if (unusedSlots == null) {
                            unusedSlots = new ArrayList<Integer>();
                        }

                        unusedSlots.add(loadedUnit.getKey());
                    }
                }
            }
        }

        // remove unused slots
        if (unusedSlots != null) {
            for (Integer slot : unusedSlots) {
                storedGoods.remove(slot);
            }
        }
    }

}
