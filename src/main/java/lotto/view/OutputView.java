package lotto.view;

import lotto.model.Lotto;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Map<String, Integer> result, double rate) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        result.forEach((rank, count) -> System.out.println(rank + " - " + count + "개"));
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
