package com.eaw1805.data.model.army;

import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Region;

import java.io.Serializable;

/**
 * Represents a particular army type.
 */
public class ArmyType implements Serializable {  // NOPMD

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The unique identifier of the army type.
     */
    private int id; // NOPMD    

    /**
     * The internal identifier of the army type.
     */
    private int intId;

    /**
     * The nation that this army type belongs to.
     */
    private Nation nation;

    /**
     * The region where this army type can be built.
     */
    private Region region;

    /**
     * The name of the army type.
     */
    private String name;

    /**
     * The short name of the army type.
     */
    private String shortName;

    /**
     * Cost of each new recruit.
     */
    private int cost;

    /**
     * Industrial points required for every 100 troops.
     */
    private int indPt;

    /**
     * Cost for maintaining 800 (or 1000 troops for islamic nations).
     */
    private int maint;

    /**
     * Maximum Experience Factor from Training.
     */
    private int maxExp;

    /**
     * Hand-to-Hand Combat points.
     */
    private int handCombat;

    /**
     * Long Range combat points.
     */
    private int longCombat;

    /**
     * Long Range Combat Firing Range.
     */
    private int longRange;

    /**
     * the available movement points.
     */
    private int mps;

    /**
     * the available movement points in simulated battles.
     */
    private int sps;

    /**
     * Formations permitted.
     * Co - Column
     * Li - Line
     * Sk - Skirmish
     * Sq - Square
     */
    private boolean formationCo;

    /**
     * Formations permitted.
     * Co - Column
     * Li - Line
     * Sk - Skirmish
     * Sq - Square
     */
    private boolean formationLi;

    /**
     * Formations permitted.
     * Co - Column
     * Li - Line
     * Sk - Skirmish
     * Sq - Square
     */
    private boolean formationSk;

    /**
     * Formations permitted.
     * Co - Column
     * Li - Line
     * Sk - Skirmish
     * Sq - Square
     */
    private boolean formationSq;

    /**
     * Troop Specification.
     * Lr - Lancers
     * Lc - Light Cavalry
     * Cu - Cuirassier
     */
    private boolean troopSpecsLr;

    /**
     * Troop Specification.
     * Lr - Lancers
     * Lc - Light Cavalry
     * Cu - Cuirassier
     */
    private boolean troopSpecsLc;

    /**
     * Troop Specification.
     * Lr - Lancers
     * Lc - Light Cavalry
     * Cu - Cuirassier
     */
    private boolean troopSpecsCu;

    /**
     * Troop type.
     * In - Infantry
     * Ca - Cavalry
     * Ar - Artillery
     * MA - Mounted Artillery
     * Kt - Colonial Troops
     * Co - Colonial Auxiliaries
     * MC - Mounted Colonial Auxiliaries
     * CI - Crack Infantry
     * CC - Crack Cavalry
     * EI - Elite Infantry
     * EC - Elite Cavalry
     */
    private String type;

    /**
     * If the troop type is crack unit.
     */
    private boolean crack;

    /**
     * If the troop type is elite unit.
     */
    private boolean elite;

    /**
     * The ID of the unit that this unit upgrades to.
     */
    private int upgradeEliteTo;

    /**
     * The ID of the unit that this unit is upgraded from.
     */
    private int upgradeCrackFrom;

    /**
     * The percentage of VPs required to unlock the crack/elite unit.
     */
    private int vps;

    /**
     * If the troop type gets bonus when fighting in home region.
     */
    private boolean home;

    /**
     * Get the unique identifier of the army type.
     *
     * @return the unique identifier of the army type.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier of the army type.
     *
     * @param identity the unique identifier of the army type.
     */
    public void setId(final int identity) {
        this.id = identity;
    }

    /**
     * Get the nation this army type belongs to.
     *
     * @return the nation this army type belongs to.
     */
    public Nation getNation() {
        return nation;
    }

    /**
     * Set the nation this army type belongs to.
     *
     * @param param The nation this army type belongs to.
     */
    public void setNation(final Nation param) {
        this.nation = param;
    }

    /**
     * Get the region of the position.
     *
     * @return the region of the position.
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Set the region of the position.
     *
     * @param thisRegion the region of the position.
     */
    public void setRegion(final Region thisRegion) {
        this.region = thisRegion;
    }

    /**
     * Get the internal identifier of the army type.
     *
     * @return the internal identifier of the army type.
     */
    public int getIntId() {
        return intId;
    }

    /**
     * Set the internal identifier of the army type.
     *
     * @param thisIdentifier the internal identifier of the army type.
     */
    public void setIntId(final int thisIdentifier) {
        this.intId = thisIdentifier;
    }

