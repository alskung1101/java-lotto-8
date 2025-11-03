package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @DisplayName("6개 일치 시 1등 반환")
    @Test
    void 일등_결과_테스트() {
        WinningResult result = new WinningResult(6, false);
        assertThat(result.getRank()).isEqualTo("1등");
        assertThat(result.getPrize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("5개 일치 + 보너스 일치 시 2등 반환")
    @Test
    void 이등_결과_테스트() {
        WinningResult result = new WinningResult(5, true);
        assertThat(result.getRank()).isEqualTo("2등");
        assertThat(result.getPrize()).isEqualTo(30_000_000);
    }

    @DisplayName("3개 일치 시 5등 반환")
    @Test
    void 오등_결과_테스트() {
        WinningResult result = new WinningResult(3, false);
        assertThat(result.getRank()).isEqualTo("5등");
        assertThat(result.getPrize()).isEqualTo(5_000);
    }
}
