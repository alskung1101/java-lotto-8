package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    public static Map<Rank, Integer> calculate(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatch(winningNumbers);
            boolean hasBonus = lotto.contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, hasBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }
}
