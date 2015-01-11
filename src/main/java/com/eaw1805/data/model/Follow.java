package com.eaw1805.data.model;

import java.io.Serializable;

/**
 * Captures a leader-follower relation.
 */
public class Follow implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int followId;
    private User leader;
    private User follower;

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(final int value) {
        followId = value;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(final User value) {
        leader = value;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(final User value) {
        follower = value;
    }
}
