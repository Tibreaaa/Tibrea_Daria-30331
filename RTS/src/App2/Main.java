package App2;
import java.util.Observer;

public class Main {

    private static final int noOfThreads=6;

    private static final int processorLoad=1000000;

    public static void main(String args[]){

        Window win=new Window(noOfThreads);

        for(int i =0; i<noOfThreads; i++){

            new Fir(i,i+2,win,processorLoad).start();

        }
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();

// register the view and controller as observers of the model
        model.addObserver(view);
        model.addObserver(controller);


    }



}