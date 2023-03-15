package App2;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    // fields and methods for managing the user interface
    public void displayLogicalProcessorCount(int count) {
        System.out.println("The computer system has " + count + " logical processors.");
    }
    @Override
    public void update(Observable o, Object arg) {
        // update the user interface with the new data from the model
    }
}



