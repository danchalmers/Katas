package dan.katas.bowling.firstgo;

/**
 * 
 * The BowlingGame Kata.
 * Based on Emily Bache's Coding Dojo Handbook spec.
 * This is my first version, without having looked at others' work.
 * 
 * Frame handles an individual frame and its score. 
 * 
 * Note that a roll also acts as a factory, dealing with the end of the roll.
 * This behaviour was added in a refactoring, initially getting the next frame 
 * was a separate call.
 * 
 * One divergence from the original spec is that the extra throws 
 * (rolls in my terminology for obvious keyword avoidance reasons)
 * can form two Frames, if the first one is a strike.
 * 
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 */

public class Frame {

    private int[] scores;
    private int rollIdx;
    private Frame nextFrame;
    
    /**
     * An empty Frame.
     */
    public Frame() {
	scores = new int[2];
	rollIdx = 0;
    }
    
    /**
     * Process one roll of the ball symbol.
     * 
     * @param s The symbol (0-9,-,/,*) that represents the result of the row.
     * @return Either the current frame object, or a new one 
     * if this roll completes the frame.
     */
    public Frame roll(char s) {
	switch (s) {
	    case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': 
		scores[rollIdx] = Character.digit(s, 10);
		break;
		
	    case '-':
		scores[rollIdx] = 0;
		break;
		
	    case '/':
		scores[rollIdx] = 10 - scores[rollIdx-1];
		break;
		
	    case 'X':
		scores[rollIdx] = 10;
		break;
		
	}
	rollIdx++;
	return getFrame();
    }

    /**
     * Calculates the score for a frame. This should only be called once all 
     * rolls in the game have been calculated, as the score for this frame may 
     * depend on the next one or two rolls.
     * @return The score.
     */
    public int getScore() {
	int total = 0;
	for (int s : scores) {
	    total += s;
	}
	if (isSpare()) {
	    total += nextFrame.getFirstRoll();
	} else if (isStrike()) {
	    total += nextFrame.getTwoRolls();
	}
	return total;
    }
    
    private boolean isSpare() {
	return !isStrike() && (scores[0]+scores[1] == 10);
    }
    
    private boolean isStrike() {
	return scores[0] == 10;
    }
    
    private int getFirstRoll() {
	return scores[0];
    }
    
    private int getTwoRolls() {
	if (isStrike()) {
	    return 10 + nextFrame.getFirstRoll();
	} else {
	    return scores[0] + scores[1];
	}
    }

    private Frame getFrame() {
	if ((rollIdx == 2) || isStrike()) {
	    nextFrame = new Frame();
	    return nextFrame;
	} else {
	    return this;
	}
    }
}
