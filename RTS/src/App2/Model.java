package App2;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.util.List;

    public class Model extends Observable {
        // fields and methods for managing the state of the model
        private List<Observer> observers;
        public Model ()
        {
            observers = new ArrayList<>();

        }
        public void updateModel() {
            // method for updating the state of the model

            // notify observers of any changes
            setChanged();
            notifyObservers();
        }


    }


