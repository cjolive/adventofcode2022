import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3 extends Day {
    @Override
    public long task1() {

        int prioritySum = 0;

        List<String> strings = puzzleInputStream().collect(Collectors.toList());
        for (String s : strings) {
            int split = s.length() / 2;

            Set<Character> chars1 =
                    s.substring(0, split).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

            Set<Character> chars2 = s.substring(split, s.length())
                    .chars()
                    .mapToObj(e -> (char) e)
                    .collect(Collectors.toSet());

            chars1.retainAll(chars2);

            char dupe = chars1.stream().findFirst().get();
            if (dupe > 90) {
                prioritySum += dupe - 96;
            } else {
                prioritySum += dupe - 38;
            }
        }
        return prioritySum;
    }

    @Override
    public long task2() {
        int prioritySum = 0;

        List<String> strings = puzzleInputStream().collect(Collectors.toList());

        Set<Character> chars1;
        Set<Character> chars2;
        Set<Character> chars3;
        for (int i = 0; i < strings.size(); i += 3) {

            chars1 = strings.get(i).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

            chars2 = strings.get(i + 1).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

            chars3 = strings.get(i + 2).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

            chars1.retainAll(chars2);
            chars1.retainAll(chars3);

            char dupe = chars1.stream().findFirst().get();
            if (dupe > 90) {
                prioritySum += dupe - 96;
            } else {
                prioritySum += dupe - 38;
            }
        }
        return prioritySum;
    }
}
