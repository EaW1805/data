package com.eaw1805.data.constants;

/**
 * Defines the forum permission roles.
 */
public interface ForumRoleConstants {

    int ROLE_ADMIN_STANDARD = 1;

    int ROLE_ADMIN_FORUM = 2;

    int ROLE_ADMIN_USERGROUP = 3;

    int ROLE_ADMIN_FULL = 4;

    int ROLE_USER_FULL = 5;

    int ROLE_USER_STANDARD = 6;

    int ROLE_USER_LIMITED = 7;

    int ROLE_USER_NOPM = 8;

    int ROLE_USER_NOAVATAR = 9;

    int ROLE_MOD_FULL = 10;

    int ROLE_MOD_STANDARD = 11;

    int ROLE_MOD_SIMPLE = 12;

    int ROLE_MOD_QUEUE = 13;

    int ROLE_FORUM_FULL = 14;

    int ROLE_FORUM_STANDARD = 15;

    int ROLE_FORUM_NOACCESS = 16;

    /**
     * This role will be assigned to users who dropped their position.
     */
    int ROLE_FORUM_READONLY = 17;

    int ROLE_FORUM_LIMITED = 18;

    int ROLE_FORUM_BOT = 19;

    int ROLE_FORUM_ONQUEUE = 20;

    int ROLE_FORUM_POLLS = 21;

    /**
     * This role will be assigned to users who pick up a new position.
     */
    int ROLE_FORUM_LIMITED_POLLS = 22;

    int ROLE_USER_NEW_MEMBER = 23;

    int ROLE_FORUM_NEW_MEMBER = 24;
}
