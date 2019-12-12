
package cellMultiplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Multiplication {
    
    List<Cell> cellList;
    int iloscOrganizmowCyklu;
    static int counter = 0;
    public Multiplication(List<Cell> cellList) {
	this.cellList = cellList;
	iloscOrganizmowCyklu = cellList.size();
    }

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void cycle() {

	final ScheduledFuture<?> cycleRepeat = scheduler.scheduleAtFixedRate(() -> multiply(), 0, 5,
		TimeUnit.SECONDS);
	scheduler.schedule(() -> cycleRepeat.cancel(true), 30, TimeUnit.SECONDS);
	scheduler.schedule(() -> scheduler.shutdown(), 35, TimeUnit.SECONDS);
    }

    void multiply() {

	for (int i = iloscOrganizmowCyklu; i > 0; i--) {
	    cellList.add(new Cell(iloscOrganizmowCyklu + 1));
	    iloscOrganizmowCyklu = iloscOrganizmowCyklu + 1;
	   
	}
	 counter++;
	System.out.println("Cykl "+counter+": " + cellList);
	    System.out.println(iloscOrganizmowCyklu);
    }

}
