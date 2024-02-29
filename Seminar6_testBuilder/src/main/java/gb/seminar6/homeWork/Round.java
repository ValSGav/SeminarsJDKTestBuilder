package gb.seminar6.homeWork;

import lombok.Getter;

import java.util.Random;

public class Round {
    private final Boolean[] doors;
    private static Random rnd;

    public Round() {
        this.doors = new Boolean[3];
        rnd = new Random();
    }

    public void setNewCombination() {
        for (int i = 0; i < 3; i++) {
            doors[i] = false;
        }
        int winDoor = rnd.nextInt(0, 3);
        doors[winDoor] = true;
    }

    /*
    Если человек меняет выбор,
    а ведущий исключает из игры один не выйгрышный вариант
    три ситуации: 1 и 2 - человек изначально выбирает неправильно
    и при смене выбора автоматом выигрывает, 3 - человек выбирает правильно
    и при смене выбора проигрывает.
    Если человек не меняет выбор, то единственный способ выйграть - угадать
    с первого раза.
    */
    public boolean getResultGame(boolean changingChoiceMan) {
        boolean firstChoice = doors[rnd.nextInt(0, 3)];
        if (changingChoiceMan)
            return !firstChoice;
        else
            return firstChoice;
    }

}
