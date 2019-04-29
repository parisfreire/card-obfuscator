package com.cardobfuscator.services;

import com.cardobfuscator.model.Card;

import java.util.List;

/**
 * Created by parisfreire on 25/04/2019.
 */
public interface CardService {

    /**
     * Public methods of CardService needed to implement on each implementation of the service.
     */

    List<Card> getOrderedCards();
    void addCards(List<Card> cardList);
    void orderCardsByExpiryDateDesc();
    Card obfuscateCardNumber(Card card);
}