    /**
     * Get the name of the army type.
     *
     * @return the name of the army type.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the army type.
     *
     * @param thisName the name of the army type.
     */
    public void setName(final String thisName) {
        this.name = thisName;
    }

    /**
     * Get the short name of the army type.
     *
     * @return the short name of the army type.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Set the short name of the army type.
     *
     * @param thisName the short name of the army type.
     */
    public void setShortName(final String thisName) {
        this.shortName = thisName;
    }

    /**
     * Get the Cost of each new recruit.
     *
     * @return the Cost of each new recruit.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Set the Cost of each new recruit.
     *
     * @param thisCost the Cost of each new recruit.
     */
    public void setCost(final int thisCost) {
        this.cost = thisCost;
    }

    /**
     * Get Economy points required for every 100 troops.
     *
     * @return Economy points required for every 100 troops.
     */
    public int getIndPt() {
        return indPt;
    }

    /**
     * Set Economy points required for every 100 troops.
     *
     * @param thisEcPt the Economy points required for every 100 troops.
     */
    public void setIndPt(final int thisEcPt) {
        this.indPt = thisEcPt;
    }

    /**
     * Get the Cost for maintaining 800 (or 1000 troops for islamic nations).
     *
     * @return the Cost for maintaining 800 (or 1000 troops for islamic nations).
     */
    public int getMaint() {
        return maint;
    }

    /**
     * Set the Cost for maintaining 800 (or 1000 troops for islamic nations).
     *
     * @param value the Cost for maintaining 800 (or 1000 troops for islamic nations).
     */
    public void setMaint(final int value) {
        this.maint = value;
    }

    /**
     * Get the Maximum Experience Factor from Training.
     *
     * @return the Maximum Experience Factor from Training.
     */
    public int getMaxExp() {
        return maxExp;
    }

    /**
     * Set the Maximum Experience Factor from Training.
     *
     * @param thisMaxExp the Maximum Experience Factor from Training.
     */
    public void setMaxExp(final int thisMaxExp) {
        this.maxExp = thisMaxExp;
    }

    /**
     * Get the Hand-to-Hand Combat points.
     *
     * @return the Hand-to-Hand Combat points.
     */
    public int getHandCombat() {
        return handCombat;
    }

    /**
     * Set the Hand-to-Hand Combat points.
     *
     * @param thisHC the Hand-to-Hand Combat points.
     */
    public void setHandCombat(final int thisHC) {
        this.handCombat = thisHC;
    }

    /**
     * Get the Long Range combat points.
     *
     * @return the Long Range combat points.
     */
    public int getLongCombat() {
        return longCombat;
    }

    /**
     * Set the Long Range combat points.
     *
     * @param thisLC the Long Range combat points.
     */
    public void setLongCombat(final int thisLC) {
        this.longCombat = thisLC;
    }

    /**
     * Get the Long Range Combat Firing Range.
     *
     * @return the Long Range Combat Firing Range.
     */
    public int getLongRange() {
        return longRange;
    }

    /**
     * Set the Long Range Combat Firing Range.
     *
     * @param thisLR the Long Range Combat Firing Range.
     */
    public void setLongRange(final int thisLR) {
        this.longRange = thisLR;
    }

    /**
     * Get the available movement points.
     *
     * @return the available movement points.
     */
    public int getMps() {
        return mps;
    }

    /**
     * Set the available movement points.
     *
     * @param thisMps the available movement points.
     */
    public void setMps(final int thisMps) {
        this.mps = thisMps;
    }

    /**
     * Get the available movement points in simulated battles.
     *
     * @return the available movement points in simulated battles.
     */
    public int getSps() {
        return sps;
    }

    /**
     * Set the available movement points in simulated battles.
     *
     * @param thisSps the available movement points in simulated battles.
     */
    public void setSps(final int thisSps) {
        this.sps = thisSps;
    }

    /**
     * Get the Formations permitted.
     *
     * @return the Formations permitted.
     */
    public boolean getFormationCo() { // NOPMD
        return formationCo;
    }

    /**
     * Set the Formations permitted.
     *
     * @param thisFormation the Formations permitted.
     */
    public void setFormationCo(final boolean thisFormation) {
        this.formationCo = thisFormation;
    }

    /**
     * Get the Formations permitted.
     *
     * @return the Formations permitted.
     */
    public boolean getFormationLi() { // NOPMD
        return formationLi;
    }

    /**
     * Set the Formations permitted.
     *
     * @param thisFormation the Formations permitted.
     */
    public void setFormationLi(final boolean thisFormation) {
        this.formationLi = thisFormation;
    }

