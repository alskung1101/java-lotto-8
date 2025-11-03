package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    @Test
    void 수익률을_정상적으로_계산한다() {
        Map<Rank, Integer> result = Map.of(
                Rank.FIFTH, 1,  // 5천원
                Rank.FOURTH, 1  // 5만원
        );
        double rate = ProfitCalculator.calculateRate(result, 5000);
        assertThat(rate).isEqualTo(1100.0);
    }

    @Test
    void 당첨없을때_수익률은_0이다() {
        Map<Rank, Integer> result = Map.of();
        double rate = ProfitCalculator.calculateRate(result, 10000);
        assertThat(rate).isEqualTo(0.0);
    }
}
