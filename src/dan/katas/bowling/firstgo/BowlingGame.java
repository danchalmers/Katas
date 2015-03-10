package dan.katas.bowling.firstgo;

/**
 *
 * The BowlingGame Kata. Based on Emily Bache's Coding Dojo Handbook spec. This
 * is my first version, without having looked at others' work.
 *
 * BowlingGame handles processing the score line into individual scores and
 * returning the total.
 *
 * One divergence from the original spec is that the extra throws (rolls in my
 * terminology for obvious keyword avoidance reasons) can form two Frames, if
 * the first one is a strike.
 *
 * Frame was developed first, BowlingGame second.
 *
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 */
public class BowlingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	BowlingGame bg = new BowlingGame();
	System.out.println("score = " + bg.getScore(args[0]));
    }

    private Frame[] frames;
    private int frameIdx;

    /**
     * Setup for a new game
     */
    public BowlingGame() {
	frames = new Frame[13];
	frameIdx = 0;
	frames[0] = new Frame();
    }

    /**
     * Processes a line, calculating the score
     *
     * @param line - the sequence of characters representing the game
     * @return the score
     */
    public int getScore(String line) {
	for (char c : line.toCharArray()) {
	    processRoll(c);
	}
	return getScore();
    }

    private void processRoll(char c) {
	Frame f = frames[frameIdx];
	frames[frameIdx + 1] = f.roll(c);
	if (f != frames[frameIdx + 1]) {
	    frameIdx++;
	}
    }

    private int getScore() {
	Frame f;

	int total = 0;
	for (int i = 0; i < 10; i++) {
	    f = frames[i];
	    total += f.getScore();
	}
	return total;
    }

}
