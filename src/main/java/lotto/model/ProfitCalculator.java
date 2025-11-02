package lotto.model;

import java.util.Map;

public class ProfitCalculator {
    private final int purchaseAmount;
    private final Map<String, Integer> result;

    public ProfitCalculator(int purchaseAmount, Map<String, Integer> result) {
        this.purchaseAmount = purchaseAmount;
        this.result = result;
    }

    public double calculateRate() {
        int totalPrize = result.entrySet().stream()
                .mapToInt(e -> getPrizeByRank(e.getKey()) * e.getValue())
                .sum();

        double rate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(rate * 100.0) / 100.0;
    }

    private int getPrizeByRank(String rank) {
        return switch (rank) {
            case "1등" -> 2_000_000_000;
            case "2등" -> 30_000_000;
            case "3등" -> 1_500_000;
            case "4등" -> 50_000;
            case "5등" -> 5_000;
            default -> 0;
        };
    }
}
