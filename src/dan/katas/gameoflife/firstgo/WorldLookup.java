
package dan.katas.gameoflife.firstgo;

/**
 * Lookup of a cell is an interface to facilitate mock in testing.
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 */
public interface WorldLookup {
    Cell getCellAt(int x, int y);
    
}
