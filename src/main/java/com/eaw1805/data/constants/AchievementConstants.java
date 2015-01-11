package com.eaw1805.data.constants;

/**
 * Constants related to Achievements.
 */
public interface AchievementConstants {

    /**
     * First level achievement.
     */
    int LEVEL_1 = 1;

    /**
     * Second level achievement.
     */
    int LEVEL_2 = 2;

    /**
     * Third level achievement.
     */
    int LEVEL_3 = 3;

    /**
     * Fourth level achievement.
     */
    int LEVEL_4 = 4;

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for VPs.
     */
    int VPS = 1;

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Playing a Nation for a full game achievement.
     */
    int PLAYNATION = 2;

    /**
     * Play nation for a full game.
     */
    String PLAYNATION_STR[] = {"",
            "'The Austrian' Achievement for playing Austria-Hungary for a full game.",
            "'The German' Achievement for playing Confederation of Rhine for a full game.",
            "'The Danish' Achievement for playing Denmark for a full game.",
            "'The Spanish' Achievement for playing Spain for a full game.",
            "'The French' Achievement for playing France for a full game.",
            "'The British' Achievement for playing Great Britain for a full game.",
            "'The Dutch' Achievement for playing Holland for a full game.",
            "'The Italian' Achievement for playing Italy for a full game.",
            "'The Portugese' Achievement for playing Kingdom of Portugal for a full game.",
            "'The Moroccan' Achievement for playing Morocco for a full game.",
            "'The Napolitan' Achievement for playing Kingdom of Naples for a full game.",
            "'The Prussian' Achievement for playing Prussia for a full game.",
            "'The Russian' Achievement for playing Russia for a full game.",
            "'The Swedish' Achievement for playing Sweden for a full game.",
            "'The Ottoman' Achievement for playing Ottoman Empire for a full game.",
            "'The Polish' Achievement for playing Duchy of Warsaw for a full game.",
            "'The Mameluke' Achievement for playing Egypt for a full game.",
            "'The European' Achievement for playing all Nations for a full game."};

    /**
     * Achievement Points for playing the country for a full game.
     */
    int PLAYNATION_AP = 4;

    /**
     * Achievement Points for playing the country for a full game.
     */
    int PLAYNATION_AP_ALL = 40;

    String PLAYNATION_NAME = "Full game play";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Tactical Battles.
     */
    int TACTICAL = 3;

    /**
     * Required number for Tactical Battles to reach level 1.
     */
    int TACTICAL_L1 = 1;

    /**
     * Message for reaching Level 1 for Tactical Battles.
     */
    String TACTICAL_L1_STR = "'Officer Rank' Achievement for winning a tactical battle.";

    /**
     * Achievement Points for reaching Level 1 for Tactical Battles achievement.
     */
    int TACTICAL_L1_AP = 1;

    /**
     * Required number for Tactical Battles to reach level 2.
     */
    int TACTICAL_L2 = 15;

    /**
     * Message for reaching Level 2 for Tactical Battles.
     */
    String TACTICAL_L2_STR = "'Lieutenant Rank' Achievement for winning " + TACTICAL_L2 + " tactical battles.";

    /**
     * Achievement Points for reaching Level 2 for Tactical Battles achievement.
     */
    int TACTICAL_L2_AP = 5;

    /**
     * Required number for Tactical Battles to reach level 3.
     */
    int TACTICAL_L3 = 50;

    /**
     * Message for reaching Level 3 for Tactical Battles.
     */
    String TACTICAL_L3_STR = "'Major Rank' Achievement for winning " + TACTICAL_L3 + " tactical battles.";

    /**
     * Achievement Points for reaching Level 2 for Tactical Battles achievement.
     */
    int TACTICAL_L3_AP = 10;

    /**
     * Required number for Tactical Battles to reach level 4.
     */
    int TACTICAL_L4 = 150;

    /**
     * Message for reaching Level 3 for Tactical Battles.
     */
    String TACTICAL_L4_STR = "'Colonel Rank' Achievement for winning " + TACTICAL_L4 + " tactical battles.";

    /**
     * Achievement Points for reaching Level 4 for Tactical Battles achievement.
     */
    int TACTICAL_L4_AP = 20;

    int TACTICAL_L_MIN = LEVEL_1;
    int TACTICAL_L_MAX = LEVEL_4;

    int[] TACTICAL_L = {0, TACTICAL_L1, TACTICAL_L2, TACTICAL_L3, TACTICAL_L4};
    int[] TACTICAL_AP = {0, TACTICAL_L1_AP, TACTICAL_L2_AP, TACTICAL_L3_AP, TACTICAL_L4_AP};
    String[] TACTICAL_STR = {"", TACTICAL_L1_STR, TACTICAL_L2_STR, TACTICAL_L3_STR, TACTICAL_L4_STR};
    String[] TACTICAL_TITLE = {"", "Officer", "Lieutenant", "Major", "Colonel"};

    String TACTICAL_NAME = "Tactical Warfare";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Naval Battle.
     */
    int NAVAL = 5;

    /**
     * Required number for Naval Battle to reach level 1.
     */
    int NAVAL_L1 = 1;

    /**
     * Message for reaching Level 1 for Naval Battle.
     */
    String NAVAL_L1_STR = "'Ensign Rank' Achievement for winning a naval battle.";

    /**
     * Achievement Points for reaching Level 1 for Naval Battle achievement.
     */
    int NAVAL_L1_AP = 1;

    /**
     * Required number for Naval Battle to reach level 2.
     */
    int NAVAL_L2 = 10;

    /**
     * Message for reaching Level 2 for Naval Battle.
     */
    String NAVAL_L2_STR = "'Captain Rank' Achievement for winning " + NAVAL_L2 + " naval battles.";

    /**
     * Achievement Points for reaching Level 2 for Naval Battle achievement.
     */
    int NAVAL_L2_AP = 4;

    /**
     * Required number for Naval Battle to reach level 3.
     */
    int NAVAL_L3 = 25;

    /**
     * Message for reaching Level 3 for Naval Battle.
     */
    String NAVAL_L3_STR = "'Admiral Rank' Achievement for winning " + NAVAL_L3 + " naval battles.";

    /**
     * Achievement Points for reaching Level 2 for Naval Battle achievement.
     */
    int NAVAL_L3_AP = 8;

    /**
     * Required number for Naval Battle to reach level 4.
     */
    int NAVAL_L4 = 60;

    /**
     * Message for reaching Level 3 for Naval Battle.
     */
    String NAVAL_L4_STR = "'Fleet Admiral Rank' Achievement for winning " + NAVAL_L4 + " naval battles.";

    /**
     * Achievement Points for reaching Level 4 for Naval Battle achievement.
     */
    int NAVAL_L4_AP = 20;

    int NAVAL_L_MIN = LEVEL_1;
    int NAVAL_L_MAX = LEVEL_4;

