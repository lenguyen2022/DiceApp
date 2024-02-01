package ca.sheridancollege.lenguyen.diceapp.beans;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Dice implements Rollable {

    public static final int INIT_VALUE = 1;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 6;
    private final Random random;

    private int value;

    public int getValue() {
        return value;
    }

    public static int getMaxValue(){
        return MAX_VALUE;
    }

    public final void setValue(int value) {
        if (value >= MIN_VALUE && value <= MAX_VALUE) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Illegal dice value " + value);
        }
    }

    public Dice(int value, Random random){
        this.random = random;
        setValue(value);
    }


    public Dice(int value) {
        this(value, new Random());
    }


    public Dice() {
        this(INIT_VALUE);
    }

    public void reset() {
        value = INIT_VALUE;
    }

    @Override
    public int roll() {
        value = random.nextInt(MIN_VALUE, MAX_VALUE + 1);
        return value;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "value = " + value +
                '}';
    }
}
