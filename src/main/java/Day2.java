public class Day2 extends Day {
    @Override
    public long task1() {
        return puzzleInputStream().map(p -> new Game(p)).map(g -> g.gameScore()).reduce(0, Integer::sum);
    }

    @Override
    public long task2() {
        return puzzleInputStream()
                .map(p -> new Game(p))
                .map(g -> g.gameScore2())
                .reduce(0, Integer::sum);
    }

    class Game {

        char player1;
        char player2;

        Game(String game) {
            char[] moves = game.toCharArray();
            this.player1 = moves[0];
            this.player2 = moves[2];
        }

        public int gameScore() {
            int score = 0;
            if (this.player2 == 'X') { // rock
                score += 1;
                if (this.player1 == 'C') score += 6;
                if (this.player1 == 'A') score += 3;
            } else if (this.player2 == 'Y') { // paper
                score += 2;
                if (this.player1 == 'A') score += 6;
                if (this.player1 == 'B') score += 3;
            } else { // scissors
                score += 3;
                if (this.player1 == 'B') score += 6;
                if (this.player1 == 'C') score += 3;
            }
            return score;
        }

        // rock = 1, paper = 2, scissors = 3
        public int gameScore2() {
            int score = 0;
            if (this.player2 == 'X') { // lose
                if (this.player1 == 'A') score += 3; // rock
                if (this.player1 == 'B') score += 1; // paper
                if (this.player1 == 'C') score += 2; // scissors
            } else if (this.player2 == 'Y') { // draw
                score += 3;
                if (this.player1 == 'A') score += 1; // rock
                if (this.player1 == 'B') score += 2; // paper
                if (this.player1 == 'C') score += 3; // scissors
            } else { // win
                score += 6;
                if (this.player1 == 'A') score += 2; // rock
                if (this.player1 == 'B') score += 3; // paper
                if (this.player1 == 'C') score += 1; // scissors
            }
            return score;
        }
    }
}
