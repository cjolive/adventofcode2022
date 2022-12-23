import java.util.HashSet;
import java.util.Set;

public class Day6 extends Day {
    @Override
    public long task1() {
        String s = puzzleInputStream().findFirst().get();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            Set<Character> characterSet = new HashSet<>();
            characterSet.add(chars[i]);
            characterSet.add(chars[i + 1]);
            characterSet.add(chars[i + 2]);
            characterSet.add(chars[i + 3]);
            if (characterSet.size() == 4) {
                return i + 4;
            }
        }

        return 0;
    }

    @Override
    public long task2() {
        String s = puzzleInputStream().findFirst().get();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            Set<Character> characterSet = new HashSet<>();
            for (int j = 0; j < 14; j++) {
                characterSet.add(chars[i + j]);
            }

            if (characterSet.size() == 14) {
                return i + 14;
            }
        }

        return 0;
    }
}
