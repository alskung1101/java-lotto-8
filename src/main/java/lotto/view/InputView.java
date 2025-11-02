package lotto.view;

import java.util.List;

public class InputView {

    public static int inputPurchaseAmount() {
        return PurchaseInput.input();
    }

    public static List<Integer> inputWinningNumbers() {
        return WinningNumbersInput.input();
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        return BonusNumberInput.input(winningNumbers);
    }
}