    int[] NAVAL_L = {0, NAVAL_L1, NAVAL_L2, NAVAL_L3, NAVAL_L4};
    int[] NAVAL_AP = {0, NAVAL_L1_AP, NAVAL_L2_AP, NAVAL_L3_AP, NAVAL_L4_AP};
    String[] NAVAL_STR = {"", NAVAL_L1_STR, NAVAL_L2_STR, NAVAL_L3_STR, NAVAL_L4_STR};
    String[] NAVAL_TITLE = {"", "Ensign", "Captain", "Admiral", "Fleet Admiral"};

    String NAVAL_NAME = "Naval Warfare";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Enemy Commanders killed in Battle.
     */
    int COMKILL = 6;

    /**
     * Required number for Enemy Commanders killed in Battle to reach level 1.
     */
    int COMKILL_L1 = 1;

    /**
     * Message for reaching Level 1 for Enemy Commanders killed in Battle.
     */
    String COMKILL_L1_STR = "'Lucky shot' Achievement for killing an enemy commander in battle.";

    /**
     * Achievement Points for reaching Level 1 for Enemy Commanders killed in Battle achievement.
     */
    int COMKILL_L1_AP = 1;

    /**
     * Required number for Enemy Commanders killed in Battle to reach level 2.
     */
    int COMKILL_L2 = 10;

    /**
     * Message for reaching Level 2 for Enemy Commanders killed in Battle.
     */
    String COMKILL_L2_STR = "'Ambusher' Achievement for killing " + COMKILL_L2 + " enemy commanders in battles.";

    /**
     * Achievement Points for reaching Level 2 for Enemy Commanders killed in Battle achievement.
     */
    int COMKILL_L2_AP = 5;

    /**
     * Required number for Enemy Commanders killed in Battle to reach level 3.
     */
    int COMKILL_L3 = 25;

    /**
     * Message for reaching Level 3 for Enemy Commanders killed in Battle.
     */
    String COMKILL_L3_STR = "'Assasin' Achievement for killing " + COMKILL_L3 + " enemy commanders in battles.";

    /**
     * Achievement Points for reaching Level 2 for Enemy Commanders killed in Battle achievement.
     */
    int COMKILL_L3_AP = 10;

    int COMKILL_L_MIN = LEVEL_1;
    int COMKILL_L_MAX = LEVEL_3;

    int[] COMKILL_L = {0, COMKILL_L1, COMKILL_L2, COMKILL_L3};
    int[] COMKILL_AP = {0, COMKILL_L1_AP, COMKILL_L2_AP, COMKILL_L3_AP};
    String[] COMKILL_STR = {"", COMKILL_L1_STR, COMKILL_L2_STR, COMKILL_L3_STR};
    String[] COMKILL_TITLE = {"", "Lucky shot", "Ambusher", "Assasin"};

    String COMKILL_NAME = "Commander kills";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Declaring War achievement.
     */
    int WAR = 7;

    /**
     * Required number for Declaring War achievement to reach level 1.
     */
    int WAR_L1 = 1;

    /**
     * Message for reaching Level 1 for Declaring War achievement.
     */
    String WAR_L1_STR = "'Courageous' Achievement for declaring your first war.";

    /**
     * Achievement Points for reaching Level 1 for Declaring War achievement.
     */
    int WAR_L1_AP = 1;

    /**
     * Required number for Declaring War achievement to reach level 2.
     */
    int WAR_L2 = 20;

    /**
     * Message for reaching Level 2 for Declaring War achievement.
     */
    String WAR_L2_STR = "'Defiant' Achievement for declaring " + WAR_L2 + " wars.";

    /**
     * Achievement Points for reaching Level 2 for Declaring War achievement.
     */
    int WAR_L2_AP = 5;

    /**
     * Required number for Declaring War achievement to reach level 3.
     */
    int WAR_L3 = 50;

    /**
     * Message for reaching Level 3 for Declaring War achievement.
     */
    String WAR_L3_STR = "'Warmonger' Achievement for declaring " + WAR_L3 + " wars.";

    /**
     * Achievement Points for reaching Level 2 for Declaring War achievement.
     */
    int WAR_L3_AP = 10;

    int WAR_L_MIN = LEVEL_1;
    int WAR_L_MAX = LEVEL_3;

    int[] WAR_L = {0, WAR_L1, WAR_L2, WAR_L3};
    int[] WAR_AP = {0, WAR_L1_AP, WAR_L2_AP, WAR_L3_AP};
    String[] WAR_STR = {"", WAR_L1_STR, WAR_L2_STR, WAR_L3_STR};
    String[] WAR_TITLE = {"", "Courageous", "Defiant", "Warmonger"};

    String WAR_NAME = "War Declarations";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Making Alliance achievement.
     */
    int ALLIANCE = 8;

    /**
     * Required number for Making Alliance achievement to reach level 1.
     */
    int ALLIANCE_L1 = 1;

    /**
     * Message for reaching Level 1 for Making Alliance achievement.
     */
    String ALLIANCE_L1_STR = "'Ally' Achievement for establishing your first alliance.";

    /**
     * Achievement Points for reaching Level 1 for Making Alliance achievement.
     */
    int ALLIANCE_L1_AP = 1;

    /**
     * Required number for Making Alliance achievement to reach level 2.
     */
    int ALLIANCE_L2 = 30;

    /**
     * Message for reaching Level 2 for Making Alliance achievement.
     */
    String ALLIANCE_L2_STR = "'Politician' Achievement for establishing " + ALLIANCE_L2 + " alliances.";

    /**
     * Achievement Points for reaching Level 2 for Making Alliance achievement.
     */
    int ALLIANCE_L2_AP = 5;

    /**
     * Required number for Making Alliance achievement to reach level 3.
     */
    int ALLIANCE_L3 = 70;

    /**
     * Message for reaching Level 3 for Making Alliance achievement.
     */
    String ALLIANCE_L3_STR = "'Manipulator' Achievement for establishing " + ALLIANCE_L3 + " alliances.";

    /**
     * Achievement Points for reaching Level 2 for Making Alliance achievement.
     */
    int ALLIANCE_L3_AP = 10;

    int ALLIANCE_L_MIN = LEVEL_1;
    int ALLIANCE_L_MAX = LEVEL_3;

    int[] ALLIANCE_L = {0, ALLIANCE_L1, ALLIANCE_L2, ALLIANCE_L3};
    int[] ALLIANCE_AP = {0, ALLIANCE_L1_AP, ALLIANCE_L2_AP, ALLIANCE_L3_AP};
    String[] ALLIANCE_STR = {"", ALLIANCE_L1_STR, ALLIANCE_L2_STR, ALLIANCE_L3_STR};
    String[] ALLIANCE_TITLE = {"", "Ally", "Politician", "Manipulator"};

    String ALLIANCE_NAME = "Alliance Formations";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Accepting Surrender.
     */
    int SURRENDERS = 9;

    /**
     * Required number for Accepting Surrender to reach level 1.
     */
    int SURRENDERS_L1 = 1;

    /**
     * Message for reaching Level 1 for Accepting Surrender.
     */
    String SURRENDERS_L1_STR = "'Victorious' Achievement for accepting a surrender.";

