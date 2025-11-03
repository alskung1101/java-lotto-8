package lotto.model;

import java.util.Arrays;
import java.util.List;
import static lotto.model.LottoConstants.*;

public enum Rank {
    FIRST(6, false, PRIZE_FIRST, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, PRIZE_SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, PRIZE_THIRD, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, PRIZE_FOURTH, "4개 일치 (50,000원)"),
    FIFTH(3, false, PRIZE_FIFTH, "3개 일치 (5,000원)"),
    NONE(0, false, 0, "꽝");

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;
    private final String message;

    Rank(int matchCount, boolean hasBonus, int prize, String message) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.message = message;
    }

    public static Rank valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    public boolean isWinningRank() {
        return this != NONE;
    }

    public static List<Rank> getWinningRanksOrdered() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }
}