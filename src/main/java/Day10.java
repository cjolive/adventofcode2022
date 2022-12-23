import java.util.List;
import java.util.stream.Collectors;

public class Day10 extends Day {

    @Override
    public long task1() {

        int cycle = 0;
        int X = 1;
        int signalMeasure = 20;
        int signalStrength = 0;

        List<Instruction> instructionList =
                puzzleInputStream().map(s -> new Instruction(s)).collect(Collectors.toList());

        while (!instructionList.isEmpty()) {
            Instruction i = instructionList.get(0);
            cycle++;
            i.run();

            if (cycle == signalMeasure) {
                signalStrength += (cycle * X);
                signalMeasure += 40;
            }

            if (i.isFinished()) {
                if (i.isAddx) {
                    X += i.number;
                }
                instructionList.remove(0);
            }
        }
        return signalStrength;
    }

    @Override
    public long task2() {

        int X = 1;

        List<Instruction> instructionList =
                puzzleInputStream().map(s -> new Instruction(s)).collect(Collectors.toList());

        while (!instructionList.isEmpty()) {

            for (int j = 0; j < 40; j++) {

                if (X == j || X == j - 1 || X == j + 1) {
                    System.out.print("X");
                } else {
                    System.out.print(".");
                }

                Instruction i = instructionList.get(0);
                i.run();

                if (i.isFinished()) {
                    if (i.isAddx) {
                        X += i.number;
                    }
                    instructionList.remove(0);
                }
            }
            System.out.println();
        }

        return 0;
    }

    class Instruction {

        String s;
        int cycles;

        int number = 0;

        boolean isAddx = false;

        Instruction(String s) {
            this.s = s;
            if (s.startsWith("noop")) {
                cycles = 1;
            } else {
                cycles = 2;
                isAddx = true;
                String[] parts = s.split(" ");
                number = Integer.parseInt(parts[1]);
            }
        }

        void run() {
            cycles--;
        }

        boolean isFinished() {
            return cycles == 0;
        }

        public String toString() {
            return s;
        }
    }
}
