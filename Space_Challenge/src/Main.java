import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        File filePhase1 = new File("phase-1.txt");
        File filePhase2 = new File("phase-2.txt");

        ArrayList<Item> allItemsPhase1 = simulation.loadItems(filePhase1);
        ArrayList<Item> allItemsPhase2 = simulation.loadItems(filePhase2);

        ArrayList<Rocket> U1FleetPhase1 = simulation.loadU1(allItemsPhase1);
        ArrayList<Rocket> U1FleetPhase2 = simulation.loadU1(allItemsPhase2);

        int totalU1BudgetPhase1 = simulation.runSimulation(U1FleetPhase1);
        int totalU1BudgetPhase2 = simulation.runSimulation(U1FleetPhase2);

        ArrayList<Rocket> U2FleetPhase1 = simulation.loadU2(allItemsPhase1);
        ArrayList<Rocket> U2FleetPhase2 = simulation.loadU2(allItemsPhase2);

        int totalU2BudgetPhase1 = simulation.runSimulation(U2FleetPhase1);
        int totalU2BudgetPhase2 = simulation.runSimulation(U2FleetPhase2);

        printHeader();
        printResult("1", "U1", totalU1BudgetPhase1);
        printResult("2", "U1", totalU1BudgetPhase2);
        printResult("1", "U2", totalU2BudgetPhase1);
        printResult("2", "U2", totalU2BudgetPhase2);

        rangeClosed(1, 5)
    }

    public static void printResult(String phase, String fleet, int budget) {
        System.out.println("PHASE " + phase);
        System.out.println("Fleet: " + fleet);
        System.out.println("-------------------------------------------");
        System.out.println("*** TOTAL BUDGET: $" + budget + " MILLION ***");
        System.out.println("-------------------------------------------");
    }

    public static void printHeader() {
        System.out.println("===========================================");
        System.out.println("============= SPACE CHALLENGE =============");
        System.out.println("===========================================");
    }
}

//    Run the simulation using the fleet of U1 rockets and display the total budget required.
//        Repeat the same for U2 rockets and display the total budget for that.
