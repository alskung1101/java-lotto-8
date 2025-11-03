package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class LottoController {

    public void run() {
        try {
            int purchaseAmount = askPurchaseAmount();
            List<Lotto> lottos = LottoMachine.createLottos(purchaseAmount);
            OutputView.printLottos(lottos);

            List<Integer> winningNumbers = askWinningNumbers();
            int bonusNumber = askBonusNumber(winningNumbers);

            Map<Rank, Integer> result = LottoResultCalculator.calculate(lottos, winningNumbers, bonusNumber);
            double rate = ProfitCalculator.calculateRate(result, purchaseAmount);

            OutputView.printResult(result, rate);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private int askPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.readLine("구입금액을 입력해 주세요.");
                int number = Integer.parseInt(input);
                return new PurchaseAmount(number).getValue();
            } catch (NumberFormatException e) {
                OutputView.printError("숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private List<Integer> askWinningNumbers() {
        while (true) {
            try {
                String input = InputView.readLine("당첨 번호를 입력해 주세요.");
                List<Integer> numbers = parseWinningNumbers(input);
                return new WinningNumbers(numbers).getNumbers();
            } catch (NumberFormatException e) {
                OutputView.printError("숫자를 쉼표(,)로 구분하여 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private int askBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = InputView.readLine("보너스 번호를 입력해 주세요.");
                int number = Integer.parseInt(input);
                return new BonusNumber(number, winningNumbers).getValue();
            } catch (NumberFormatException e) {
                OutputView.printError("숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}