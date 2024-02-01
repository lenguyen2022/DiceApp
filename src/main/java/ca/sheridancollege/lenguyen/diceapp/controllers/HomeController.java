package ca.sheridancollege.lenguyen.diceapp.controllers;

import ca.sheridancollege.lenguyen.diceapp.beans.DiceRollData;
import ca.sheridancollege.lenguyen.diceapp.services.DiceRollerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    DiceRollerService diceRollerService;
    DiceRollData diceRollData;
    @GetMapping(value ={ "/", "/dice-game"})
    public String index(Model model){
        diceRollData = diceRollerService.getRollData(3);
        model.addAttribute("diceRollDataList", diceRollData.getValues());
        model.addAttribute("total", diceRollData.getTotal());
        model.addAttribute("selectedDice", 3);
        System.out.println(diceRollData);
        return "Game";
    }
    @PostMapping("/dice-game")
    public String diceGame(Model model, @RequestParam int numberOfDice, @RequestParam boolean isRolled){
        diceRollData =  diceRollerService.getRollData(numberOfDice);
        model.addAttribute("diceRollDataList", diceRollData.getValues());
        model.addAttribute("total", diceRollData.getTotal());
        model.addAttribute("selectedDice", numberOfDice);
        //return "Game";
        return "Game";
    }
}
