package dan.katas.gameoflife.firstgo;

import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 */
public class CellTest {

    @Test
    public void test_getCoordKey() {
	Cell c = new Cell(-1, 3);
	String expected = "-1,3";
	assertEquals("coord key broken, not -1,3", expected, c.getCoordKey());
    }

    @Test
    public void test_eightLookups() {
	Cell c = new Cell(0, 0, Cell.CellState.ALIVE);
	NAdjacentAliveMock world = new NAdjacentAliveMock(2);
	c.getNext(world);
	assertEquals("Lookup should make 8 different tests", 8, world.testedCells.size());
    }

    @Test
    public void test_dies() {
	Cell c = new Cell(0, 0, Cell.CellState.ALIVE);
	WorldLookup world = new NAdjacentAliveMock(0);
	Cell result = c.getNext(world);
	assertFalse("Should die", result.isAlive());
    }

    @Test
    public void test_staysDead() {
	Cell c = new Cell(0, 0, Cell.CellState.DEAD);
	WorldLookup world = new NAdjacentAliveMock(0);
	Cell result = c.getNext(world);
	assertFalse("Should stay dead", result.isAlive());
    }

    @Test
    public void test_staysAlive2() {
	Cell c = new Cell(0, 0, Cell.CellState.ALIVE);
	WorldLookup world = new NAdjacentAliveMock(2);
	Cell result = c.getNext(world);
	assertTrue("Should stay alive", result.isAlive());
    }

    @Test
    public void test_staysAlive3() {
	Cell c = new Cell(0, 0, Cell.CellState.ALIVE);
	WorldLookup world = new NAdjacentAliveMock(3);
	Cell result = c.getNext(world);
	assertTrue("Should stay alive", result.isAlive());
    }

    @Test
    public void test_comesAlive3() {
	Cell c = new Cell(0, 0, Cell.CellState.DEAD);
	WorldLookup world = new NAdjacentAliveMock(3);
	Cell result = c.getNext(world);
	assertTrue("Should come to life", result.isAlive());
    }

    @Test
    public void test_dies4() {
	Cell c = new Cell(0, 0, Cell.CellState.ALIVE);
	WorldLookup world = new NAdjacentAliveMock(4);
	Cell result = c.getNext(world);
	assertFalse("Should stay alive", result.isAlive());
    }

    class NAdjacentAliveMock implements WorldLookup {

	int reportedAlive = 0;
	int requiredAlive;
	HashSet<String> testedCells;

	NAdjacentAliveMock(int alive) {
	    requiredAlive = alive;
	    testedCells = new HashSet<>();
	}

	private void checkCoords(int x, int y) {
	    assertTrue("Lookup should only be adjacent to 0,0 but x was " + x, Math.abs(x) >= -1 || Math.abs(x) <= 1);
	    assertTrue("Lookup should only be adjacent to 0,0 but y was " + x, Math.abs(y) >= -1 || Math.abs(y) <= 1);
	}

	@Override
	public Cell getCellAt(int x, int y) {
	    Cell c;
	    checkCoords(x,y);
	    if (reportedAlive < requiredAlive) {
		reportedAlive++;
		c = new Cell(x, y, Cell.CellState.ALIVE);
	    } else {
		c = new Cell(x, y, Cell.CellState.DEAD);
	    }
	    testedCells.add(c.getCoordKey());
	    return c;
	}

    }

}
