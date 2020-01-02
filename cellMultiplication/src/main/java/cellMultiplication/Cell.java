package cellMultiplication;

public class Cell {
    
    /**
     * create single cell with assigned number and ability to clone itself
     */

   private int cellNumber;

   Cell(){
    this(1);
}
    Cell(int cellNumber) {
	this.cellNumber = cellNumber;
    }

    
    @Override
    public Cell clone() {
	return new Cell(cellNumber);

    }

    @Override
    public String toString() {
	return "Cell [new life=" + cellNumber + "]";
    }
    
    public int getCellNumber() {
	    return cellNumber;
	}

	public void setCellNumber(int cellNumber) {
	    this.cellNumber = cellNumber;
	}
}
