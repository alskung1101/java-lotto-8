package lotto.model;

import java.util.Map;

public class ProfitCalculator {

    public static double calculateRate(Map<Rank, Integer> result, int purchaseAmount) {
        int totalPrize = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double rate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(rate * 10) / 10.0;
    }
}
