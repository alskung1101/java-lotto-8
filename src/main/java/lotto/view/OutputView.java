package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Map<Rank, Integer> result, double rate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank.isWinningRank()) {
                System.out.println(rank.getMessage() + " - " + result.getOrDefault(rank, 0) + "개");
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
