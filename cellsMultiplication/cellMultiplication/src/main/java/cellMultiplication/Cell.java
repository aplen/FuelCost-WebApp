package cellMultiplication;

public class Cell implements Cloneable{
    int numerOrganizmu;
    
    Cell(int numerOrganizmu){
	this.numerOrganizmu=numerOrganizmu;
    }

   
    public Object split(Object cell) {

	try {
	    cell= this.clone();
	} catch (CloneNotSupportedException ole) {
	}
	return cell;
	
    }

    @Override
    public String toString() {
	return "Cell [new life=" + numerOrganizmu + "]";
    }

   

    
}
