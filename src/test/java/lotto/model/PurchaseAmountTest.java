package lotto.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PurchaseAmountTest {

    @Test
    void 유효한_금액은_정상_생성된다() {
        PurchaseAmount amount = new PurchaseAmount("8000");
        assertThat(amount.getValue()).isEqualTo(8000);
    }

    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("8500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 숫자가_아닌_입력이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