    /**
     * Get the Formations permitted.
     *
     * @return the Formations permitted.
     */
    public boolean getFormationSq() { // NOPMD
        return formationSq;
    }

    /**
     * Set the Formations permitted.
     *
     * @param thisFormation the Formations permitted.
     */
    public void setFormationSq(final boolean thisFormation) {
        this.formationSq = thisFormation;
    }

    /**
     * Get the Formations permitted.
     *
     * @return the Formations permitted.
     */
    public boolean getFormationSk() { // NOPMD
        return formationSk;
    }

    /**
     * Set the Formations permitted.
     *
     * @param thisFormation the Formations permitted.
     */
    public void setFormationSk(final boolean thisFormation) {
        this.formationSk = thisFormation;
    }

    /**
     * Get the Troop Specification.
     *
     * @return the Troop Specification.
     */
    public boolean getTroopSpecsLc() { // NOPMD
        return troopSpecsLc;
    }

    /**
     * Set the Troop Specification.
     *
     * @param thisSpecs the Troop Specification.
     */
    public void setTroopSpecsLc(final boolean thisSpecs) {
        this.troopSpecsLc = thisSpecs;
    }

    /**
     * Get the Troop Specification.
     *
     * @return the Troop Specification.
     */
    public boolean getTroopSpecsLr() { // NOPMD
        return troopSpecsLr;
    }

    /**
     * Set the Troop Specification.
     *
     * @param thisSpecs the Troop Specification.
     */
    public void setTroopSpecsLr(final boolean thisSpecs) {
        this.troopSpecsLr = thisSpecs;
    }

    /**
     * Get the Troop Specification.
     *
     * @return the Troop Specification.
     */
    public boolean getTroopSpecsCu() { // NOPMD
        return troopSpecsCu;
    }

    /**
     * Set the Troop Specification.
     *
     * @param thisSpecs the Troop Specification.
     */
    public void setTroopSpecsCu(final boolean thisSpecs) {
        this.troopSpecsCu = thisSpecs;
    }


    /**
     * Get the Troop type.
     *
     * @return the Troop type.
     */
    public String getType() {
        return type;
    }

    /**
     * Set the Troop type.
     *
     * @param thisType the Troop type.
     */
    public void setType(final String thisType) {
        this.type = thisType;
    }

    /**
     * Check if this unit is a crack unit.
     *
     * @return true if this is a crack unit.
     */
    public boolean getCrack() { // NOPMD
        return crack;
    }

    /**
     * Set if this unit is a crack unit.
     *
     * @param value true if this is a crack unit.
     */
    public void setCrack(final boolean value) {
        crack = value;
    }

    /**
     * Check if this unit is an elite unit.
     *
     * @return true if this is an elite unit.
     */
    public boolean getElite() { // NOPMD
        return elite;
    }

    /**
     * Set if this unit is an elite unit.
     *
     * @param value true if this is an elite unit.
     */
    public void setElite(final boolean value) {
        elite = value;
    }

    /**
     * Get the ID of the unit that this unit is upgrading.
     *
     * @return the ID of the unit that this unit is upgrading.
     */
    public int getUpgradeEliteTo() {
        return upgradeEliteTo;
    }

    /**
     * Set the ID of the unit that this unit is upgrading.
     *
     * @param value the ID of the unit that this unit is upgrading.
     */
    public void setUpgradeEliteTo(final int value) {
        this.upgradeEliteTo = value;
    }

    /**
     * Get the ID of the unit that this unit was upgraded from.
     *
     * @return the ID of the unit that this unit was upgraded from.
     */
    public int getUpgradeCrackFrom() {
        return upgradeCrackFrom;
    }

    /**
     * Set the ID of the unit that this unit was upgraded from.
     *
     * @param value the ID of the unit that this unit was upgraded from.
     */
    public void setUpgradeCrackFrom(final int value) {
        this.upgradeCrackFrom = value;
    }

    /**
     * Get the percentage of VPs required to unlock the crack/elite unit.
     *
     * @return the percentage of VPs required to unlock the crack/elite unit.
     */
    public int getVps() {
        return vps;
    }

    /**
     * Set the percentage of VPs required to unlock the crack/elite unit.
     *
     * @param value the percentage of VPs required to unlock the crack/elite unit.
     */
    public void setVps(final int value) {
        this.vps = value;
    }

    /**
     * Get if the troop type gets bonus when fighting in home region.
     *
     * @return true if the troop type gets bonus when fighting in home region.
     */
    public boolean getHome() {
        return home;
    }