    /**
     * Achievement Points for reaching Level 1 for Accepting Surrender achievement.
     */
    int SURRENDERS_L1_AP = 2;

    /**
     * Required number for Accepting Surrender to reach level 2.
     */
    int SURRENDERS_L2 = 5;

    /**
     * Message for reaching Level 2 for Accepting Surrender.
     */
    String SURRENDERS_L2_STR = "'Prestigious' Achievement for accepting " + SURRENDERS_L2 + " surrenders.";

    /**
     * Achievement Points for reaching Level 2 for Accepting Surrender achievement.
     */
    int SURRENDERS_L2_AP = 8;

    /**
     * Required number for Accepting Surrender to reach level 3.
     */
    int SURRENDERS_L3 = 15;

    /**
     * Message for reaching Level 3 for Accepting Surrender.
     */
    String SURRENDERS_L3_STR = "'Powerful' Achievement for accepting " + SURRENDERS_L3 + " surrenders.";

    /**
     * Achievement Points for reaching Level 2 for Accepting Surrender achievement.
     */
    int SURRENDERS_L3_AP = 20;

    /**
     * Required number for Accepting Surrender to reach level 4.
     */
    int SURRENDERS_L4 = 40;

    /**
     * Message for reaching Level 3 for Accepting Surrender.
     */
    String SURRENDERS_L4_STR = "'Dominant' Achievement for accepting " + SURRENDERS_L4 + " surrenders.";

    /**
     * Achievement Points for reaching Level 4 for Accepting Surrender achievement.
     */
    int SURRENDERS_L4_AP = 40;

    int SURRENDERS_L_MIN = LEVEL_1;
    int SURRENDERS_L_MAX = LEVEL_4;

    int[] SURRENDERS_L = {0, SURRENDERS_L1, SURRENDERS_L2, SURRENDERS_L3, SURRENDERS_L4};
    int[] SURRENDERS_AP = {0, SURRENDERS_L1_AP, SURRENDERS_L2_AP, SURRENDERS_L3_AP, SURRENDERS_L4_AP};
    String[] SURRENDERS_STR = {"", SURRENDERS_L1_STR, SURRENDERS_L2_STR, SURRENDERS_L3_STR, SURRENDERS_L4_STR};
    String[] SURRENDERS_TITLE = {"", "Victorious", "Prestigious", "Powerful", "Dominant"};

    String SURRENDERS_NAME = "Accepting Surrenders";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Accepting a Call to Allies achievement.
     */
    int CALLACCEPT = 10;

    /**
     * Required number for Accepting a Call to Allies achievement to reach level 1.
     */
    int CALLACCEPT_L1 = 1;

    /**
     * Message for reaching Level 1 for Accepting a Call to Allies achievement.
     */
    String CALLACCEPT_L1_STR = "'Ethical' Achievement for accepting your first call from ally.";

    /**
     * Achievement Points for reaching Level 1 for Accepting a Call to Allies achievement.
     */
    int CALLACCEPT_L1_AP = 1;

    /**
     * Required number for Accepting a Call to Allies achievement to reach level 2.
     */
    int CALLACCEPT_L2 = 20;

    /**
     * Message for reaching Level 2 for Accepting a Call to Allies achievement.
     */
    String CALLACCEPT_L2_STR = "'Honorable' Achievement for accepting " + CALLACCEPT_L2 + " calls from allies.";

    /**
     * Achievement Points for reaching Level 2 for Accepting a Call to Allies achievement.
     */
    int CALLACCEPT_L2_AP = 3;

    /**
     * Required number for Accepting a Call to Allies achievement to reach level 3.
     */
    int CALLACCEPT_L3 = 50;

    /**
     * Message for reaching Level 3 for Accepting a Call to Allies achievement.
     */
    String CALLACCEPT_L3_STR = "'Noble' Achievement for accepting " + CALLACCEPT_L3 + " calls from allies.";

    /**
     * Achievement Points for reaching Level 2 for Accepting a Call to Allies achievement.
     */
    int CALLACCEPT_L3_AP = 8;

    int CALLACCEPT_L_MIN = LEVEL_1;
    int CALLACCEPT_L_MAX = LEVEL_3;

    int[] CALLACCEPT_L = {0, CALLACCEPT_L1, CALLACCEPT_L2, CALLACCEPT_L3};
    int[] CALLACCEPT_AP = {0, CALLACCEPT_L1_AP, CALLACCEPT_L2_AP, CALLACCEPT_L3_AP};
    String[] CALLACCEPT_STR = {"", CALLACCEPT_L1_STR, CALLACCEPT_L2_STR, CALLACCEPT_L3_STR};
    String[] CALLACCEPT_TITLE = {"", "Ethical", "Honorable", "Noble"};

    String CALLACCEPT_NAME = "Call from Allies Responses";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Rejecting a Call to Allies achievement.
     */
    int CALLREJECT = 11;

    /**
     * Required number for Rejecting a Call to Allies achievement to reach level 1.
     */
    int CALLREJECT_L1 = 1;

    /**
     * Message for reaching Level 1 for Rejecting a Call to Allies achievement.
     */
    String CALLREJECT_L1_STR = "'Subtle' Achievement for your first reject of a call from ally.";

    /**
     * Achievement Points for reaching Level 1 for Rejecting a Call to Allies achievement.
     */
    int CALLREJECT_L1_AP = 1;

    /**
     * Required number for Rejecting a Call to Allies achievement to reach level 2.
     */
    int CALLREJECT_L2 = 20;

    /**
     * Message for reaching Level 2 for Rejecting a Call to Allies achievement.
     */
    String CALLREJECT_L2_STR = "'Cunning' Achievement for rejecting " + CALLREJECT_L2 + " calls from allies.";

    /**
     * Achievement Points for reaching Level 2 for Rejecting a Call to Allies achievement.
     */
    int CALLREJECT_L2_AP = 3;

    /**
     * Required number for Rejecting a Call to Allies achievement to reach level 3.
     */
    int CALLREJECT_L3 = 50;

    /**
     * Message for reaching Level 3 for Rejecting a Call to Allies achievement.
     */
    String CALLREJECT_L3_STR = "'Deceiver' Achievement for rejecting " + CALLREJECT_L3 + " calls from allies.";

    /**
     * Achievement Points for reaching Level 2 for Rejecting a Call to Allies achievement.
     */
    int CALLREJECT_L3_AP = 8;

    int CALLREJECT_L_MIN = LEVEL_1;
    int CALLREJECT_L_MAX = LEVEL_3;

    int[] CALLREJECT_L = {0, CALLREJECT_L1, CALLREJECT_L2, CALLREJECT_L3};
    int[] CALLREJECT_AP = {0, CALLREJECT_L1_AP, CALLREJECT_L2_AP, CALLREJECT_L3_AP};
    String[] CALLREJECT_STR = {"", CALLREJECT_L1_STR, CALLREJECT_L2_STR, CALLREJECT_L3_STR};
    String[] CALLREJECT_TITLE = {"", "Subtle", "Cunning", "Deceiver"};

