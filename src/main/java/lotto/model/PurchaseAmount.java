package lotto.model;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(String input) {
        int value = parse(input);
        validate(value);
        this.amount = value;
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private void validate(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getValue() {
        return amount;
    }
}
