package gb.seminar6.homeWork;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Game {
    public static void main(String[] args) {
        int countOfGames = 10000;
        DescriptiveStatistics statisticsOfGamesWithChangeChoice =
                new DescriptiveStatistics();
        DescriptiveStatistics statisticsOfGamesWithNoChangeChoice = new DescriptiveStatistics();

        Round round = new Round();

        for (int i = 0; i < countOfGames; i++) {
            round.setNewCombination();
            statisticsOfGamesWithChangeChoice
                    .addValue(round.getResultGame(true) ? 1 : 0);
            statisticsOfGamesWithNoChangeChoice
                    .addValue(round.getResultGame(false) ? 1 : 0);
        }

        System.out.printf("Побед людей, которые меняли выбор: %f", statisticsOfGamesWithChangeChoice.getSum());
        System.out.println();
        System.out.printf("Побед людей, которые не меняли выбор %f: ", statisticsOfGamesWithNoChangeChoice.getSum());

    }
}
