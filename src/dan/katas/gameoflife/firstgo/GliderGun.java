
package dan.katas.gameoflife.firstgo;

/**
 * Runs and prints the world using the glider gun setup world.
 * @author Dan Chalmers <D.Chalmers@sussex.ac.uk>
 * @date 2015 
 */

public class GliderGun {
    public static void main(String[] args) {
	World world = new World();
	world.addCell(new Cell(1,4,Cell.CellState.ALIVE));
	world.addCell(new Cell(1,5,Cell.CellState.ALIVE));
	world.addCell(new Cell(2,4,Cell.CellState.ALIVE));
	world.addCell(new Cell(2,5,Cell.CellState.ALIVE));
	world.addCell(new Cell(11,3,Cell.CellState.ALIVE));
	world.addCell(new Cell(11,4,Cell.CellState.ALIVE));
	world.addCell(new Cell(11,5,Cell.CellState.ALIVE));
	world.addCell(new Cell(12,2,Cell.CellState.ALIVE));
	world.addCell(new Cell(12,6,Cell.CellState.ALIVE));
	world.addCell(new Cell(13,1,Cell.CellState.ALIVE));
	world.addCell(new Cell(13,7,Cell.CellState.ALIVE));
	world.addCell(new Cell(14,1,Cell.CellState.ALIVE));
	world.addCell(new Cell(14,7,Cell.CellState.ALIVE));
	world.addCell(new Cell(15,4,Cell.CellState.ALIVE));
 	world.addCell(new Cell(16,2,Cell.CellState.ALIVE));
	world.addCell(new Cell(16,6,Cell.CellState.ALIVE));
	world.addCell(new Cell(17,3,Cell.CellState.ALIVE));
	world.addCell(new Cell(17,4,Cell.CellState.ALIVE));
	world.addCell(new Cell(17,5,Cell.CellState.ALIVE));
	world.addCell(new Cell(18,4,Cell.CellState.ALIVE));
	world.addCell(new Cell(21,5,Cell.CellState.ALIVE));
	world.addCell(new Cell(21,6,Cell.CellState.ALIVE));
	world.addCell(new Cell(21,7,Cell.CellState.ALIVE));
	world.addCell(new Cell(22,5,Cell.CellState.ALIVE));
	world.addCell(new Cell(22,6,Cell.CellState.ALIVE));
	world.addCell(new Cell(22,7,Cell.CellState.ALIVE));
	world.addCell(new Cell(23,4,Cell.CellState.ALIVE));
	world.addCell(new Cell(23,8,Cell.CellState.ALIVE));
	world.addCell(new Cell(25,4,Cell.CellState.ALIVE));
	world.addCell(new Cell(25,8,Cell.CellState.ALIVE));
	world.addCell(new Cell(25,3,Cell.CellState.ALIVE));
	world.addCell(new Cell(25,9,Cell.CellState.ALIVE));
	world.addCell(new Cell(35,6,Cell.CellState.ALIVE));
	world.addCell(new Cell(35,7,Cell.CellState.ALIVE));
	world.addCell(new Cell(36,6,Cell.CellState.ALIVE));
	world.addCell(new Cell(36,7,Cell.CellState.ALIVE));
	for (int i=0; i<20; i++) {
	    print(world.render());
	    world = world.tick();
	}
     }
    	// test by inspection
    private static void print(String[] result) {
	for (String s : result) {
	    System.out.println(s);
	}
	System.out.println();
    }


}
