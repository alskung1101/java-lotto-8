package lotto.model;

import static lotto.model.LottoConstants.PRICE_PER_TICKET;

public class PurchaseAmount {
    private final int value;

    public PurchaseAmount(int number) {
        validate(number);
        this.value = number;
    }

    private void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }

        if (number % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}