    String CALLREJECT_NAME = "Call from Allies Rejections";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Building Huge Fortress achievement.
     */
    int BUILDHUGE = 12;

    /**
     * Required number for Building Huge Fortress achievement to reach level 1.
     */
    int BUILDHUGE_L1 = 1;

    /**
     * Message for reaching Level 1 for Building Huge Fortress achievement.
     */
    String BUILDHUGE_L1_STR = "'Builder' Achievement for building your first huge fortress.";

    /**
     * Achievement Points for reaching Level 1 for Building Huge Fortress achievement.
     */
    int BUILDHUGE_L1_AP = 2;

    /**
     * Required number for Building Huge Fortress achievement to reach level 2.
     */
    int BUILDHUGE_L2 = 10;

    /**
     * Message for reaching Level 2 for Building Huge Fortress achievement.
     */
    String BUILDHUGE_L2_STR = "'Defender' Achievement for building " + BUILDHUGE_L2 + " huge fortresses.";

    /**
     * Achievement Points for reaching Level 2 for Building Huge Fortress achievement.
     */
    int BUILDHUGE_L2_AP = 7;

    /**
     * Required number for Building Huge Fortress achievement to reach level 3.
     */
    int BUILDHUGE_L3 = 30;

    /**
     * Message for reaching Level 3 for Building Huge Fortress achievement.
     */
    String BUILDHUGE_L3_STR = "'Architect' Achievement for building " + BUILDHUGE_L3 + " huge fortresses.";

    /**
     * Achievement Points for reaching Level 2 for Building Huge Fortress achievement.
     */
    int BUILDHUGE_L3_AP = 15;

    int BUILDHUGE_L_MIN = LEVEL_1;
    int BUILDHUGE_L_MAX = LEVEL_3;

    int[] BUILDHUGE_L = {0, BUILDHUGE_L1, BUILDHUGE_L2, BUILDHUGE_L3};
    int[] BUILDHUGE_AP = {0, BUILDHUGE_L1_AP, BUILDHUGE_L2_AP, BUILDHUGE_L3_AP};
    String[] BUILDHUGE_STR = {"", BUILDHUGE_L1_STR, BUILDHUGE_L2_STR, BUILDHUGE_L3_STR};
    String[] BUILDHUGE_TITLE = {"", "Builder", "Defender", "Architect"};

    String BUILDHUGE_NAME = "Huge Fortresses Construction";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Conquering Huge/Large Fortress achievement.
     */
    int CONQUERHUGE = 13;

    /**
     * Required number for Conquering Huge/Large Fortress achievement to reach level 1.
     */
    int CONQUERHUGE_L1 = 1;

    /**
     * Message for reaching Level 1 for Conquering Huge/Large Fortress achievement.
     */
    String CONQUERHUGE_L1_STR = "'Sieger' Achievement for conquering your first huge/large fortress.";

    /**
     * Achievement Points for reaching Level 1 for Conquering Huge/Large Fortress achievement.
     */
    int CONQUERHUGE_L1_AP = 1;

    /**
     * Required number for Conquering Huge/Large Fortress achievement to reach level 2.
     */
    int CONQUERHUGE_L2 = 20;

    /**
     * Message for reaching Level 2 for Conquering Huge/Large Fortress achievement.
     */
    String CONQUERHUGE_L2_STR = "'Destroyer' Achievement for conquering " + CONQUERHUGE_L2 + " huge/large fortresses.";

    /**
     * Achievement Points for reaching Level 2 for Conquering Huge/Large Fortress achievement.
     */
    int CONQUERHUGE_L2_AP = 6;

    /**
     * Required number for Conquering Huge/Large Fortress achievement to reach level 3.
     */
    int CONQUERHUGE_L3 = 50;

    /**
     * Message for reaching Level 3 for Conquering Huge/Large Fortress achievement.
     */
    String CONQUERHUGE_L3_STR = "'Vanquisher' Achievement for conquering " + CONQUERHUGE_L3 + " huge/large fortresses.";

    /**
     * Achievement Points for reaching Level 3 for Conquering Huge/Large Fortress achievement.
     */
    int CONQUERHUGE_L3_AP = 10;

    int CONQUERHUGE_L_MIN = LEVEL_1;
    int CONQUERHUGE_L_MAX = LEVEL_3;

    int[] CONQUERHUGE_L = {0, CONQUERHUGE_L1, CONQUERHUGE_L2, CONQUERHUGE_L3};
    int[] CONQUERHUGE_AP = {0, CONQUERHUGE_L1_AP, CONQUERHUGE_L2_AP, CONQUERHUGE_L3_AP};
    String[] CONQUERHUGE_STR = {"", CONQUERHUGE_L1_STR, CONQUERHUGE_L2_STR, CONQUERHUGE_L3_STR};
    String[] CONQUERHUGE_TITLE = {"", "Sieger", "Destroyer", "Vanquisher"};

    String CONQUERHUGE_NAME = "Huge Fortresses Conquers";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Winning a Nation for a full game achievement.
     */
    int WINNATION = 14;

    /**
     * Win with Nation for a full game.
     */
    String WINNATION_STR[] = {"",
            "'Austrian Emperor' Achievement for winning a game with Austria-Hungary.",
            "'German Emperor' Achievement for winning a game with Confederation of Rhine.",
            "'Danish Emperor' Achievement for winning a game with Denmark.",
            "'Spanish Emperor' Achievement for winning a game with Spain.",
            "'French Emperor' Achievement for winning a game with France.",
            "'British Emperor' Achievement for winning a game with Great Britain.",
            "'Dutch Emperor' Achievement for winning a game with Holland.",
            "'Italian Emperor' Achievement for winning a game with Italy.",
            "'Portugese Emperor' Achievement for winning a game with Kingdom of Portugal.",
            "'Moroccan Sultan' Achievement for winning a game with Morocco.",
            "'Napolitan Emperor' Achievement for winning a game with Kingdom of Naples.",
            "'Prussian Emperor' Achievement for winning a game with Prussia.",
            "'Russian Emperor' Achievement for winning a game with Russia.",
            "'Swedish Emperor' Achievement for winning a game with Sweden.",
            "'Ottoman Sultan' Achievement for winning a game with Ottoman com.eaw1805.",
            "'Polish Emperor' Achievement for winning a game with Duchy of Warsaw.",
            "'Mameluke Sultan' Achievement for winning a game with Egypt.",
            "'Great Imperator' Achievement for winning a game with each Nation.",
            "'Grand Sultan' Achievement for winning a game with each Muslim Nation.",
            "'Infamous General' Achievement for winning a game with each Militaristic Nation.",
            "'Peacemaker' Achievement for winning a game with each Agricultural Nation.",
            "'Master of the Industry' Achievement for winning a game with each Industrius Nation.",
            "'Infamous Admiral' Achievement for winning a game with each Maritime Nation.",
            "'Great Merchant' Achievement for winning a game with each Merchantile Nation."};

