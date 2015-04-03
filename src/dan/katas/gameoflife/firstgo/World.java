package dan.katas.gameoflife.firstgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Following the Game of Life Kata description in Emily Bache's Coding Dojo Handbook
 * World represents the grid of cells in the game world.
 * 
 * Not strictly following the requirement of an infinite space, as this has coordinates bounded by the int value space. 
 * But, doesn't create an enormous 2D array!
 * Linked Cells will be left for another attempt.
 * 
 * This class developed after the Cell.
 * 
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 * @date 2015
 */
public class World implements WorldLookup {
    // Store for the cells in the world. Once a coordinate is added it is not removed.
    private final HashMap<String, Cell> worldCells;
    // Storage for newly created cells, that will be added at the next tick if they are alive
    private final HashSet<Cell> newEdgeCells; 
    
    // bounding box of coordinates, maintained for rendering
    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int maxY = Integer.MIN_VALUE;

    public World() {
	worldCells = new HashMap<>();
	newEdgeCells = new HashSet<>();
    }

    @Override
    public Cell getCellAt(int x, int y) {
	String key = Cell.getCoordKey(x, y);
	Cell cell = worldCells.get(key);
	
	/* Edges not in the world are created on the fly.
	  They are added to newEdge Cells to support adding cells that become alive.
	  Typically each will be created three times, hencenewEdgeCells being a HashSet, to avoid checking each one multiple times.
	  I don't check the hash though, as the overhead of testing is likely to outweigh the benefit of fewer create / put steps
	*/
	if (cell == null) {
	    cell = new Cell(x, y, Cell.CellState.DEAD);
	    newEdgeCells.add(cell);
	}
	return cell;
    }

    void addCell(Cell c) {
	worldCells.put(c.getCoordKey(), c);
	updateBounds(c);
    }

    private void updateBounds(Cell c) {
	int cx, cy;
	
	cx = c.getX();
	cy = c.getY();
	minX = Math.min(minX, cx);
	maxX = Math.max(maxX, cx);
	minY = Math.min(minY, cy);
	maxY = Math.max(maxY, cy);
    }

    public World tick() {
	World nextTickWorld;

	nextTickWorld = new World();
	tickCells(nextTickWorld);
	tickNewEdgeCells(nextTickWorld);
	return nextTickWorld;
    }

    private void tickCells(World nextTickWorld) {
	for (Cell cell : worldCells.values()) {
	    nextTickWorld.addCell(cell.getNext(this));
	}
    }

    // Look at the cells round the edge generated on the fly. If any become alive, then add to the next world.
    private void tickNewEdgeCells(World nextTickWorld) {
	// create a new collection to avoid concurrent modification
	// concurrent modification happens because this will prompt creating cells around these edge cells
	// create it as an array list as it is just for a scan through
	ArrayList<Cell> cellsToConsider = new ArrayList();
	cellsToConsider.addAll(newEdgeCells);
	// now, get the next state - if alive add to the next world
	for (Cell cell : cellsToConsider) {
	    Cell cellNextTick = cell.getNext(this);
	    if (cellNextTick.isAlive()) {
		nextTickWorld.addCell(cellNextTick);
	    }
	}
    }

    /**
     * @return the minX
     */
    int getMinX() {
	return minX;
    }

    /**
     * @return the minY
     */
    int getMinY() {
	return minY;
    }

    /**
     * @return the maxX
     */
    int getMaxX() {
	return maxX;
    }

    /**
     * @return the maxY
     */
    int getMaxY() {
	return maxY;
    }

    public String[] render() {
	String[] strings = new String[1 + maxY - minY];
	for (int y = minY; y <= maxY; y++) {
	    StringBuilder sb = new StringBuilder();
	    for (int x = minX; x <= maxX; x++) {
		sb.append(getCellAt(x, y).render());
	    }
	    strings[maxY-y] = sb.toString();
	}
	return strings;
    }

    // to support testing checks that it doesn't grow unnecessarily
    int getSize() {
	return worldCells.size();
    }

}
