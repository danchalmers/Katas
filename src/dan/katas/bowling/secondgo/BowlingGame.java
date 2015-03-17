package dan.katas.bowling.secondgo;

/**
 * In my first attempt at this Kata I started by considering a single frame,
 * then the whole game. In this attempt I want to consciously constrain myself
 * towards a different solution, as follows:
 *
 * First: Start by breaking a whole game into frames. This I did, in that my
 * tests started with the idea of generating a Frame which consumed some
 * characters in the input. However, I was soon writing Frame methods as this is
 * naturally a leaf class in my head.
 *
 * Second: Limit methods to 5 lines, excluding the method signature and
 * method-enclosing brackets. I didn't achieve this, although the longest method
 * is much shorter than the first attempt. I could see ways to eliminate some of
 * the longer methods - but at the expense of adding unnecessary loops and/or
 * field variables where they weren't really needed. The pattern matching in
 * functions of Haskell would have done this really neatly!
 *
 * As a design I'm mostly happy, and it is probably clearer than my first go.
 * The only element that doesn't sit comfortably is the look-ahead for '/' in
 * makeTwoRollFrame.
 *
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 * @date 2015
 */
public class BowlingGame {

    static Frame addFrame(String scoreCard) {
	return Frame.makeFrame(scoreCard);
    }

    /**
     * Produces the score for a card by generating a series of Frames, which
     * consume the input.
     *
     * @param scoreCard
     * @return the score
     */
    public static int getScore(String scoreCard) {
	int score = 0, index = 0;

	for (int frameCount = 0; frameCount < 10; frameCount++) {
	    Frame f = addFrame(scoreCard.substring(index));
	    score += f.score;
	    index += f.consumed;
	}
	return score;
    }

}
