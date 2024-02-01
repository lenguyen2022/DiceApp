package ca.sheridancollege.lenguyen.diceapp.services;

import ca.sheridancollege.lenguyen.diceapp.beans.DiceRollData;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CookieDataServiceImpl implements CookieDataService{
    @Override
    public String encodeRollData(DiceRollData rollData) {
        return rollData.getValues().stream()
                .map(Object::toString)
                .collect(Collectors.joining("+"));
    }

    @Override
    public DiceRollData decodeRollData(String cookieValue) {
        List<Integer> values = Arrays.stream(cookieValue.split("\\+"))
                .map(Integer::parseInt)
                .toList();
        return new DiceRollData(values);
    }

}
