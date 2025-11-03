package lotto.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseAmountTest {

    @Test
    void 금액이_1000원단위가_아니면_예외발생() {
        assertThatThrownBy(() -> new PurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,000원 단위");
    }

    @Test
    void 금액이_정상입력일때_값_정상반환() {
        PurchaseAmount amount = new PurchaseAmount("5000");
        assertThat(amount.getValue()).isEqualTo(5000);
    }

    @Test
    void 숫자가_아닌_입력시_예외발생() {
        assertThatThrownBy(() -> new PurchaseAmount("일천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해야 합니다");
    }
}
