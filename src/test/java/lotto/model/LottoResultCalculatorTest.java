package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {

    @DisplayName("로또 당첨 번호와 비교해 올바른 결과를 계산한다.")
    @Test
    void 당첨_결과_계산_테스트() {
        List<Lotto> myLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 7))  // 5개 + 보너스 7
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResultCalculator calculator = new LottoResultCalculator(winningNumbers, bonusNumber);
        Map<String, Integer> result = calculator.calculate(myLottos);

        assertThat(result.get("1등")).isEqualTo(1);
        assertThat(result.get("2등")).isEqualTo(1);
    }
}
