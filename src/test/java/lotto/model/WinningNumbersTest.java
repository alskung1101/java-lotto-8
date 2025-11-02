package lotto.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {

    @Test
    void 유효한_입력은_정상적으로_파싱된다() {
        WinningNumbers numbers = new WinningNumbers("1,2,3,4,5,6");
        assertThat(numbers.getNumbers()).containsExactly(1,2,3,4,5,6);
    }

    @Test
    void 숫자가_아닌_입력은_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,a,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 중복된_번호가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 범위를_벗어난_번호가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
