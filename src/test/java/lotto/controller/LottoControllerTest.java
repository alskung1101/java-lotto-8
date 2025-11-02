package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    @DisplayName("로또 구매 금액을 받아 로또를 생성하고 반환한다.")
    @Test
    void 로또_구매_흐름_정상작동() {
        int purchaseAmount = 5000;
        List<Lotto> lottos = LottoMachine.createLottos(purchaseAmount);

        assertThat(lottos).hasSize(5);
        assertThat(lottos.get(0).getNumbers()).hasSize(6);
    }
}
