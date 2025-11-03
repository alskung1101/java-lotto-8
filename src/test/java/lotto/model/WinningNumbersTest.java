package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    @Test
    void 당첨번호가_6개가_아니면_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }

    @Test
    void 중복된_번호가_있으면_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    void 정상입력시_번호리스트반환() {
        WinningNumbers wn = new WinningNumbers("1,2,3,4,5,6");
        assertThat(wn.getNumbers()).containsExactly(1,2,3,4,5,6);
    }
}
