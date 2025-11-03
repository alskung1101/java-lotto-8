package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readLine(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
