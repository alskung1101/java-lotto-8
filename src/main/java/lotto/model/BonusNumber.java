package lotto.model;

import java.util.List;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(String input, List<Integer> winningNumbers) {
        int value = parse(input);
        validate(value, winningNumbers);
        this.bonus = value;
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private void validate(int value, List<Integer> winningNumbers) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(value)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getValue() {
        return bonus;
    }
}
