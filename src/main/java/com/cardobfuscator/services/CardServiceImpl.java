package com.cardobfuscator.services;

import com.cardobfuscator.model.Card;
import com.cardobfuscator.utils.CsvUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by parisfreire on 25/04/2019.
 */
@Service
public class CardServiceImpl implements CardService {

    /**
     * Incremental list to keep track of every card added on this singleton service on each session.
     */
    private List<Card> cards = new ArrayList<>();


    @Override
    public List<Card> getOrderedCards() {
        this.orderCardsByExpiryDateDesc();
        return cards;
    }

    /**
     * Iterate the cards of a list provided, obfuscate each one and stores it into service's incremental list.
     */
    @Override
    public void addCards(List<Card> cardList) {
        cardList.forEach(card->cards.add(this.obfuscateCardNumber(card)));
    }

    /**
     * Modify service's incremental list ordering them by parsed expiryDate field.
     */
    @Override
    public void orderCardsByExpiryDateDesc() {
        cards.sort(Comparator.comparing(Card::getParsedExpiryDate).reversed());
    }

    /**
     * Obfuscate card numbers getting the first 4 numbers and replacing all the rest with *
     */
    @Override
    public Card obfuscateCardNumber(Card card) {
        String cardNo = card.getNumber();
        if(cardNo.indexOf("-") != -1){
            String first4No = cardNo.substring(0, cardNo.indexOf("-"));
            String restOfNo = cardNo.substring(cardNo.indexOf("-"), cardNo.length());
            String obfuscatedNo = first4No + restOfNo.replaceAll("[0-9]", "*");
            card.setNumber(obfuscatedNo);
        }
        return card;
    }

    /**
     * Method processing a single card, adding to incremental service's list and returning it ordered
     * @param card
     */
    public List<Card> processCard(Card card){
        List<Card> cardList = new ArrayList<>();
        cardList.add(card);

        return this.addListAndOrder(cardList);
    }
    /**
     * Method parsing CSV file through CsvUtils class, adding to incremental service's list and returning it ordered
     * @param file
     */
    public List<Card> processCsv(MultipartFile file){
        List<Card> cardList = new ArrayList<>();

        try {
            cardList = CsvUtils.read(Card.class, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.addListAndOrder(cardList);
    }

    /**
     * Method centralicing adding list to incremental service's list and sorting it.
     * @param cardList
     * @return
     */
    private List<Card> addListAndOrder(List<Card> cardList){
        this.addCards(cardList);

        return this.getOrderedCards();
    }
}
