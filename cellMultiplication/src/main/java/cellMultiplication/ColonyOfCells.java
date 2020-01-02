
package cellMultiplication;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Represents colony of cells
 * 
 * @author Adam
 */

public class ColonyOfCells {

    private List<Cell> incubator;
    private int numberOfCells;
    private static int cycleCounter;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public ColonyOfCells(List<Cell> incubator) {

	this.incubator = incubator;

	numberOfCells = incubator.size();
    }

    /**
     * Clone all cells in colony every specified time period in seconds. Stop
     * cloning after specified seconds
     * 
     * @param period       of time between calls.
     * @param initialDelay at method start.
     * @param delay        how long do you want to clone cells
     */

    void grow(long initialDelay, long period, long delay) {
	
final ScheduledFuture<?> growthTempo = scheduler.scheduleAtFixedRate(() -> cloneAll(), initialDelay, period,
		TimeUnit.SECONDS);
	scheduler.schedule(() -> growthTempo.cancel(true), delay, TimeUnit.SECONDS);
	scheduler.schedule(() -> scheduler.shutdown(), delay, TimeUnit.SECONDS);
    }

    /**
     * clone all cells in incubator, shows exactly which instances are cloned and
     * give them an unique numbers
     */

    private void cloneAll() {
	for (int i = numberOfCells; i > 0; i--) {
	    var cell = incubator.get(i - 1);
	    System.out.println("Następuje podział " + cell);
	    Cell clonedCell = cell.clone();
	    clonedCell.setCellNumber(numberOfCells + 1); 
	    incubator.add(clonedCell);
	    numberOfCells = numberOfCells + 1;
	}
	cycleCounter++;
	System.out.println("Wynik cyklu " + cycleCounter + ": " + incubator);
	System.out.println("Wielkość kolonii: " + numberOfCells);
    }
}
