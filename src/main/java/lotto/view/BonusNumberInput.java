package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import java.util.List;

public class BonusNumberInput {

    public static int input(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        BonusNumber bonusNumber = new BonusNumber(input, winningNumbers);
        return bonusNumber.getValue();
    }
}
