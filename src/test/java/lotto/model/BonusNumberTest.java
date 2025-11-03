package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void bonusNumberOutOfRange_ThrowsException() {
        assertThatThrownBy(() -> new BonusNumber(46, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new BonusNumber(0, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberDuplicateWithWinning_ThrowsException() {
        assertThatThrownBy(() -> new BonusNumber(5, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복될 수 없습니다.");
    }
}