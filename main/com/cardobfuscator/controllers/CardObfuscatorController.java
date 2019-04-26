package com.cardobfuscator.controllers;

import com.cardobfuscator.model.Card;
import com.cardobfuscator.services.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by parisfreire on 25/04/2019.
 */

@Controller
public class CardObfuscatorController {

    /**
     * Spring anotation to inject card service implementation.
     */
    @Autowired
    CardServiceImpl cardService;

    /**
     * GET endpoint to display simple form to submit a card object.
     */

    @GetMapping("/uploadSimple")
    public String uploadSimpleForm(Model model) {
        model.addAttribute("card", new Card());
        return "uploadSimple";
    }

    /**
     * POST endpoint to retrieve info submitted on card form.
     */

    @PostMapping("/uploadSimple")
    public String uploadSimple(@ModelAttribute("card") Card card, Model model) {

        List<Card> cardList = cardService.processCard(card);

        model.addAttribute("cards", cardList);
        return "result";
    }

    /**
     * GET endpoint to display a form to import a CSV file with multiple cards info.
     */
    @GetMapping("/uploadMultipart")
    public String uploadMultipartForm() {
        return "uploadMultipart";
    }

    /**
     * POST endpoint to retrieve cards info submitted on CSV form.
     */
    @PostMapping(value = "/uploadMultipart", consumes = "multipart/form-data")
    public String uploadMultipart(@RequestParam("file") MultipartFile file, Model model) {
        List<Card> cardList = cardService.processCsv(file);
        model.addAttribute("cards", cardList);
        return "result";
    }
}
