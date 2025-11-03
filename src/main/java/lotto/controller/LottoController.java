package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void run() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> lottos = LottoMachine.createLottos(purchaseAmount);
        OutputView.printLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        LottoResultCalculator calculator = new LottoResultCalculator(winningNumbers, bonusNumber);
        Map<String, Integer> result = calculator.calculate(lottos);

        ProfitCalculator profitCalculator = new ProfitCalculator(purchaseAmount, result);
        double rate = profitCalculator.calculateRate();

        OutputView.printResult(result, rate);
    }
}
