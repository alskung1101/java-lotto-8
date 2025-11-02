package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResultCalculator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<String, Integer> calculate(List<Lotto> myLottos) {
        Map<String, Integer> result = new HashMap<>();

        for (Lotto lotto : myLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();

            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            WinningResult wr = new WinningResult(matchCount, hasBonus);

            result.put(wr.getRank(), result.getOrDefault(wr.getRank(), 0) + 1);
        }
        return result;
    }
}
