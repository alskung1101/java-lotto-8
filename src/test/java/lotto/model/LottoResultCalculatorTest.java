package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {

    @Test
    void 로또_당첨_결과를_정상적으로_계산한다() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)), // 6개 일치
                new Lotto(List.of(1,2,3,4,5,7)), // 5개+보너스
                new Lotto(List.of(1,2,3,4,5,8))  // 5개
        );

        List<Integer> winning = List.of(1,2,3,4,5,6);
        int bonus = 7;

        Map<Rank, Integer> result = LottoResultCalculator.calculate(lottos, winning, bonus);

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(1);
    }
}
