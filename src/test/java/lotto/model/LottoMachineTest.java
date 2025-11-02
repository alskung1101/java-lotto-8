package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("구입 금액에 따라 로또 개수가 올바르게 생성된다.")
    @Test
    void 로또_생성_개수_검증() {
        List<Lotto> lottos = LottoMachine.createLottos(3000);
        assertThat(lottos).hasSize(3);
    }

    @DisplayName("로또 번호는 1~45 사이의 숫자이며 중복이 없다.")
    @Test
    void 로또_번호_범위_및_중복_검증() {
        Lotto lotto = LottoMachine.createLottos(1000).get(0);
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(6);
        assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}
