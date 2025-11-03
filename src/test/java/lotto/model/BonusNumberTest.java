package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberTest {

    @Test
    void 보너스번호가_범위밖이면_예외발생() {
        List<Integer> winning = List.of(1,2,3,4,5,6);
        assertThatThrownBy(() -> new BonusNumber("50", winning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45");
    }

    @Test
    void 보너스번호가_당첨번호와_중복이면_예외발생() {
        List<Integer> winning = List.of(1,2,3,4,5,6);
        assertThatThrownBy(() -> new BonusNumber("6", winning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    void 정상입력시_정상반환() {
        List<Integer> winning = List.of(1,2,3,4,5,6);
        BonusNumber bn = new BonusNumber("7", winning);
        assertThat(bn.getValue()).isEqualTo(7);
    }
}
