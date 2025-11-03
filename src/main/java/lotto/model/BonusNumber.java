package lotto.model;

import java.util.List;

import static lotto.model.LottoConstants.*;

public class BonusNumber {
    private final int value;

    public BonusNumber(String input, List<Integer> winningNumbers) {
        int number = parse(input);
        validate(number, winningNumbers);
        this.value = number;
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void validate(int number, List<Integer> winningNumbers) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
