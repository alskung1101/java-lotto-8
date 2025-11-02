package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.PurchaseAmount;

public class PurchaseInput {

    public static int input() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        PurchaseAmount amount = new PurchaseAmount(input);
        return amount.getValue();
    }
}
