import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(File file) {
        ArrayList<Item> items = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                Item newItem = new Item();
                String[] nextItem = fileScanner.nextLine().split("=");
                newItem.name = nextItem[0];
                newItem.weight = Integer.parseInt(nextItem[1]) / 1000;
                items.add(newItem);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> allItems) {
        ArrayList<Rocket> U1Fleet = new ArrayList<>();
        U1 currentRocket = new U1();

        for (Item item : allItems) {
//            System.out.println("current item: " + item.weight);
            if (!currentRocket.canCarry(item)) {
                U1Fleet.add(currentRocket);
//                System.out.println("u1 currentRocket: " + currentRocket.cargo);
                currentRocket = new U1();
            }
            currentRocket.carry(item);
//            System.out.println("current cargo: " + currentRocket.cargo);
        }
        U1Fleet.add(currentRocket);
        return U1Fleet;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> allItems) {
        ArrayList<Rocket> U2Fleet = new ArrayList<>();
        U2 currentRocket = new U2();

        for (Item item : allItems) {
            if (!currentRocket.canCarry(item)) {
                U2Fleet.add(currentRocket);
//                System.out.println("u2 currentRocket: " + currentRocket.cargo);
                currentRocket = new U2();
            }
            currentRocket.carry(item);
        }
        U2Fleet.add(currentRocket);
        return U2Fleet;
    }

    public int runSimulation(ArrayList<Rocket> allRockets) {
        int rocketCount = allRockets.size();
        int rocketCost = 0;

        for (Rocket rocket : allRockets) {
            boolean isLaunchSuccessful = rocket.launch();
            boolean isLandSuccessful = rocket.land();
//            System.out.println("isLaunchSuccessful: " + isLaunchSuccessful);
//            System.out.println("isLandSuccessful: " + isLandSuccessful);
            rocketCost = rocket.rocketCost;
//            System.out.println("rocketCost: " + rocketCost);

            while (!isLaunchSuccessful) {
                rocketCount += 1;
                isLaunchSuccessful = rocket.launch();
            }

            while (!isLandSuccessful) {
                rocketCount += 1;
                isLandSuccessful = rocket.land();
            }
        }

        return rocketCount * rocketCost;
    }
}