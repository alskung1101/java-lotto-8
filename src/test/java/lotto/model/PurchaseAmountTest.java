package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void purchaseAmountNotThousandUnit_ThrowsException() {
        // Controller에서 파싱된 int 값을 Model로 전달하여 검증합니다.
        assertThatThrownBy(() -> new PurchaseAmount(1400))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1,000원 단위로 입력해야 합니다.");
    }

    @DisplayName("구입 금액이 0원 이하이면 예외가 발생한다.")
    @Test
    void purchaseAmountZeroOrLess_ThrowsException() {
        // Model에 0원 이하 검증 로직이 있다고 가정하고 테스트합니다.
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 0보다 커야 합니다.");
    }

    @DisplayName("유효한 구입 금액은 정상적으로 생성된다.")
    @Test
    void validPurchaseAmount_CreatesSuccessfully() {
        PurchaseAmount amount = new PurchaseAmount(8000);
        assertThat(amount.getValue()).isEqualTo(8000);
    }
}