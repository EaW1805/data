package com.eaw1805.data.constants;

/**
 * Constants related to Reporting.
 */
public interface RelationConstants {

	/**
	 * The constant representing the alliance state between
	 * two nations
	 */
	int REL_ALLIANCE = 1;
	/**
	 * The constant representing the right of passage state between
	 * two nations
	 */
	int REL_PASSAGE = 2;
	/**
	 * The constant representing the trade state between
	 * two nations
	 */
	int REL_TRADE = 3;
	/**
	 * The constant representing the neutral state between
	 * two nations
	 */
	int REL_COLONIAL_WAR = 4;
	/**
	 * The constant representing the war state between
	 * two nations
	 */
	int REL_WAR = 5;
	
	/**
	 * Constants representing available action when
	 * your state is at war with another nation
	 */
	int NO_ACTION = 0;

	int ACCEPT_SURR = 1;

	int OFFER_SURR = 2;

	int MAKE_PEACE = 3;
	
}