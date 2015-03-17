package dan.katas.bowling.firstgo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Applies the example game line cases from Emily Bache's Coding Dojo book.
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 */
public class BowlingGameTest {
    
    @Test
    public void test_simpleScores60() {
	String testSeq = "12345123451234512345";
	BowlingGame bg = new BowlingGame();
	int result = bg.getScore(testSeq);
	assertEquals(60, result);
    }
    
    @Test
    public void test_allStrikes() {
	String testSeq = "XXXXXXXXXXXX";
	BowlingGame bg = new BowlingGame();
	int result = bg.getScore(testSeq);
	assertEquals(300, result);
    }
    @Test
    public void test_heartbreak() {
	String testSeq = "9-9-9-9-9-9-9-9-9-9-";
	BowlingGame bg = new BowlingGame();
	int result = bg.getScore(testSeq);
	assertEquals(90, result);
    }
    @Test
    public void test_allSpares() {
	String testSeq = "5/5/5/5/5/5/5/5/5/5/5";
	BowlingGame bg = new BowlingGame();
	int result = bg.getScore(testSeq);
	assertEquals(150, result);
    }
    @Test
    public void test_mixed() {
	String testSeq = "3/12X12X4/XX12XX5";
	BowlingGame bg = new BowlingGame();
	int result = bg.getScore(testSeq);
	assertEquals(132, result);
    }
}
