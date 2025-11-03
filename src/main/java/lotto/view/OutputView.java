package lotto.view;

import lotto.model.Lotto;
import java.util.List;
import java.util.Map;

public class OutputView {

    // 구매한 로또 출력
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 결과 및 수익률 출력
    public static void printResult(Map<String, Integer> result, double rate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault("5등", 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault("4등", 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault("3등", 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault("2등", 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault("1등", 0) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }
}
