package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.WinningNumbers;
import java.util.List;

public class WinningNumbersInput {

    public static List<Integer> input() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        WinningNumbers winningNumbers = new WinningNumbers(input);
        return winningNumbers.getNumbers();
    }
}
