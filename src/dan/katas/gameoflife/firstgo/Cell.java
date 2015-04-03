package dan.katas.gameoflife.firstgo;

import java.util.Objects;

/**
 * Following the Game of Life Kata description in Emily Bache's Coding Dojo Handbook
 * Cell represents an individual alive / dead cell in the world, which stays alive / is born / dies due to its surroundings.
 * 
 * Not strictly following the requirement of an infinite space, as this has coordinates bounded by the int value space. 
 * Linked Cells will be left for another attempt.
 * 
 * This class developed before the World, but a mock world was used in testing very early on.
 * 
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 * @date 2015
 */
public class Cell {

    static String getCoordKey(int x, int y) {
	return new StringBuilder().append(x).append(",").append(y).toString();
    }

    enum CellState {
	ALIVE, DEAD
    };

    private final int x, y;
    private CellState state = CellState.DEAD;

    Cell(int x, int y) {
	this.x = x;
	this.y = y;
    }

    Cell(int x, int y, CellState s) {
	this(x, y);
	state = s;
    }

    String getCoordKey() {
	return getCoordKey(getX(), getY());
    }

    public Cell getNext(WorldLookup world) {
	int aliveCount = countAdjacentAlive(world);
	if (isAlive()) {
	    return getNextAlive(aliveCount);
	} else {
	    return getNextDead(aliveCount);
	}
    }

    private Cell getNextAlive(int aliveCount) {
	switch (aliveCount) {
	    case 0:
	    case 1:
		return new Cell(getX(), getY(), CellState.DEAD);
	    case 2:
	    case 3:
		return new Cell(getX(), getY(), CellState.ALIVE);
	    default:
		return new Cell(getX(), getY(), CellState.DEAD);

	}
    }

    private Cell getNextDead(int aliveCount) {
	if (aliveCount == 3) {
	    return new Cell(getX(), getY(), CellState.ALIVE);
	} else {
	    return new Cell(getX(), getY(), CellState.DEAD);
	}
    }

    boolean isAlive() {
	return state == CellState.ALIVE;
    }

    private int countAdjacentAlive(WorldLookup world) {
	int aliveCount = 0;
	for (int x1 = getX() - 1; x1 <= getX() + 1; x1++) {
	    for (int y1 = getY() - 1; y1 <= getY() + 1; y1++) {
		if (x1 != getX() || y1 != getY()) {
		    if (world.getCellAt(x1, y1).isAlive()) {
			aliveCount++;
		    }
		}
	    }
	}
	return aliveCount;
    }

    // for drawing the String grid
    String render() {
	if (state == CellState.ALIVE) {
	    return "X";
	} else {
	    return ".";
	}
    }

    /**
     * @return the x
     */
    int getX() {
	return x;
    }

    /**
     * @return the y
     */
    int getY() {
	return y;
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 67 * hash + this.x;
	hash = 67 * hash + this.y;
	hash = 67 * hash + Objects.hashCode(this.state);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Cell other = (Cell) obj;
	if (this.x != other.x) {
	    return false;
	}
	if (this.y != other.y) {
	    return false;
	}
	if (this.state != other.state) {
	    return false;
	}
	return true;
    }

    // written for debugging
    @Override
    public String toString() {
	return "Cell{" + "x=" + x + ", y=" + y + ", state=" + state + '}';
    }

}
