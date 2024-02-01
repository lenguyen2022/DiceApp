package ca.sheridancollege.lenguyen.diceapp.services;

import ca.sheridancollege.lenguyen.diceapp.beans.DiceRollData;

public interface CookieDataService {
    String encodeRollData(DiceRollData rollData);
    DiceRollData decodeRollData(String cookieValue);
}
