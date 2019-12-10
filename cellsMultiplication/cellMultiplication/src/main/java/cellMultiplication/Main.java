package cellMultiplication;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Cell cellsMother = new Cell(1);
	List<Cell> cellList = new ArrayList<Cell>();
	cellList.add(cellsMother);

	var multiplication = new Multiplication(cellList);
	multiplication.cycle();
    }
}
