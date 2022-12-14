import java.util.List;
import java.util.stream.Collectors;

public class Day4 extends Day {
    @Override
    public long task1() {
        List<String> strings = puzzleInputStream().collect(Collectors.toList());

        int coversRange = 0;
        for (String s : strings) {
            if (isPair(s)) {
                coversRange++;
            }
        }

        return coversRange;
    }

    @Override
    public long task2() {
        List<String> strings = puzzleInputStream().collect(Collectors.toList());

        int coversRange = 0;
        for (String s : strings) {
            if (isPair2(s)) {
                coversRange++;
            }
        }

        return coversRange;
    }

    private boolean isPair(String s) {
        String[] parts = s.split(",");
        Coordinates c1 = new Coordinates(parts[0]);
        Coordinates c2 = new Coordinates(parts[1]);

        if ((c1.start >= c2.start && c1.end <= c2.end) || (c2.start >= c1.start && c2.end <= c1.end)) {
            return true;
        }

        return false;
    }

    private boolean isPair2(String s) {
        String[] parts = s.split(",");
        Coordinates c1 = new Coordinates(parts[0]);
        Coordinates c2 = new Coordinates(parts[1]);

        return false;
    }

    class Coordinates {
        int start;
        int end;

        Coordinates(String s) {
            String[] parts = s.split("-");
            this.start = Integer.parseInt(parts[0]);
            this.end = Integer.parseInt(parts[1]);
        }
    }
}
