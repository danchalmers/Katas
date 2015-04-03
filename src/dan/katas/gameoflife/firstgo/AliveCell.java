
package dan.katas.gameoflife.firstgo;

/**
 * A Cell which is alive, inheritence simplifies some cell logic.
 * @author Dan Chalmers <dan@danchalmers.me.uk>
 * @date 2015 
 */

class AliveCell extends Cell {

    AliveCell(int x, int y) {
	super(x, y);
    }

    @Override
    protected Cell getNext(int aliveCount) {
	if (aliveCount == 2 || aliveCount == 3) {
	    return makeAliveCell(x, y);
	} else {
	    return makeDeadCell(x, y);
	}
    }

    @Override
    protected boolean isAlive() {
	return true;
    }

    @Override
    String render() {
	return "X";
    }

}
