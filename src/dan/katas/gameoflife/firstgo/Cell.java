package dan.katas.gameoflife.firstgo;

/**
 * Following the Game of Life Kata description in Emily Bache's Coding Dojo
 * Handbook Cell represents an individual alive / dead cell in the world, which
 * stays alive / is born / dies due to its surroundings.
 *
 * Not strictly following the requirement of an infinite space, as this has
 * coordinates bounded by the int value space. Linked Cells will be left for
 * another attempt.
 *
 * This class developed before the World, but a mock world was used in testing
 * very early on.
 *
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 * @date 2015
 */
public abstract class Cell {

    static String getCoordKey(int x, int y) {
	return new StringBuilder().append(x).append(",").append(y).toString();
    }

    protected final int x, y;

    protected Cell(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /**
     * Create a new living cell
     * @param x coordinate
     * @param y coordinate
     * @return the cell
     */
    public static Cell makeAliveCell(int x, int y) {
	return new AliveCell(x, y);
    }

    /**
     * Create a new dead cell
     * @param x coordinate
     * @param y coordinate
     * @return the cell
     */
    public static Cell makeDeadCell(int x, int y) {
	return new DeadCell(x, y);
    }

    String getCoordKey() {
	return getCoordKey(x, y);
    }

    /**
     * Get the next generation of this cell
     * @param world
     * @return 
     */
    public Cell getNext(final WorldLookup world) {
	int aliveCount = countAdjacentAlive(world);
	return getNext(aliveCount);
    }

    protected abstract Cell getNext(final int aliveCount);

    protected abstract boolean isAlive();

    // life or death in the next generation depends on how many neighbours are alive
    private int countAdjacentAlive(final WorldLookup world) {
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
    abstract String render();

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
}
