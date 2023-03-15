package App2;

import java.util.Observer;
import java.util.Observable;

public class Controller implements Observer {
    // fields and methods for managing user input and updating the model
    public int getLogicalProcessorCount() {
// use system-level API to get the number of processors
        return Runtime.getRuntime().availableProcessors();
    }
    @Override
    public void update(Observable o, Object arg) {
        // update the model with any new user input
    }
}