package ca.sheridancollege.lenguyen.diceapp.beans;

import java.util.Collections;
import java.util.List;

public class DiceRollData {
    private final List<Integer> values;

    public List<Integer> getValues() {
        return values;
    }

    public int getNumberOfDice(){
        return values.size();
    }

    private final int total;

    public int getTotal() {
        return total;
    }

    public DiceRollData(List<Integer> values) {
        this.values = Collections.unmodifiableList(values);
        int sum = 0;
        for(int value: values){
            sum += value;
        }
        total = sum;
    }

    @Override
    public String toString(){
        return String.format("RollData{values = %s, total = %d, numberOfDice = %d}", values, total, this.getNumberOfDice());
    }
}
