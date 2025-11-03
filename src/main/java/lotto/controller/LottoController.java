package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void run() {
        int purchaseAmount = askPurchaseAmount();
        List<Lotto> lottos = LottoMachine.createLottos(purchaseAmount);
        OutputView.printLottos(lottos);

        List<Integer> winningNumbers = askWinningNumbers();
        int bonusNumber = askBonusNumber(winningNumbers);

        Map<Rank, Integer> result = LottoResultCalculator.calculate(lottos, winningNumbers, bonusNumber);
        double rate = ProfitCalculator.calculateRate(result, purchaseAmount);

        OutputView.printResult(result, rate);
    }

    private int askPurchaseAmount() {
        while (true) {
            try {
                return new PurchaseAmount(InputView.readLine("구입금액을 입력해 주세요.")).getValue();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private List<Integer> askWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(InputView.readLine("당첨 번호를 입력해 주세요.")).getNumbers();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private int askBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return new BonusNumber(InputView.readLine("보너스 번호를 입력해 주세요."), winningNumbers).getValue();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
