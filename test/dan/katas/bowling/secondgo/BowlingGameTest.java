
package dan.katas.bowling.secondgo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 */
public class BowlingGameTest {  
  
    @Test
    public void test_twoThrowRoundConsumed() {
	Frame result = BowlingGame.addFrame("1234");
	assertEquals(2,result.consumed);
	assertEquals(3,result.score);
    }
    
    @Test
    public void test_simpleScores60() {
	String testSeq = "12345123451234512345";
	int result = BowlingGame.getScore(testSeq);
	assertEquals(60, result);
    }
    
    @Test
    public void test_heartbreak() {
	String testSeq = "9-9-9-9-9-9-9-9-9-9-";
	int result = BowlingGame.getScore(testSeq);
	assertEquals(90, result);
    }
    
    @Test
    public void test_strikeRoundConsumed() {
	Frame result = BowlingGame.addFrame("X12");
	assertEquals(1,result.consumed);
	assertEquals(13,result.score);
    }
    
    @Test
    public void test_strikeSequenceRoundConsumed() {
	Frame result = BowlingGame.addFrame("XXX");
	assertEquals(1,result.consumed);
	assertEquals(30,result.score);
    }
    
    @Test
    public void test_allStrikes() {
	String testSeq = "XXXXXXXXXXXX";
	int result = BowlingGame.getScore(testSeq);
	assertEquals(300, result);
    }
    
        
    @Test
    public void test_allSpares() {
	String testSeq = "5/5/5/5/5/5/5/5/5/5/5";
	int result = BowlingGame.getScore(testSeq);
	assertEquals(150, result);
    }
    
    @Test
    public void test_mixed() {
	String testSeq = "3/12X12X4/XX12XX5";
	int result = BowlingGame.getScore(testSeq);
	assertEquals(132, result);
    }
}
