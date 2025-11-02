package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int PRICE_PER_TICKET = 1000;

    public static List<Lotto> createLottos(int purchaseAmount) {
        int count = purchaseAmount / PRICE_PER_TICKET;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoGenerator.generate()));
        }
        return lottos;
    }
}