    /**
     * Achievement Points for winning with the country.
     */
    int WINNATION_AP[] = {0,
            11,
            15,
            15,
            11,
            10,
            10,
            12,
            14,
            13,
            13,
            15,
            11,
            10,
            12,
            12,
            12,
            13,
            100,
            15,
            15,
            40,
            10,
            10,
            10};

    String WINNATION_NAME = "World Domination";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Number of turns played.
     */
    int TURNSPLAYED = 15;

    /**
     * Constant for Number of solo turns played.
     */
    int TURNSPLAYED_SOLO = 16;


    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Setting Up Colonies achievement.
     */
    int SETUPCOLONIES = 19;

    /**
     * Required number for Setting Up Colonies achievement to reach level 1.
     */
    int SETUPCOLONIES_L1 = 1;

    /**
     * Message for reaching Level 1 for Setting Up Colonies achievement.
     */
    String SETUPCOLONIES_L1_STR = "'Pathfinder' Achievement for starting up your first colony.";

    /**
     * Achievement Points for reaching Level 1 for Setting Up Colonies achievement.
     */
    int SETUPCOLONIES_L1_AP = 1;

    /**
     * Required number for Setting Up Colonies achievement to reach level 2.
     */
    int SETUPCOLONIES_L2 = 10;

    /**
     * Message for reaching Level 2 for Setting Up Colonies achievement.
     */
    String SETUPCOLONIES_L2_STR = "'Adventurer' Achievement for starting up " + SETUPCOLONIES_L2 + " colonies.";

    /**
     * Achievement Points for reaching Level 2 for Setting Up Colonies achievement.
     */
    int SETUPCOLONIES_L2_AP = 6;

    /**
     * Required number for Setting Up Colonies achievement to reach level 3.
     */
    int SETUPCOLONIES_L3 = 25;

    /**
     * Message for reaching Level 3 for Setting Up Colonies achievement.
     */
    String SETUPCOLONIES_L3_STR = "'Explorer' Achievement for starting up " + SETUPCOLONIES_L3 + " colonies.";

    /**
     * Achievement Points for reaching Level 3 for Setting Up Colonies achievement.
     */
    int SETUPCOLONIES_L3_AP = 10;

    int SETUPCOLONIES_L_MIN = LEVEL_1;
    int SETUPCOLONIES_L_MAX = LEVEL_3;

    int[] SETUPCOLONIES_L = {0, SETUPCOLONIES_L1, SETUPCOLONIES_L2, SETUPCOLONIES_L3};
    int[] SETUPCOLONIES_AP = {0, SETUPCOLONIES_L1_AP, SETUPCOLONIES_L2_AP, SETUPCOLONIES_L3_AP};
    String[] SETUPCOLONIES_STR = {"", SETUPCOLONIES_L1_STR, SETUPCOLONIES_L2_STR, SETUPCOLONIES_L3_STR};
    String[] SETUPCOLONIES_TITLE = {"", "Pathfinder", "Adventurer", "Explorer"};

    String SETUPCOLONIES_NAME = "Colonies Established";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Conquering enemy capitals achievement.
     */
    int CONQUERCAPITALS = 18;

    /**
     * Required number for Conquering enemy capitals achievement to reach level 1.
     */
    int CONQUERCAPITALS_L1 = 1;

    /**
     * Message for reaching Level 1 for Conquering enemy capitals achievement.
     */
    String CONQUERCAPITALS_L1_STR = "'Expander' Achievement for conquering your first enemy capital.";

    /**
     * Achievement Points for reaching Level 1 for Conquering enemy capitals achievement.
     */
    int CONQUERCAPITALS_L1_AP = 2;

    /**
     * Required number for Conquering enemy capitals achievement to reach level 2.
     */
    int CONQUERCAPITALS_L2 = 10;

    /**
     * Message for reaching Level 2 for Conquering enemy capitals achievement.
     */
    String CONQUERCAPITALS_L2_STR = "'Conqueror' Achievement for conquering " + CONQUERCAPITALS_L2 + " enemy capitals.";

    /**
     * Achievement Points for reaching Level 2 for Conquering enemy capitals achievement.
     */
    int CONQUERCAPITALS_L2_AP = 8;

    /**
     * Required number for Conquering enemy capitals achievement to reach level 3.
     */
    int CONQUERCAPITALS_L3 = 20;

    /**
     * Message for reaching Level 3 for Conquering enemy capitals achievement.
     */
    String CONQUERCAPITALS_L3_STR = "'Overlord' Achievement for conquering " + CONQUERCAPITALS_L3 + " enemy capitals.";

    /**
     * Achievement Points for reaching Level 3 for Conquering enemy capitals achievement.
     */
    int CONQUERCAPITALS_L3_AP = 20;

    int CONQUERCAPITALS_L_MIN = LEVEL_1;
    int CONQUERCAPITALS_L_MAX = LEVEL_3;

    int[] CONQUERCAPITALS_L = {0, CONQUERCAPITALS_L1, CONQUERCAPITALS_L2, CONQUERCAPITALS_L3};
    int[] CONQUERCAPITALS_AP = {0, CONQUERCAPITALS_L1_AP, CONQUERCAPITALS_L2_AP, CONQUERCAPITALS_L3_AP};
    String[] CONQUERCAPITALS_STR = {"", CONQUERCAPITALS_L1_STR, CONQUERCAPITALS_L2_STR, CONQUERCAPITALS_L3_STR};
    String[] CONQUERCAPITALS_TITLE = {"", "Expander", "Conqueror", "Overlord"};

    String CONQUERCAPITALS_NAME = "Capitals Conquered";


    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Sinking Enemy Ships Contributions achievement.
     */
    int ENEMYSINKS = 20;

    /**
     * Required number for Sinking Enemy Ships Contributions achievement to reach level 1.
     */
    int ENEMYSINKS_L1 = 10;

    /**
     * Message for reaching Level 1 for Sinking Enemy Ships Contributions achievement.
     */
    String ENEMYSINKS_L1_STR = "'Sea Raider' Achievement for destroying or capturing 10 enemy warships.";

    /**
     * Achievement Points for reaching Level 1 for Sinking Enemy Ships Contributions achievement.
     */
    int ENEMYSINKS_L1_AP = 3;

    /**
     * Required number for Sinking Enemy Ships Contributions achievement to reach level 2.
     */
    int ENEMYSINKS_L2 = 150;

    /**
     * Message for reaching Level 2 for Sinking Enemy Ships Contributions achievement.
     */
    String ENEMYSINKS_L2_STR = "'Ruler of the Waves' Achievement for destroying or capturing 150 enemy warships.";

    /**
     * Achievement Points for reaching Level 2 for Sinking Enemy Ships Contributions achievement.
     */
    int ENEMYSINKS_L2_AP = 12;

    /**
     * Required number for Sinking Enemy Ships Contributions achievement to reach level 3.
     */
    int ENEMYSINKS_L3 = 400;

    /**
     * Message for reaching Level 3 for Sinking Enemy Ships Contributions achievement.
     */
    String ENEMYSINKS_L3_STR = "'Terror of the High Seas' Achievement for destroying or capturing 400 enemy warships.";

