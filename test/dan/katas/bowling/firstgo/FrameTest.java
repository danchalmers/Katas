package dan.katas.bowling.firstgo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 * For info - I had this complete before starting the BowlingGame.
 */
public class FrameTest {
    
    public FrameTest() {
    }
    
    // Test a simple scoring frame's score
    @Test
    public void test_frameScoreSimple() {
	Frame f = new Frame();
	f.roll('2');
	f.roll('3');
	assertEquals(5, f.getScore());
	
	f = new Frame();
	f.roll('7');
	f.roll('2');
	assertEquals(9, f.getScore());    
    }
    
    // Test that a miss works
    @Test
    public void test_frameScoreMiss() {
	Frame f = new Frame();
	f.roll('-');
	f.roll('1');
	assertEquals(1, f.getScore());
	
	f = new Frame();
	f.roll('6');
	f.roll('-');
	assertEquals(6, f.getScore());    
    }
    
    @Test
    public void test_spare() {
	Frame f1 = new Frame();
	Frame f2;
	f1.roll('7');
	f2 = f1.roll('/');
	f2.roll('4');
	f2.roll('4');
	assertEquals(14, f1.getScore());    
    }
    
    @Test
    public void test_spareThenStrike() {
	Frame f1 = new Frame();
	Frame f2;
	f1.roll('7');
	f2 = f1.roll('/');
	f2.roll('X');
	assertEquals(20, f1.getScore());    
    }
    
    @Test
    public void test_strike() {
	Frame f1 = new Frame();
	Frame f2;
	f2 = f1.roll('X');
	f2.roll('5');
	f2.roll('4');
	assertEquals(19, f1.getScore());    
    }
    
    @Test
    public void test_strikeThenSpare() {
	Frame f1 = new Frame();
	Frame f2;
	f2 = f1.roll('X');
	f2.roll('5');
	f2.roll('/');
	assertEquals(20, f1.getScore());    
    }
    
    @Test
    public void test_strikeThenStrikeStrike() {
	Frame f1 = new Frame();
	Frame f2, f3;
	f2 = f1.roll('X');
	f3 = f2.roll('X');
	f3.roll('X');
	assertEquals(30, f1.getScore());    
    }
}
