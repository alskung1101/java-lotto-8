package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.LottoConstants.*;

public class LottoMachine {

    public static List<Lotto> createLottos(int purchaseAmount) {
        int count = purchaseAmount / PRICE_PER_TICKET;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
                    .stream().sorted().collect(Collectors.toList());
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