    /**
     * Achievement Points for reaching Level 3 for Sinking Enemy Ships Contributions achievement.
     */
    int ENEMYSINKS_L3_AP = 30;

    int ENEMYSINKS_L_MIN = LEVEL_1;
    int ENEMYSINKS_L_MAX = LEVEL_3;

    int[] ENEMYSINKS_L = {0, ENEMYSINKS_L1, ENEMYSINKS_L2, ENEMYSINKS_L3};
    int[] ENEMYSINKS_AP = {0, ENEMYSINKS_L1_AP, ENEMYSINKS_L2_AP, ENEMYSINKS_L3_AP};
    String[] ENEMYSINKS_STR = {"", ENEMYSINKS_L1_STR, ENEMYSINKS_L2_STR, ENEMYSINKS_L3_STR};
    String[] ENEMYSINKS_TITLE = {"", "Sea Raider", "Ruler of the Waves", "Terror of the High Seas"};

    String ENEMYSINKS_NAME = "Destroy Enemy Warships";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Sinking Enemy Merchants Contributions achievement.
     */
    int ENEMYMERCHANTS = 21;

    /**
     * Required number for Sinking Enemy Merchants Contributions achievement to reach level 1.
     */
    int ENEMYMERCHANTS_L1 = 5;

    /**
     * Message for reaching Level 1 for Sinking Enemy Merchants Contributions achievement.
     */
    String ENEMYMERCHANTS_L1_STR = "'Treasure Hunter' Achievement for destroying or capturing 5 Enemy merchants.";

    /**
     * Achievement Points for reaching Level 1 for Sinking Enemy Merchants Contributions achievement.
     */
    int ENEMYMERCHANTS_L1_AP = 2;

    /**
     * Required number for Sinking Enemy Merchants Contributions achievement to reach level 2.
     */
    int ENEMYMERCHANTS_L2 = 70;

    /**
     * Message for reaching Level 2 for Sinking Enemy Merchants Contributions achievement.
     */
    String ENEMYMERCHANTS_L2_STR = "'Buccaneer' Achievement for destroying or capturing 70 Enemy merchants.";

    /**
     * Achievement Points for reaching Level 2 for Sinking Enemy Merchants Contributions achievement.
     */
    int ENEMYMERCHANTS_L2_AP = 10;

    /**
     * Required number for Sinking Enemy Merchants Contributions achievement to reach level 3.
     */
    int ENEMYMERCHANTS_L3 = 250;

    /**
     * Message for reaching Level 3 for Sinking Enemy Merchants Contributions achievement.
     */
    String ENEMYMERCHANTS_L3_STR = "'Pirate King' Achievement for destroying or capturing 250 Enemy merchants.";

    /**
     * Achievement Points for reaching Level 3 for Sinking Enemy Merchants Contributions achievement.
     */
    int ENEMYMERCHANTS_L3_AP = 20;

    int ENEMYMERCHANTS_L_MIN = LEVEL_1;
    int ENEMYMERCHANTS_L_MAX = LEVEL_3;

    int[] ENEMYMERCHANTS_L = {0, ENEMYMERCHANTS_L1, ENEMYMERCHANTS_L2, ENEMYMERCHANTS_L3};
    int[] ENEMYMERCHANTS_AP = {0, ENEMYMERCHANTS_L1_AP, ENEMYMERCHANTS_L2_AP, ENEMYMERCHANTS_L3_AP};
    String[] ENEMYMERCHANTS_STR = {"", ENEMYMERCHANTS_L1_STR, ENEMYMERCHANTS_L2_STR, ENEMYMERCHANTS_L3_STR};
    String[] ENEMYMERCHANTS_TITLE = {"", "Treasure Hunter", "Buccaneer", "Pirate King"};

    String ENEMYMERCHANTS_NAME = "Destroy Enemy merchants";


    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Newsletter Contributions achievement.
     */
    int NEWSLETTERPOSTS = 22;

    /**
     * Required number for Newsletter Contributions achievement to reach level 1.
     */
    int NEWSLETTERPOSTS_L1 = 5;

    /**
     * Message for reaching Level 1 for Newsletter Contributions achievement.
     */
    String NEWSLETTERPOSTS_L1_STR = "'Ambassador' Achievement for contributing five newsletter posts.";

    /**
     * Achievement Points for reaching Level 1 for Newsletter Contributions achievement.
     */
    int NEWSLETTERPOSTS_L1_AP = 1;

    /**
     * Required number for Newsletter Contributions achievement to reach level 2.
     */
    int NEWSLETTERPOSTS_L2 = 20;

    /**
     * Message for reaching Level 2 for Newsletter Contributions achievement.
     */
    String NEWSLETTERPOSTS_L2_STR = "'Diplomat' Achievement for contributing " + NEWSLETTERPOSTS_L2 + " newsletter posts.";

    /**
     * Achievement Points for reaching Level 2 for Newsletter Contributions achievement.
     */
    int NEWSLETTERPOSTS_L2_AP = 3;

    /**
     * Required number for Newsletter Contributions achievement to reach level 3.
     */
    int NEWSLETTERPOSTS_L3 = 100;

    /**
     * Message for reaching Level 3 for Newsletter Contributions achievement.
     */
    String NEWSLETTERPOSTS_L3_STR = "'Cabinet Member' Achievement for contributing " + NEWSLETTERPOSTS_L3 + " newsletter posts.";

    /**
     * Achievement Points for reaching Level 3 for Newsletter Contributions achievement.
     */
    int NEWSLETTERPOSTS_L3_AP = 6;

    /**
     * Required number for Newsletter Contributions achievement to reach level 3.
     */
    int NEWSLETTERPOSTS_L4 = 200;

    /**
     * Message for reaching Level 3 for Newsletter Contributions achievement.
     */
    String NEWSLETTERPOSTS_L4_STR = "'Head of Propaganda' Achievement for contributing " + NEWSLETTERPOSTS_L4 + " newsletter posts.";

    /**
     * Achievement Points for reaching Level 3 for Newsletter Contributions achievement.
     */
    int NEWSLETTERPOSTS_L4_AP = 10;

    int NEWSLETTERPOSTS_L_MIN = LEVEL_1;
    int NEWSLETTERPOSTS_L_MAX = LEVEL_4;

    int[] NEWSLETTERPOSTS_L = {0, NEWSLETTERPOSTS_L1, NEWSLETTERPOSTS_L2, NEWSLETTERPOSTS_L3, NEWSLETTERPOSTS_L4};
    int[] NEWSLETTERPOSTS_AP = {0, NEWSLETTERPOSTS_L1_AP, NEWSLETTERPOSTS_L2_AP, NEWSLETTERPOSTS_L3_AP, NEWSLETTERPOSTS_L4_AP};
    String[] NEWSLETTERPOSTS_STR = {"", NEWSLETTERPOSTS_L1_STR, NEWSLETTERPOSTS_L2_STR, NEWSLETTERPOSTS_L3_STR, NEWSLETTERPOSTS_L4_STR};
    String[] NEWSLETTERPOSTS_TITLE = {"", "Ambassador", "Diplomat", "Cabinet Member", "Head of Propaganda"};

