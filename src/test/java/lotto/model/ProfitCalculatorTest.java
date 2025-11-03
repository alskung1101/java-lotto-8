package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    @DisplayName("수익률 계산이 정확히 수행된다.")
    @Test
    void 수익률_계산_테스트() {
        Map<String, Integer> result = Map.of(
                "1등", 1,
                "3등", 1,
                "5등", 1
        );

        ProfitCalculator calculator = new ProfitCalculator(3000, result);
        double rate = calculator.calculateRate();

        assertThat(rate).isGreaterThan(66_667_000.0);
    }
}
