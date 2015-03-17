package dan.katas.bowling.secondgo;

/**
 * A pair of score and characters on the input consumed in this Frame. Mostly
 * static for generating the Frame.
 *
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 * @date 2015
 */
public class Frame {

    /**
     * How many rolls were consumed in this frame. 1 for a strike, 2 otherwise.
     */
    public final int consumed;
    /**
     * The score arising from this frame alone - not a running total. 
     */
    public final int score;

    public Frame(int consumed, int score) {
	this.consumed = consumed;
	this.score = score;
    }

    /**
     * Creates a single Frame by examining the input for a valid sequence of rolls.
     *
     * @param scoreCard The remaining input that this Frame will be constructed
     * from
     */
    public static Frame makeFrame(String scoreCard) {
	return makeStrikeOrTwoRollFrame(scoreCard);
    }

    private static Frame makeStrikeOrTwoRollFrame(String scoreCard) {
	if (scoreCard.charAt(0) == 'X') {
	    return new Frame(1, getScore(scoreCard.substring(0, 3)));
	} else {
	    return makeTwoRollFrame(scoreCard);
	}
    }

    private static Frame makeTwoRollFrame(String scoreCard) {
	if (scoreCard.charAt(1) == '/') {
	    return makeSpareFrame(scoreCard);
	} else {
	    return new Frame(2, getScore(scoreCard.substring(0, 2)));
	}
    }

    private static Frame makeSpareFrame(String scoreCard) {
	return new Frame(2, getScore(scoreCard.substring(0, 3)));
    }

    static int getScore(String rolls) {
	int total = 0, prev = 0;

	for (int i = 0; i < rolls.length(); i++) {
	    prev = getScore(rolls.charAt(i), prev);
	    total += prev;
	}
	return total;
    }

    static int getScore(char roll, int prev) {
	switch (roll) {
	    case '/':
		return 10 - prev;
	    case '-':
		return 0;
	    case 'X':
		return 10;
	    default:
		return Character.getNumericValue(roll);
	}
    }

}