    String NEWSLETTERPOSTS_NAME = "Newsletter Postings";


    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for FORUM Contributions achievement.
     */
    int FORUMPOSTS = 23;

    /**
     * Required number for FORUM Contributions achievement to reach level 1.
     */
    int FORUMPOSTS_L1 = 10;

    /**
     * Message for reaching Level 1 for FORUM Contributions achievement.
     */
    String FORUMPOSTS_L1_STR = "'Writter' Achievement for contributing ten Forum posts.";

    /**
     * Achievement Points for reaching Level 1 for FORUM Contributions achievement.
     */
    int FORUMPOSTS_L1_AP = 0;

    /**
     * Required number for FORUM Contributions achievement to reach level 2.
     */
    int FORUMPOSTS_L2 = 50;

    /**
     * Message for reaching Level 2 for FORUM Contributions achievement.
     */
    String FORUMPOSTS_L2_STR = "'Agent' Achievement for contributing " + FORUMPOSTS_L2 + " Forum posts.";

    /**
     * Achievement Points for reaching Level 2 for FORUM Contributions achievement.
     */
    int FORUMPOSTS_L2_AP = 0;

    /**
     * Required number for FORUM Contributions achievement to reach level 3.
     */
    int FORUMPOSTS_L3 = 250;

    /**
     * Message for reaching Level 3 for FORUM Contributions achievement.
     */
    String FORUMPOSTS_L3_STR = "'Consul' Achievement for contributing " + FORUMPOSTS_L3 + " Forum posts.";

    /**
     * Achievement Points for reaching Level 3 for FORUM Contributions achievement.
     */
    int FORUMPOSTS_L3_AP = 0;

    /**
     * Required number for FORUM Contributions achievement to reach level 3.
     */
    int FORUMPOSTS_L4 = 600;

    /**
     * Message for reaching Level 3 for FORUM Contributions achievement.
     */
    String FORUMPOSTS_L4_STR = "'Minister' Achievement for contributing " + FORUMPOSTS_L4 + " Forum posts.";

    /**
     * Achievement Points for reaching Level 3 for FORUM Contributions achievement.
     */
    int FORUMPOSTS_L4_AP = 0;

    int FORUMPOSTS_L_MIN = LEVEL_1;
    int FORUMPOSTS_L_MAX = LEVEL_4;

    int[] FORUMPOSTS_L = {0, FORUMPOSTS_L1, FORUMPOSTS_L2, FORUMPOSTS_L3, FORUMPOSTS_L4};
    int[] FORUMPOSTS_AP = {0, FORUMPOSTS_L1_AP, FORUMPOSTS_L2_AP, FORUMPOSTS_L3_AP, FORUMPOSTS_L4_AP};
    String[] FORUMPOSTS_STR = {"", FORUMPOSTS_L1_STR, FORUMPOSTS_L2_STR, FORUMPOSTS_L3_STR, FORUMPOSTS_L4_STR};
    String[] FORUMPOSTS_TITLE = {"", "Writter", "Agent", "Consul", "Minister"};

    String FORUMPOSTS_NAME = "Forum Postings";

    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Killing Enemy Troops Contributions achievement.
     */
    int TROOPKILLS = 24;

    /**
     * Required number for Killing Enemy Troops Contributions achievement to reach level 1.
     */
    int TROOPKILLS_L1 = 500000;

    /**
     * Message for reaching Level 1 for Killing Enemy Troops Contributions achievement.
     */
    String TROOPKILLS_L1_STR = "'Fearsome' Achievement for killing 500,000 enemy troops.";

    /**
     * Achievement Points for reaching Level 1 for Killing Enemy Troops Contributions achievement.
     */
    int TROOPKILLS_L1_AP = 3;

    /**
     * Required number for Killing Enemy Troops Contributions achievement to reach level 2.
     */
    int TROOPKILLS_L2 = 1500000;

    /**
     * Message for reaching Level 2 for Killing Enemy Troops Contributions achievement.
     */
    String TROOPKILLS_L2_STR = "'Notorious' Achievement for killing 1,500,000 enemy troops.";

    /**
     * Achievement Points for reaching Level 2 for Killing Enemy Troops Contributions achievement.
     */
    int TROOPKILLS_L2_AP = 7;

    /**
     * Required number for Killing Enemy Troops Contributions achievement to reach level 3.
     */
    int TROOPKILLS_L3 = 5000000;

    /**
     * Message for reaching Level 3 for Killing Enemy Troops Contributions achievement.
     */
    String TROOPKILLS_L3_STR = "'Anihilator' Achievement for killing 5,000,000 enemy troops.";

    /**
     * Achievement Points for reaching Level 3 for Killing Enemy Troops Contributions achievement.
     */
    int TROOPKILLS_L3_AP = 15;

    /**
     * Required number for Killing Enemy Troops Contributions achievement to reach level 4.
     */
    int TROOPKILLS_L4 = 10000000;

    /**
     * Message for reaching Level 4 for Killing Enemy Troops Contributions achievement.
     */
    String TROOPKILLS_L4_STR = "'Genocider' Achievement for killing 10,000,000 enemy troops.";

    /**
     * Achievement Points for reaching Level 4 for Killing Enemy Troops Contributions achievement.
     */
    int TROOPKILLS_L4_AP = 30;

    int TROOPKILLS_L_MIN = LEVEL_1;
    int TROOPKILLS_L_MAX = LEVEL_4;

    int[] TROOPKILLS_L = {0, TROOPKILLS_L1, TROOPKILLS_L2, TROOPKILLS_L3, TROOPKILLS_L4};
    int[] TROOPKILLS_AP = {0, TROOPKILLS_L1_AP, TROOPKILLS_L2_AP, TROOPKILLS_L3_AP, TROOPKILLS_L4_AP};
    String[] TROOPKILLS_STR = {"", TROOPKILLS_L1_STR, TROOPKILLS_L2_STR, TROOPKILLS_L3_STR, TROOPKILLS_L4_STR};
    String[] TROOPKILLS_TITLE = {"", "Fearsome", "Notorious", "Anihilator", "Genocider"};

    String TROOPKILLS_NAME = "Enemy Troops Killed";


    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for Beta-tester Contributions achievement.
     */
    int SPECIAL = 1001;

    /**
     * Required number for  Beta-tester Contributions achievement to reach level 1.
     */
    int SPECIAL_L1 = 1;

    /**
     * Message for reaching Level 1 for  Beta-tester Contributions achievement.
     */
    String SPECIAL_L1_STR = "'Beta Tester' Achievement for actively participate in the beta test.";

    /**
     * Achievement Points for reaching Level 2 for Credits Contributions achievement.
     */
    int SPECIAL_L1_AP = 3;

    /**
     * Required number for Fund-raiser Contributions achievement to reach level 1.
     */
    int SPECIAL_L2 = 1;

