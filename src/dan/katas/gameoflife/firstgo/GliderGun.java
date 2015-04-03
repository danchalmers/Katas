
package dan.katas.gameoflife.firstgo;

/**
 * Runs and prints the world using the glider gun setup world.
 * @author Dan Chalmers <D.Chalmers@sussex.ac.uk>
 * @date 2015 
 */

public class GliderGun {
    public static void main(String[] args) {
	World world = new World();
	world.addCell(Cell.makeAliveCell(1, 4));
	world.addCell(Cell.makeAliveCell(1, 5));
	world.addCell(Cell.makeAliveCell(2,4));
	world.addCell(Cell.makeAliveCell(2,5));
	world.addCell(Cell.makeAliveCell(11,3));
	world.addCell(Cell.makeAliveCell(11,4));
	world.addCell(Cell.makeAliveCell(11,5));
	world.addCell(Cell.makeAliveCell(12,2));
	world.addCell(Cell.makeAliveCell(12,6));
	world.addCell(Cell.makeAliveCell(13,1));
	world.addCell(Cell.makeAliveCell(13,7));
	world.addCell(Cell.makeAliveCell(14,1));
	world.addCell(Cell.makeAliveCell(14,7));
	world.addCell(Cell.makeAliveCell(15,4));
 	world.addCell(Cell.makeAliveCell(16,2));
	world.addCell(Cell.makeAliveCell(16,6));
	world.addCell(Cell.makeAliveCell(17,3));
	world.addCell(Cell.makeAliveCell(17,4));
	world.addCell(Cell.makeAliveCell(17,5));
	world.addCell(Cell.makeAliveCell(18,4));
	world.addCell(Cell.makeAliveCell(21,5));
	world.addCell(Cell.makeAliveCell(21,6));
	world.addCell(Cell.makeAliveCell(21,7));
	world.addCell(Cell.makeAliveCell(22,5));
	world.addCell(Cell.makeAliveCell(22,6));
	world.addCell(Cell.makeAliveCell(22,7));
	world.addCell(Cell.makeAliveCell(23,4));
	world.addCell(Cell.makeAliveCell(23,8));
	world.addCell(Cell.makeAliveCell(25,4));
	world.addCell(Cell.makeAliveCell(25,8));
	world.addCell(Cell.makeAliveCell(25,3));
	world.addCell(Cell.makeAliveCell(25,9));
	world.addCell(Cell.makeAliveCell(35,6));
	world.addCell(Cell.makeAliveCell(35,7));
	world.addCell(Cell.makeAliveCell(36,6));
	world.addCell(Cell.makeAliveCell(36,7));
	for (int i=0; i<20; i++) {
	    world.print();
	    world = world.tick();
	}
     }


}
