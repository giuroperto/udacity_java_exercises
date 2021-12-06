import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        File filePhase1 = new File("phase-1.txt");
        File filePhase2 = new File("phase-2.txt");

        ArrayList<Item> allItemsPhase1 = simulation.loadItems(filePhase1);
        ArrayList<Item> allItemsPhase2 = simulation.loadItems(filePhase2);

        ArrayList<U1> U1FleetPhase1 = simulation.loadU1(allItemsPhase1);
        ArrayList<U1> U1FleetPhase2 = simulation.loadU1(allItemsPhase2);

        simulation.runSimulation(U1FleetPhase1);
        simulation.runSimulation(U1FleetPhase2);

        ArrayList<U2> U2FleetPhase1 = simulation.loadU2(allItemsPhase1);
        ArrayList<U2> U2FleetPhase2 = simulation.loadU2(allItemsPhase2);

        simulation.runSimulation(U2FleetPhase1);
        simulation.runSimulation(U2FleetPhase2);
    }

    public void printResult() {

    }
}

//    Run the simulation using the fleet of U1 rockets and display the total budget required.
//        Repeat the same for U2 rockets and display the total budget for that.
