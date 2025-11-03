package lotto.model;

import static lotto.model.LottoConstants.PRICE_PER_TICKET;

public class PurchaseAmount {
    private final int value;

    public PurchaseAmount(String input) {
        int number = parse(input);
        validate(number);
        this.value = number;
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void validate(int number) {
        if (number % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
