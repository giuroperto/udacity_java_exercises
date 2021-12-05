import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        File filePhase1 = new File("phase-1.txt");
        File filePhase2 = new File("phase-1.txt");

        ArrayList<Item> allItemsPhase1 = simulation.loadItems(filePhase1);
        ArrayList<Item> allItemsPhase2 = simulation.loadItems(filePhase2);

        ArrayList<U1> fleetPhase1 = simulation.loadU1(allItemsPhase1);
        ArrayList<U1> fleetPhase2 = simulation.loadU1(allItemsPhase2);

        for (U1 rocket : fleetPhase1) {
            System.out.println(rocket.land());
//            System.out.println(rocket.cargo);
        }

        for (U1 rocket : fleetPhase2) {
//            System.out.println(rocket.cargo);
        }

    }
}

//    Run the simulation using the fleet of U1 rockets and display the total budget required.
//        Repeat the same for U2 rockets and display the total budget for that.
