package com.cardobfuscator.model;

import com.cardobfuscator.utils.DateUtils;

import java.util.Date;

/**
 * Created by parisfreire on 25/04/2019.
 */
public class Card {

    /**
     * Card POJO to parse info from the form and CSV import.
     */

    private String bank;
    private String number;
    private String expiryDate;

    public Card() {
    }

    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Method using the DateUtils class to get formatted date.
     */
    public Date getParsedExpiryDate(){
        return DateUtils.parseDateFromString(expiryDate);
    }
}
