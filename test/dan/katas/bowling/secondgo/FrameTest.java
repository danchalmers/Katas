
package dan.katas.bowling.secondgo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Dan Chalmers  <dan@danchalmers.me.uk>
 */
public class FrameTest {
    
    @Test
    public void test_getScoreTwoRolls() {
	int expectedResult = 3;
	String rolls = "12";
	assertEquals("digits add up", expectedResult, Frame.getScore(rolls));
    }
    
    @Test
    public void test_getScoreTwoRollsMiss() {
	int expectedResult = 1;
	String rolls = "1-";
	assertEquals("miss is zero", expectedResult, Frame.getScore(rolls));
    }
    
     @Test
    public void test_getScoreOneStrike() {
	int expectedResult = 13;
	String rolls = "X12";
	assertEquals("stike is 10 + next two rolls", expectedResult, Frame.getScore(rolls));
    }
    
     @Test
    public void test_getScoreSpare() {
	int expectedResult = 11;
	String rolls = "3/1";
	assertEquals("spare is 10 + next roll", expectedResult, Frame.getScore(rolls));
    }

}