    /**
     * Set if the troop type gets bonus when fighting in home region.
     *
     * @param value, true if the troop type gets bonus when fighting in home region.
     */
    public void setHome(final boolean value) {
        this.home = value;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p/>
     * The <code>equals</code> method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * <code>x</code>, <code>x.equals(x)</code> should return
     * <code>true</code>.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * <code>x</code> and <code>y</code>, <code>x.equals(y)</code>
     * should return <code>true</code> if and only if
     * <code>y.equals(x)</code> returns <code>true</code>.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * <code>x</code>, <code>y</code>, and <code>z</code>, if
     * <code>x.equals(y)</code> returns <code>true</code> and
     * <code>y.equals(z)</code> returns <code>true</code>, then
     * <code>x.equals(z)</code> should return <code>true</code>.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * <code>x</code> and <code>y</code>, multiple invocations of
     * <tt>x.equals(y)</tt> consistently return <code>true</code>
     * or consistently return <code>false</code>, provided no
     * information used in <code>equals</code> comparisons on the
     * objects is modified.
     * <li>For any non-null reference value <code>x</code>,
     * <code>x.equals(null)</code> should return <code>false</code>.
     * </ul>
     * <p/>
     * The <tt>equals</tt> method for class <code>Object</code> implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values <code>x</code> and
     * <code>y</code>, this method returns <code>true</code> if and only
     * if <code>x</code> and <code>y</code> refer to the same object
     * (<code>x == y</code> has the value <code>true</code>).
     * <p/>
     * Note that it is generally necessary to override the <tt>hashCode</tt>
     * method whenever this method is overridden, so as to maintain the
     * general contract for the <tt>hashCode</tt> method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * @see #hashCode()
     * @see java.util.Hashtable
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ArmyType)) {
            return false;
        }

        final ArmyType armyType = (ArmyType) obj;

        if (id != armyType.id) {
            return false;
        }

        return true;
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hashtables such as those provided by
     * <code>java.util.Hashtable</code>.
     * <p/>
     * The general contract of <code>hashCode</code> is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the <tt>hashCode</tt> method
     * must consistently return the same integer, provided no information
     * used in <tt>equals</tt> comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the <tt>equals(Object)</tt>
     * method, then calling the <code>hashCode</code> method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link java.lang.Object#equals(java.lang.Object)}
     * method, then calling the <tt>hashCode</tt> method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hashtables.
     * </ul>
     * <p/>
     * As much as is reasonably practical, the hashCode method defined by
     * class <tt>Object</tt> does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java<font size="-2"><sup>TM</sup></font> programming language.)
     *
     * @return a hash code value for this object.
     * @see java.lang.Object#equals(java.lang.Object)
     * @see java.util.Hashtable
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 310 * result + intId;
        return result;
    }

    /*
    * Calculates if the army type is infantry.
    *
    * @return <code>true</code> if the type is infantry.
    */
    public boolean isInfantry() {
        return ((getType().equals("In")
                || getType().equals("EI")
                || getType().equals("Kt")
                || getType().equals("Co"))
                && !isEngineer());
    }

    /*
     * Calculates if the army type is engineering unit.
     *
     * @return <code>true</code> if the type is engineering.
     */
    public boolean isEngineer() {
        return (getName().equals("Pioneers"));
    }

    /*
     * Calculates if the army type is cavalry.
     *
     * @return <code>true</code> if the type is cavalry.
     */
    public boolean isCavalry() {
        return (getType().equals("Ca")
                || getType().equals("EC")
                || getType().equals("MC")
                || getType().equals("CC"));
    }

    /*
     * Calculates if the army type is artillery.
     *
     * @return <code>true</code> if the type is artillery.
     */
    public boolean isArtillery() {
        return (getType().equals("Ar"));
    }

    /*
     * Calculates if the army type is artillery.
     *
     * @return <code>true</code> if the type is artillery.
     */
    public boolean isMArtillery() {
        return (getShortName().equals("Ma") || getShortName().equals("GM") || (getShortName().equals("Ra") && getIntId() == 73));
    }

    /**
     * Check if the troop type requires horse.
     *
     * @return true if horses are needed.
     */
    public final boolean needsHorse() {
        return (isCavalry() || isMArtillery());
    }

    /**
     * Check if the troop type can be built in colonies.
     *
     * @return true if it can be built in colonies.
     */
    public final boolean canColonies() {
        return (getType().equals("Co")
                || getType().equals("CC")
                || getType().equals("MC"));
    }

    /**
     * Check if the troop type is elite.
     *
     * @return true if it is elite.
     */
    public final boolean canBuildElite() {
        return getCrack();
    }

}
