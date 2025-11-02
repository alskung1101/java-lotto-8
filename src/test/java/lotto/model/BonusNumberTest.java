package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class BonusNumberTest {

    private final List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

    @Test
    void 유효한_보너스_번호는_정상적으로_생성된다() {
        BonusNumber bonus = new BonusNumber("7", winningNumbers);
        assertThat(bonus.getValue()).isEqualTo(7);
    }

    @Test
    void 숫자가_아닌_입력은_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("a", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("1", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 범위를_벗어난_번호는_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("50", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
