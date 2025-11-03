package lotto.model;

import java.util.List;
import static lotto.model.LottoConstants.*;

public class BonusNumber {
    private final int value;

    public BonusNumber(int number, List<Integer> winningNumbers) {
        validate(number, winningNumbers);
        this.value = number;
    }

    private void validate(int number, List<Integer> winningNumbers) {
        validateRange(number);
        validateDuplication(number, winningNumbers);
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplication(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}