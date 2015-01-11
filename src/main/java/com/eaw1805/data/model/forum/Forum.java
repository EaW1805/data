package com.eaw1805.data.model.forum;

import java.io.Serializable;

/**
 * Object to represent a forum instance for forum.
 */
public class Forum implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    /**
     * The forum id.
     */
    private int forumId;

    /**
     * The forum parent id.
     */
    private int parentId;

    /**
     * todo:what is this?
     */
    private int leftId;

    /**
     * todo: what is this?
     */
    private int rightId;

    /**
     * todo: what is this?
     */
    private String forumParents;

    /**
     * The name for the forum.
     */
    private String forumName;

    /**
     * A description for the forum.
     */
    private String forumDesc;


    /**
     * todo: what is this?
     */
    private int forumDescBitfield;

    /**
     * Forum options?
     */
    private int forumDescOptions;

    /**
     * A uid for the forum?
     */
    private String forumDescUid;

    /**
     * The forum link.
     */
    private String forumLink;

    /**
     * The forum password.
     */
    private String forumPassword;

    /**
     * todo: what is this?
     */
    private int forumStyle;

    /**
     * The forum image.
     */
    private String forumImage;

    /**
     * The forum rules.
     */
    private String forumRules;

    /**
     * The link for the forum rules.
     */
    private String forumRulesLink;

    /**
     * todo: what is this?
     */
    private String forumRulesBitfield;

    /**
     * todo: what is this?
     */
    private int forumRulesOptions;

    /**
     * todo: what is this?
     */
    private String forumRulesUid;

    /**
     * Topics per page for the forum.
     */
    private int forumTopicsPerPage;

    /**
     * The type for the forum.
     */
    private int forumType;

    /**
     * The status of the forum.
     */
    private int forumStatus;

    /**
     * Number of posts for the forum?
     */
    private int forumPosts;

    /**
     * Number of topics for the forum?
     */
    private int forumTopics;

    /**
     * todo: what?
     */
    private int forumTopicsReal;

    /**
     * the last post id for the forum.
     */
    private int forumLastPostId;

    /**
     * The last posters id.
     */
    private int forumLastPosterId;

    /**
     * The last subject.
     */
    private String forumLastPostSubject;

    /**
     * the last post time?
     */
    private int forumLastPostTime;

    /**
     * Last posters name.
     */
    private String forumLastPosterName;

    /**
     * The last colour?
     */
    private String forumLastPosterColour;

    /**
     * Forum flags.
     */
    private int forumFlags;

    /**
     * Forum options.
     */
    private int forumOptions;

    /**
     * Display subforum list.
     */
    private boolean displaySubforumList;

    /**
     * Display on index.
     */
    private boolean displayOnIndex;

    /**
     * Enable indexing.
     */
    private boolean enableIndexing;

    /**
     * Enable icons.
     */
    private boolean enableIcons;

    /**
     * Enable prune.
     */
    private boolean enablePrune;

    /**
     * Prune next?
     */
    private int pruneNext;

    /**
     * Prune days.
     */
    private int pruneDays;

    /**
     * Prune viewed.
     */
    private int pruneViewed;

    /**
     * Prune frequency?
     */
    private int pruneFreq;

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getLeftId() {
        return leftId;
    }

    public void setLeftId(int leftId) {
        this.leftId = leftId;
    }

    public int getRightId() {
        return rightId;
    }

    public void setRightId(int rightId) {
        this.rightId = rightId;
    }

    public String getForumParents() {
        return forumParents;
    }

    public void setForumParents(String forumParents) {
        this.forumParents = forumParents;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getForumDesc() {
        return forumDesc;
    }

    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }

    public int getForumDescBitfield() {
        return forumDescBitfield;
    }

    public void setForumDescBitfield(int forumDescBitfield) {
        this.forumDescBitfield = forumDescBitfield;
    }

    public int getForumDescOptions() {
        return forumDescOptions;
    }

    public void setForumDescOptions(int forumDescOptions) {
        this.forumDescOptions = forumDescOptions;
    }

    public String getForumDescUid() {
        return forumDescUid;
    }

    public void setForumDescUid(String forumDescUid) {
        this.forumDescUid = forumDescUid;
    }

    public String getForumLink() {
        return forumLink;
    }

    public void setForumLink(String forumLink) {
        this.forumLink = forumLink;
    }

    public String getForumPassword() {
        return forumPassword;
    }

    public void setForumPassword(String forumPassword) {
        this.forumPassword = forumPassword;
    }

    public int getForumStyle() {
        return forumStyle;
    }

    public void setForumStyle(int forumStyle) {
        this.forumStyle = forumStyle;
    }

    public String getForumImage() {
        return forumImage;
    }

    public void setForumImage(String forumImage) {
        this.forumImage = forumImage;
    }

    public String getForumRules() {
        return forumRules;
    }

    public void setForumRules(String forumRules) {
        this.forumRules = forumRules;
    }

    public String getForumRulesLink() {
        return forumRulesLink;
    }

    public void setForumRulesLink(String forumRulesLink) {
        this.forumRulesLink = forumRulesLink;
    }

    public String getForumRulesBitfield() {
        return forumRulesBitfield;
    }

    public void setForumRulesBitfield(String forumRulesBitfield) {
        this.forumRulesBitfield = forumRulesBitfield;
    }

    public int getForumRulesOptions() {
        return forumRulesOptions;
    }

    public void setForumRulesOptions(int forumRulesOptions) {
        this.forumRulesOptions = forumRulesOptions;
    }

    public String getForumRulesUid() {
        return forumRulesUid;
    }

    public void setForumRulesUid(String forumRulesUid) {
        this.forumRulesUid = forumRulesUid;
    }

    public int getForumTopicsPerPage() {
        return forumTopicsPerPage;
    }

    public void setForumTopicsPerPage(int forumTopicsPerPage) {
        this.forumTopicsPerPage = forumTopicsPerPage;
    }

    public int getForumType() {
        return forumType;
    }

    public void setForumType(int forumType) {
        this.forumType = forumType;
    }

    public int getForumStatus() {
        return forumStatus;
    }

    public void setForumStatus(int forumStatus) {
        this.forumStatus = forumStatus;
    }

    public int getForumPosts() {
        return forumPosts;
    }

    public void setForumPosts(int forumPosts) {
        this.forumPosts = forumPosts;
    }

    public int getForumTopics() {
        return forumTopics;
    }

    public void setForumTopics(int forumTopics) {
        this.forumTopics = forumTopics;
    }

    public int getForumTopicsReal() {
        return forumTopicsReal;
    }

    public void setForumTopicsReal(int forumTopicsReal) {
        this.forumTopicsReal = forumTopicsReal;
    }

    public int getForumLastPostId() {
        return forumLastPostId;
    }

    public void setForumLastPostId(int forumLastPostId) {
        this.forumLastPostId = forumLastPostId;
    }

    public int getForumLastPosterId() {
        return forumLastPosterId;
    }

    public void setForumLastPosterId(int forumLastPosterId) {
        this.forumLastPosterId = forumLastPosterId;
    }

    public String getForumLastPostSubject() {
        return forumLastPostSubject;
    }

    public void setForumLastPostSubject(String forumLastPostSubject) {
        this.forumLastPostSubject = forumLastPostSubject;
    }

    public int getForumLastPostTime() {
        return forumLastPostTime;
    }

    public void setForumLastPostTime(int forumLastPostTime) {
        this.forumLastPostTime = forumLastPostTime;
    }

    public String getForumLastPosterName() {
        return forumLastPosterName;
    }

    public void setForumLastPosterName(String forumLastPosterName) {
        this.forumLastPosterName = forumLastPosterName;
    }

    public String getForumLastPosterColour() {
        return forumLastPosterColour;
    }

    public void setForumLastPosterColour(String forumLastPosterColour) {
        this.forumLastPosterColour = forumLastPosterColour;
    }

    public int getForumFlags() {
        return forumFlags;
    }

    public void setForumFlags(int forumFlags) {
        this.forumFlags = forumFlags;
    }

    public int getForumOptions() {
        return forumOptions;
    }

    public void setForumOptions(int forumOptions) {
        this.forumOptions = forumOptions;
    }

    public boolean isDisplaySubforumList() {
        return displaySubforumList;
    }

    public void setDisplaySubforumList(boolean displaySubforumList) {
        this.displaySubforumList = displaySubforumList;
    }

    public boolean isDisplayOnIndex() {
        return displayOnIndex;
    }

    public void setDisplayOnIndex(boolean displayOnIndex) {
        this.displayOnIndex = displayOnIndex;
    }

    public boolean isEnableIndexing() {
        return enableIndexing;
    }

    public void setEnableIndexing(boolean enableIndexing) {
        this.enableIndexing = enableIndexing;
    }

    public boolean isEnableIcons() {
        return enableIcons;
    }

    public void setEnableIcons(boolean enableIcons) {
        this.enableIcons = enableIcons;
    }

    public boolean isEnablePrune() {
        return enablePrune;
    }

    public void setEnablePrune(boolean enablePrune) {
        this.enablePrune = enablePrune;
    }

    public int getPruneNext() {
        return pruneNext;
    }

    public void setPruneNext(int pruneNext) {
        this.pruneNext = pruneNext;
    }

    public int getPruneDays() {
        return pruneDays;
    }

    public void setPruneDays(int pruneDays) {
        this.pruneDays = pruneDays;
    }

    public int getPruneViewed() {
        return pruneViewed;
    }

    public void setPruneViewed(int pruneViewed) {
        this.pruneViewed = pruneViewed;
    }

    public int getPruneFreq() {
        return pruneFreq;
    }

    public void setPruneFreq(int pruneFreq) {
        this.pruneFreq = pruneFreq;
    }
}
