package lotto.model;

public class WinningResult {
    private final int matchCount;
    private final boolean hasBonus;

    public WinningResult(int matchCount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public String getRank() {
        if (matchCount == 6) return "1등";
        if (matchCount == 5 && hasBonus) return "2등";
        if (matchCount == 5) return "3등";
        if (matchCount == 4) return "4등";
        if (matchCount == 3) return "5등";
        return "꽝";
    }

    public int getPrize() {
        return switch (getRank()) {
            case "1등" -> 2_000_000_000;
            case "2등" -> 30_000_000;
            case "3등" -> 1_500_000;
            case "4등" -> 50_000;
            case "5등" -> 5_000;
            default -> 0;
        };
    }
}
