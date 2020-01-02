package cellMultiplication;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

	Cell cellsMother = new Cell();
	List<Cell> incubator = new ArrayList<Cell>();
	incubator.add(cellsMother);
	System.out.println(incubator);
	var colony = new ColonyOfCells(incubator);
	colony.grow(0, 1, 17);

    }

}
