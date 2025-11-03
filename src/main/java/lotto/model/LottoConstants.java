package lotto.model;

public final class LottoConstants {

    private LottoConstants() {}

    // 로또 번호 범위 및 개수
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    // 로또 가격
    public static final int PRICE_PER_TICKET = 1000;

    // 상금 (Rank Enum에서 PRIZE 상수를 사용하도록 정리)
    public static final int PRIZE_FIRST = 2_000_000_000;
    public static final int PRIZE_SECOND = 30_000_000;
    public static final int PRIZE_THIRD = 1_500_000;
    public static final int PRIZE_FOURTH = 50_000;
    public static final int PRIZE_FIFTH = 5_000;
}