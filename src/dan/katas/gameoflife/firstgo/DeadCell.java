
package dan.katas.gameoflife.firstgo;

/**
 * A Cell which is dead, inheritence simplifies some cell logic.
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 * @date 2015 
 */

class DeadCell extends Cell {

    DeadCell(int x, int y) {
	super(x, y);
    }

    @Override
    protected Cell getNext(int aliveCount) {
	if (aliveCount == 3) {
	    return makeAliveCell(x, y);
	} else {
	    return makeDeadCell(x, y);
	}
    }

    @Override
    protected boolean isAlive() {
	return false;
    }

    @Override
    String render() {
	return ".";
    }

}
