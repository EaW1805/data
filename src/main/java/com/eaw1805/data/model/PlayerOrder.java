package com.eaw1805.data.model;

import com.eaw1805.data.model.map.Region;

import java.io.Serializable;

/**
 * Information related to a player order.
 */
public class PlayerOrder implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * PlayerOrder's unique ID.
     */
    private int orderId;

    /**
     * The game.
     */
    private Game game;

    /**
     * The turn the order was issued.
     */
    private int turn;

    /**
     * Nation owner.
     */
    private Nation nation;

    /**
     * PlayerOrder's type.
     */
    private int type;

    /**
     * PlayerOrder's position.
     */
    private int position;

    /**
     * The 1st parameter of the order.
     */
    private String parameter1;

    /**
     * The 2nd parameter of the order.
     */
    private String parameter2;

    /**
     * The 3rd parameter of the order.
     */
    private String parameter3;

    /**
     * The 4th parameter of the order.
     */
    private String parameter4;

    /**
     * The 5th parameter of the order.
     */
    private String parameter5;

    /**
     * The 6th parameter of the order.
     */
    private String parameter6;

    /**
     * The 7th parameter of the order.
     */
    private String parameter7;

    /**
     * The 8th parameter of the order.
     */
    private String parameter8;

    /**
     * The 9th parameter of the order.
     */
    private String parameter9;

    /**
     * The 1st temporary value of the order -- used by UI.
     */
    private String temp1;

    /**
     * The 2nd temporary value of the order -- used by UI.
     */
    private String temp2;

    /**
     * The 3rd temporary value of the order -- used by UI.
     */
    private String temp3;

    /**
     * The 4th temporary value of the order -- used by UI.
     */
    private String temp4;

    /**
     * The 5th temporary value of the order -- used by UI.
     */
    private String temp5;

    /**
     * The 6th temporary value of the order -- used by UI.
     */
    private String temp6;

    /**
     * The 7th temporary value of the order -- used by UI.
     */
    private String temp7;

    /**
     * The 8th temporary value of the order -- used by UI.
     */
    private String temp8;

    /**
     * The 9th temporary value of the order -- used by UI.
     */
    private String temp9;

    /**
     * The encoded result of the order.
     */
    private int result;

    /**
     * The explanation of the result in plain text.
     */
    private String explanation;

    /**
     * The ordering that the order was processed.
     */
    private int procOrder;

    /**
     * The region that the order subject was located.
     */
    private Region region;

    /**
     * Orders's goods quantity used.
     */
    private java.util.Map<Integer, Integer> usedGoodsQnt;

    /**
     * Get the Identification number of the order.
     *
     * @return the identification number of the order.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set the identification number of the order.
     *
     * @param identity the identification number of the order.
     */
    public void setOrderId(final int identity) {
        this.orderId = identity;
    }

    /**
     * Get the game.
     *
     * @return the game.
     */
    public com.eaw1805.data.model.Game getGame() {
        return game;
    }

    /**
     * Set the game.
     *
     * @param thisGame the game.
     */
    public void setGame(final com.eaw1805.data.model.Game thisGame) {
        this.game = thisGame;
    }

    /**
     * The turn number.
     *
     * @return the turn number.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Set the turn number.
     *
     * @param thisTurn the number of the turn.
     */
    public void setTurn(final int thisTurn) {
        this.turn = thisTurn;
    }

    /**
     * Get the Nation issuing the order.
     *
     * @return the Nation issuing the order.
     */
    public com.eaw1805.data.model.Nation getNation() {
        return nation;
    }

    /**
     * Set the Nation issuing the order.
     *
     * @param empireID the Nation issuing the order.
     */
    public void setNation(final com.eaw1805.data.model.Nation empireID) {
        this.nation = empireID;
    }

    /**
     * Get the type of the order.
     *
     * @return the type of the order.
     */
    public int getType() {
        return type;
    }

    /**
     * Set the type of the order.
     *
     * @param thisType the type of the order.
     */
    public void setType(final int thisType) {
        this.type = thisType;
    }

    /**
     * Get the position of the order.
     *
     * @return the position of the order.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Set the position of the order.
     *
     * @param pos the position of the order.
     */
    public void setPosition(final int pos) {
        this.position = pos;
    }

    /**
     * Get the 1st parameter of the order.
     *
     * @return the 1st parameters of the order.
     */
    public String getParameter1() {
        return parameter1;
    }

    /**
     * Set the 1st parameter of the order.
     *
     * @param thisParam the 1st parameter of the order.
     */
    public void setParameter1(final String thisParam) {
        this.parameter1 = thisParam;
    }

    /**
     * Get the 2nd parameter of the order.
     *
     * @return the 2nd parameters of the order.
     */
    public String getParameter2() {
        return parameter2;
    }

    /**
     * Set the 2nd parameter of the order.
     *
     * @param thisParam the 2nd parameter of the order.
     */
    public void setParameter2(final String thisParam) {
        this.parameter2 = thisParam;
    }

    /**
     * Get the 3rd parameter of the order.
     *
     * @return the 3rd parameters of the order.
     */
    public String getParameter3() {
        return parameter3;
    }

    /**
     * Set the 3rd parameter of the order.
     *
     * @param thisParam the 3rd parameter of the order.
     */
    public void setParameter3(final String thisParam) {
        this.parameter3 = thisParam;
    }

    /**
     * Get the 4th parameter of the order.
     *
     * @return the 4th parameters of the order.
     */
    public String getParameter4() {
        return parameter4;
    }

    /**
     * Set the 4th parameter of the order.
     *
     * @param thisParam the 4th parameter of the order.
     */
    public void setParameter4(final String thisParam) {
        this.parameter4 = thisParam;
    }

    /**
     * Get the 5th parameter of the order.
     *
     * @return the 5th parameters of the order.
     */
    public String getParameter5() {
        return parameter5;
    }

    /**
     * Set the 5th parameter of the order.
     *
     * @param thisParam the 5th parameter of the order.
     */
    public void setParameter5(final String thisParam) {
        this.parameter5 = thisParam;
    }

    /**
     * Get the 6th parameter of the order.
     *
     * @return the 6th parameters of the order.
     */
    public String getParameter6() {
        return parameter6;
    }

    /**
     * Set the 6th parameter of the order.
     *
     * @param thisParam the 6th parameter of the order.
     */
    public void setParameter6(final String thisParam) {
        this.parameter6 = thisParam;
    }

    /**
     * Get the 7th parameter of the order.
     *
     * @return the 7th parameters of the order.
     */
    public String getParameter7() {
        return parameter7;
    }

    /**
     * Set the 7th parameter of the order.
     *
     * @param thisParam the 7th parameter of the order.
     */
    public void setParameter7(final String thisParam) {
        this.parameter7 = thisParam;
    }

    /**
     * Get the 8th parameter of the order.
     *
     * @return the 8th parameters of the order.
     */
    public String getParameter8() {
        return parameter8;
    }

    /**
     * Set the 8th parameter of the order.
     *
     * @param thisParam the 8th parameter of the order.
     */
    public void setParameter8(final String thisParam) {
        this.parameter8 = thisParam;
    }

    /**
     * Get the 9th parameter of the order.
     *
     * @return the 9th parameters of the order.
     */
    public String getParameter9() {
        return parameter9;
    }

    /**
     * Set the 9th parameter of the order.
     *
     * @param thisParam the 9th parameter of the order.
     */
    public void setParameter9(final String thisParam) {
        this.parameter9 = thisParam;
    }

    /**
     * Get the 1st temporary value of the order -- used by UI.
     *
     * @return the 1st temporary value of the order -- used by UI.
     */
    public String getTemp1() {
        return temp1;
    }

    /**
     * Set the 1st temporary value of the order -- used by UI
     *
     * @param value the 1st temporary value of the order -- used by UI
     */
    public void setTemp1(final String value) {
        this.temp1 = value;
    }

    /**
     * Get the 2nd temporary value of the order -- used by UI.
     *
     * @return the 2nd temporary value of the order -- used by UI.
     */
    public String getTemp2() {
        return temp2;
    }

    /**
     * Set the 2nd temporary value of the order -- used by UI
     *
     * @param value the 2nd temporary value of the order -- used by UI
     */
    public void setTemp2(final String value) {
        this.temp2 = value;
    }

    /**
     * Get the 3rd temporary value of the order -- used by UI.
     *
     * @return the 3rd temporary value of the order -- used by UI.
     */
    public String getTemp3() {
        return temp3;
    }

    /**
     * Set the 3rd temporary value of the order -- used by UI
     *
     * @param value the 3rd temporary value of the order -- used by UI
     */
    public void setTemp3(final String value) {
        this.temp3 = value;
    }

    /**
     * Get the 4th temporary value of the order -- used by UI.
     *
     * @return the 4th temporary value of the order -- used by UI.
     */
    public String getTemp4() {
        return temp4;
    }

    /**
     * Set the 4th temporary value of the order -- used by UI
     *
     * @param value the 4th temporary value of the order -- used by UI
     */
    public void setTemp4(final String value) {
        this.temp4 = value;
    }

    /**
     * Get the 5th temporary value of the order -- used by UI.
     *
     * @return the 5th temporary value of the order -- used by UI.
     */
    public String getTemp5() {
        return temp5;
    }

    /**
     * Set the 5th temporary value of the order -- used by UI
     *
     * @param value the 5th temporary value of the order -- used by UI
     */
    public void setTemp5(final String value) {
        this.temp5 = value;
    }

    /**
     * Get the 6th temporary value of the order -- used by UI.
     *
     * @return the 6th temporary value of the order -- used by UI.
     */
    public String getTemp6() {
        return temp6;
    }

    /**
     * Set the 6th temporary value of the order -- used by UI
     *
     * @param value the 6th temporary value of the order -- used by UI
     */
    public void setTemp6(final String value) {
        this.temp6 = value;
    }

    /**
     * Get the 7th temporary value of the order -- used by UI.
     *
     * @return the 7th temporary value of the order -- used by UI.
     */
    public String getTemp7() {
        return temp7;
    }

    /**
     * Set the 7th temporary value of the order -- used by UI
     *
     * @param value the 7th temporary value of the order -- used by UI
     */
    public void setTemp7(final String value) {
        this.temp7 = value;
    }

    /**
     * Get the 8th temporary value of the order -- used by UI.
     *
     * @return the 8th temporary value of the order -- used by UI.
     */
    public String getTemp8() {
        return temp8;
    }

    /**
     * Set the 8th temporary value of the order -- used by UI
     *
     * @param value the 8th temporary value of the order -- used by UI
     */
    public void setTemp8(final String value) {
        this.temp8 = value;
    }

    /**
     * Get the 9th temporary value of the order -- used by UI.
     *
     * @return the 9th temporary value of the order -- used by UI.
     */
    public String getTemp9() {
        return temp9;
    }

    /**
     * Set the 9th temporary value of the order -- used by UI
     *
     * @param value the 9th temporary value of the order -- used by UI
     */
    public void setTemp9(final String value) {
        this.temp9 = value;
    }

    /**
     * Get the result of the order.
     *
     * @return the result of the order.
     */
    public int getResult() {
        return result;
    }

    /**
     * Set the result of the order.
     *
     * @param thisResult the result of the order.
     */
    public void setResult(final int thisResult) {
        this.result = thisResult;
    }

    /**
     * Get the explanation of the result in plain text.
     *
     * @return the explanation of the result in plain text.
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * Set the explanation of the result in plain text.
     *
     * @param value the explanation of the result in plain text.
     */
    public void setExplanation(final String value) {
        this.explanation = value;
    }

    /**
     * Get the result of the order at Success or Fail level.
     *
     * @return Success or Fail.
     */
    public String getResultStr() {
        final String result;
        if (getResult() >= 0) {
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }

    /**
     * Get the ordering that the order was processed.
     *
     * @return the ordering that the order was processed.
     */
    public int getProcOrder() {
        return procOrder;
    }

    /**
     * Set the ordering that the order was processed.
     *
     * @param value the ordering that the order was processed.
     */
    public void setProcOrder(final int value) {
        this.procOrder = value;
    }

    /**
     * Get the region that the order subject was located.
     *
     * @return the region that the order subject was located.
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Set the region that the order subject was located.
     *
     * @param thisRegion the region that the order subject was located.
     */
    public void setRegion(final Region thisRegion) {
        this.region = thisRegion;
    }

    /**
     * Get the used goods in the barrack.
     *
     * @return a list with the used goods Quantities.
     */
    public java.util.Map<Integer, Integer> getUsedGoodsQnt() {
        return usedGoodsQnt;
    }

    /**
     * Get the used goods of the order.
     *
     * @param lstGoodsQnt a list with the used goods Quantities.
     */
    public void setUsedGoodsQnt(final java.util.Map<Integer, Integer> lstGoodsQnt) {
        this.usedGoodsQnt = lstGoodsQnt;
    }

}
