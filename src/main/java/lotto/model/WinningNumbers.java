package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.LottoConstants.LOTTO_SIZE;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(String input) {
        List<Integer> parsed = parse(input);
        validate(parsed);
        this.numbers = parsed;
    }

    private List<Integer> parse(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