    /**
     * Message for reaching Level 1 for Fund-raiser Contributions achievement.
     */
    String SPECIAL_L2_STR = "'Fund-Raiser' Achievement for supporting us in Indiegogo with $25 or more.";

    /**
     * Achievement Points for reaching Level 2 for Credits Contributions achievement.
     */
    int SPECIAL_L2_AP = 3;

    /**
     * Required number for Credits Contributions achievement to reach level 1.
     */
    int SPECIAL_L3 = 500;

    /**
     * Message for reaching Level 1 for Credits Contributions achievement.
     */
    String SPECIAL_L3_STR = "'EaW 1805 Supporter' Achievement for buying 500 or more EaW Credits.";

    /**
     * Achievement Points for reaching Level 2 for Credits Contributions achievement.
     */
    int SPECIAL_L3_AP = 5;

    /**
     * Required number for Credits Contributions achievement to reach level 2.
     */
    int SPECIAL_L4 = 2000;

    /**
     * Message for reaching Level 2 for Newsletter Contributions achievement.
     */
    String SPECIAL_L4_STR = "'EaW 1805 Sponsor' Achievement for buying 2000 or more EaW Credits.";

    /**
     * Achievement Points for reaching Level 2 for Newsletter Contributions achievement.
     */
    int SPECIAL_L4_AP = 15;

    int SPECIAL_L_MIN = LEVEL_1;
    int SPECIAL_L_MAX = LEVEL_4;

    int[] SPECIAL_ID = {0, LEVEL_1, LEVEL_2, LEVEL_3, LEVEL_4};
    int[] SPECIAL_L = {0, SPECIAL_L1, SPECIAL_L2, SPECIAL_L3, SPECIAL_L4};
    int[] SPECIAL_AP = {0, SPECIAL_L1_AP, SPECIAL_L2_AP, SPECIAL_L3_AP, SPECIAL_L4_AP};
    String[] SPECIAL_STR = {"", SPECIAL_L1_STR, SPECIAL_L2_STR, SPECIAL_L3_STR, SPECIAL_L4_STR};
    String[] SPECIAL_TITLE = {"", "Beta Tester", "Fund-Raiser", "EaW 1805 Supporter", "EaW 1805 Sponsor"};

    String SPECIAL_NAME = "Special Awards";


    /***********************************************************************************/
    /***********************************************************************************/

    /**
     * Constant for VPs of dropping position.
     */
    int DROP_POSITION = -30;

    /**
     * Constant for VPs of pickup position.
     */
    int PICKUP_POSITION = 20;

    /**
     * Constant for VPs of pickup an inactive position.
     */
    int PICKUP_INACTIVE_POSITION = 30;

    /**
     * Constant for description of dropping position.
     */
    String DESC_DROP_POSITION = "Drop a position";

    /**
     * Constant for description of pickup position.
     */
    String DESC_PICKUP_POSITION = "Join a new Game";

    /**
     * Constant for description of pickup an inactive position.
     */
    String DESC_PICKUP_INACTIVE_POSITION = "Pick up an inactive position";


    /***********************************************************************************/
    /**
     * *******************************************************************************
     */

    int[] ACHIEVEMENT_ID = {
            TACTICAL,
            NAVAL,
            COMKILL,
            ALLIANCE,
            WAR,
            SURRENDERS,
            CALLACCEPT,
            CALLREJECT,
            BUILDHUGE,
            CONQUERHUGE,
            CONQUERCAPITALS,
            SETUPCOLONIES,
            TROOPKILLS,
            ENEMYSINKS,
            ENEMYMERCHANTS,
            NEWSLETTERPOSTS,
            FORUMPOSTS
    };

    int[] ACHIEVEMENT_LMAX = {
            TACTICAL_L_MAX,
            NAVAL_L_MAX,
            COMKILL_L_MAX,
            ALLIANCE_L_MAX,
            WAR_L_MAX,
            SURRENDERS_L_MAX,
            CALLACCEPT_L_MAX,
            CALLREJECT_L_MAX,
            BUILDHUGE_L_MAX,
            CONQUERHUGE_L_MAX,
            CONQUERCAPITALS_L_MAX,
            SETUPCOLONIES_L_MAX,
            TROOPKILLS_L_MAX,
            ENEMYSINKS_L_MAX,
            ENEMYMERCHANTS_L_MAX,
            NEWSLETTERPOSTS_L_MAX,
            FORUMPOSTS_L_MAX
    };

    String[] ACHIEVEMENT_NAMES = {
            TACTICAL_NAME,
            NAVAL_NAME,
            COMKILL_NAME,
            ALLIANCE_NAME,
            WAR_NAME,
            SURRENDERS_NAME,
            CALLACCEPT_NAME,
            CALLREJECT_NAME,
            BUILDHUGE_NAME,
            CONQUERHUGE_NAME,
            CONQUERCAPITALS_NAME,
            SETUPCOLONIES_NAME,
            TROOPKILLS_NAME,
            ENEMYSINKS_NAME,
            ENEMYMERCHANTS_NAME,
            NEWSLETTERPOSTS_NAME,
            FORUMPOSTS_NAME
    };

    String[][] ACHIEVEMENT_STR = {
            TACTICAL_STR,
            NAVAL_STR,
            COMKILL_STR,
            ALLIANCE_STR,
            WAR_STR,
            SURRENDERS_STR,
            CALLACCEPT_STR,
            CALLREJECT_STR,
            BUILDHUGE_STR,
            CONQUERHUGE_STR,
            CONQUERCAPITALS_STR,
            SETUPCOLONIES_STR,
            TROOPKILLS_STR,
            ENEMYSINKS_STR,
            ENEMYMERCHANTS_STR,
            NEWSLETTERPOSTS_STR,
            FORUMPOSTS_STR
    };

    String[][] ACHIEVEMENT_TITLE = {
            TACTICAL_TITLE,
            NAVAL_TITLE,
            COMKILL_TITLE,
            ALLIANCE_TITLE,
            WAR_TITLE,
            SURRENDERS_TITLE,
            CALLACCEPT_TITLE,
            CALLREJECT_TITLE,
            BUILDHUGE_TITLE,
            CONQUERHUGE_TITLE,
            CONQUERCAPITALS_TITLE,
            SETUPCOLONIES_TITLE,
            TROOPKILLS_TITLE,
            ENEMYSINKS_TITLE,
            ENEMYMERCHANTS_TITLE,
            NEWSLETTERPOSTS_TITLE,
            FORUMPOSTS_TITLE
    };

    /***********************************************************************************/
    /**
     * *******************************************************************************
     */

    int[] ACHIEVEMENT_FULL_ID = {
            PLAYNATION,
            WINNATION
    };

    int[] ACHIEVEMENT_FULL_LMAX = {
            NationConstants.NATION_LAST,
            NationConstants.NATION_LAST
    };

    String[] ACHIEVEMENT_FULL_NAMES = {
            PLAYNATION_NAME,
            WINNATION_NAME
    };

    String[][] ACHIEVEMENT_FULL_STR = {
            PLAYNATION_STR,
            WINNATION_STR
    };


}
