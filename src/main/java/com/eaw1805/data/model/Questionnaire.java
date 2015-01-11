package com.eaw1805.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

//Dear xxxx,
//
//As an continuous effort to improve our game, we would really appreciate your feedback! We noticed that you have not logged in for a while - what is the main reason you are discontinuing? (you may choose more than one reason)
//
//O  The game does not work on my browser
//O  The User Interface is slow or difficult to understand
//O  I have problems finding my way around the website
//O  The rules of the game are too complex for me
//O  I don't have the time needed to learn the game
//O  The atmosphere & graphics do not appeal to me
//O  I dont want to Pay for the game
//O  Customer Service is slow/insufficient
//O  The Tutorial game was not enough to help me learn the game
//O  Other (please specify) _______________________
//
//Thank you in advance for your feedback!
//
//Kind Regards,
//Oplon Games
@Entity
@Table(name = "QUESTIONNAIRE")
public class Questionnaire {

    /**
     * Entity id.
     */
    private int questionnaireId;

    /**
     * The user that this questionnaire was submitted from.
     */
    private User user;

    /**
     * The game does not work on my browser
     */
    private boolean myBrowser;

    /**
     * The User Interface is slow or difficult to understand
     */
    private boolean slowUI;

    /**
     * The gui is difficult to use.
     */
    private boolean difficultUI;

    /**
     * I have problems finding my way around the website
     */
    private boolean website;

    /**
     * The rules of the game are too complex for me
     */
    private boolean rules;

    /**
     * I don't have the time needed to learn the game
     */
    private boolean noTime;

    /**
     * The atmosphere & graphics do not appeal to me
     */
    private boolean graphics;

    /**
     * I dont want to Pay for the game
     */
    private boolean payment;

    /**
     * Customer Service is slow/insufficient
     */
    private boolean customerService;

    /**
     * The Tutorial game was not enough to help me learn the game
     */
    private boolean tutorial;

    /**
     * Other (please specify) _______________________
     */
    private String comments;

    /**
     * The date the questionnaire was submitted.
     */
    private Date submitDate;

    /**
     * If user uses chrome browser.
     */
    private boolean browserChrome;

    /**
     * If user uses firefox browser.
     */
    private boolean browserFirefox;

    /**
     * If user uses IE browser.
     */
    private boolean browserIE;

    /**
     * If user uses opera browser.
     */
    private boolean browserOpera;

    /**
     * If user uses netscape browser.
     */
    private boolean browserNetscape;

    /**
     * If user uses other browser.
     */
    private boolean browserOther;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONNAIRE_ID", unique = true, nullable = false)
    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column
    public boolean isMyBrowser() {
        return myBrowser;
    }

    public void setMyBrowser(boolean myBrowser) {
        this.myBrowser = myBrowser;
    }

    @Column
    public boolean isSlowUI() {
        return slowUI;
    }

    public void setSlowUI(boolean slowUI) {
        this.slowUI = slowUI;
    }

    @Column
    public boolean isDifficultUI() {
        return difficultUI;
    }

    public void setDifficultUI(boolean difficultUI) {
        this.difficultUI = difficultUI;
    }

    @Column
    public boolean isWebsite() {
        return website;
    }

    public void setWebsite(boolean website) {
        this.website = website;
    }

    @Column
    public boolean isRules() {
        return rules;
    }

    public void setRules(boolean rules) {
        this.rules = rules;
    }

    @Column
    public boolean isNoTime() {
        return noTime;
    }

    public void setNoTime(boolean noTime) {
        this.noTime = noTime;
    }

    @Column
    public boolean isGraphics() {
        return graphics;
    }

    public void setGraphics(boolean graphics) {
        this.graphics = graphics;
    }

    @Column
    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    @Column
    public boolean isCustomerService() {
        return customerService;
    }

    public void setCustomerService(boolean customerService) {
        this.customerService = customerService;
    }

    @Column
    public boolean isTutorial() {
        return tutorial;
    }

    public void setTutorial(boolean tutorial) {
        this.tutorial = tutorial;
    }

    @Column(name="comments", columnDefinition="text")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    @Column
    public boolean isBrowserChrome() {
        return browserChrome;
    }

    public void setBrowserChrome(boolean browserChrome) {
        this.browserChrome = browserChrome;
    }

    @Column
    public boolean isBrowserFirefox() {
        return browserFirefox;
    }

    public void setBrowserFirefox(boolean browserFirefox) {
        this.browserFirefox = browserFirefox;
    }

    @Column
    public boolean isBrowserIE() {
        return browserIE;
    }

    public void setBrowserIE(boolean browserIE) {
        this.browserIE = browserIE;
    }

    @Column
    public boolean isBrowserOpera() {
        return browserOpera;
    }

    public void setBrowserOpera(boolean browserOpera) {
        this.browserOpera = browserOpera;
    }

    @Column
    public boolean isBrowserNetscape() {
        return browserNetscape;
    }

    public void setBrowserNetscape(boolean browserNetscape) {
        this.browserNetscape = browserNetscape;
    }

    @Column
    public boolean isBrowserOther() {
        return browserOther;
    }

    public void setBrowserOther(boolean browserOther) {
        this.browserOther = browserOther;
    }
}
