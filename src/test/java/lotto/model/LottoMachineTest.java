package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void 구입금액에_따라_로또가_올바른_개수만큼_생성된다() {
        int purchaseAmount = 5000;
        List<Lotto> lottos = LottoMachine.createLottos(purchaseAmount);

        assertThat(lottos).hasSize(5);
        lottos.forEach(lotto -> assertThat(lotto.getNumbers()).hasSize(6));
    }
}
