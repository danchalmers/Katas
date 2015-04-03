
package dan.katas.gameoflife.firstgo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 */
public class WorldTest {
    
    @Test
    public void test_retreiveFreshCell() {
	World w = new World();
	Cell c = new Cell(0,0,Cell.CellState.DEAD);
	assertNotNull("World should make a cell if none exists", w.getCellAt(0,0));
    }
    
    @Test
    public void test_retreiveAddedCell() {
	World w = new World();
	Cell c1 = new Cell(0,0,Cell.CellState.DEAD);
	w.addCell(c1);
	Cell c2 = new Cell(5,5,Cell.CellState.ALIVE);
	w.addCell(c2);
	assertEquals("World should return a correctly", c1, w.getCellAt(0,0));
	assertEquals("World should return a correctly", c2, w.getCellAt(5,5));
    }
    
    @Test
    public void test_tickChangesCellState() {
	World w = new World();
	for (int x=0; x<3; x++) {
	    for (int y=0; y<3; y++) {
		w.addCell(new Cell(x,y,Cell.CellState.DEAD));
	    }
	}
	w.addCell(new Cell(0,0,Cell.CellState.ALIVE));
	w.addCell(new Cell(1,2,Cell.CellState.ALIVE));
	w.addCell(new Cell(2,1,Cell.CellState.ALIVE));
	World result = w.tick();
	assertTrue("this tick should change a cell to become alive", result.getCellAt(1, 1).isAlive());
	assertEquals("no need to make the cell space bigger this tick", result.getSize(), w.getSize());
   }

    @Test
    public void test_tickMakesNewEdgeCell() {
	World w = new World();
	w.addCell(new Cell(0,0,Cell.CellState.ALIVE));
	w.addCell(new Cell(1,0,Cell.CellState.ALIVE));
	w.addCell(new Cell(2,0,Cell.CellState.ALIVE));
	World result = w.tick();
	assertTrue("tick should create a new cell above, where there wasn't one before", result.getCellAt(1, 1).isAlive());
	assertTrue("tick should create a new cell below, where there wasn't one before", result.getCellAt(1, -1).isAlive());
	assertTrue(result.getSize() > w.getSize());
   }
    
    @Test
    public void test_updateBounds() {
	World w = new World();
	w.addCell(new Cell(1,1));
	w.addCell(new Cell(-1,-1));
	assertEquals(-1, w.getMinX());
	assertEquals(-1, w.getMinY());
	assertEquals(1, w.getMaxX());
	assertEquals(1, w.getMaxY());
	w.addCell(new Cell(5,6));
	assertEquals(5, w.getMaxX());
	assertEquals(6, w.getMaxY());
    }
    
    @Test
    public void test_worldToString() {
	World w = new World();
	World newWorld;
	String[] result;
	w.addCell(new Cell(0,0,Cell.CellState.ALIVE));
	w.addCell(new Cell(1,0,Cell.CellState.ALIVE));
	w.addCell(new Cell(2,0,Cell.CellState.ALIVE));
	result = w.render();
	print(result);

	
	newWorld = w.tick();
	result = newWorld.render();
	assertEquals("three rows in new world", 3, result.length);
	assertEquals("three cells in middle row", 3, result[1].length());
	print(result);

	
	newWorld = newWorld.tick();
	result = newWorld.render();
	assertEquals("three rows in new world", 3, result.length);
	assertEquals("three cells in middle row", 3, result[1].length());
	print(result);
	
	newWorld = newWorld.tick();
	result = newWorld.render();
	assertEquals("three rows in new world", 3, result.length);
	assertEquals("three cells in middle row", 3, result[1].length());
	print(result);
	
	newWorld = newWorld.tick();
	result = newWorld.render();
	assertEquals("three rows in new world", 3, result.length);
	assertEquals("three cells in middle row", 3, result[1].length());
	print(result);
    }
    
    	// test by inspection
    private void print(String[] result) {
	for (String s : result) {
	    System.out.println(s);
	}
	System.out.println();
    }

}
