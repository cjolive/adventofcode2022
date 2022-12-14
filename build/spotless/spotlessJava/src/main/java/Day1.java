import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 extends Day {

    @Override
    public long task1() {
        List<String> numbers = puzzleInputStream().collect(Collectors.toList());

        int max = 0;
        int currentSum = 0;
        for (String number : numbers) {
            if (number.isBlank()) {
                if (currentSum > max) max = currentSum;
                currentSum = 0;
            } else {
                currentSum += Integer.parseInt(number);
            }
        }
        return max;
    }

    @Override
    public long task2() {
        List<Integer> elvesCalories = new ArrayList<>();
        List<String> numbers = puzzleInputStream().collect(Collectors.toList());

        int currentSum = 0;
        for (String number : numbers) {
            if (number.isBlank()) {
                elvesCalories.add(currentSum);
                currentSum = 0;
            } else {
                currentSum += Integer.parseInt(number);
            }
        }

        Collections.sort(elvesCalories, Comparator.reverseOrder());

        return elvesCalories.get(0) + elvesCalories.get(1) + elvesCalories.get(2);
    }
}
