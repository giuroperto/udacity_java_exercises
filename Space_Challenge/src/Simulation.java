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
        ArrayList<Item> copyItems = new ArrayList<>(allItems);
        U1 currentRocket = new U1();

        while (copyItems.size() > 0) {
            for (int i = copyItems.size() - 1; i >= 0; i--) {
                if (currentRocket.canCarry(copyItems.get(i))) {
                    currentRocket.carry(copyItems.get(i));
                    copyItems.remove(copyItems.get(i));
                }
            }
            U1Fleet.add(currentRocket);
            currentRocket = new U1();
        }
        return U1Fleet;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> allItems) {
        ArrayList<Rocket> U2Fleet = new ArrayList<>();
        ArrayList<Item> copyItems = new ArrayList<>(allItems);
        U2 currentRocket = new U2();

        while (copyItems.size() > 0) {
            for (int i = copyItems.size() - 1; i >= 0; i--) {
                if (currentRocket.canCarry(copyItems.get(i))) {
                    currentRocket.carry(copyItems.get(i));
                    copyItems.remove(copyItems.get(i));
                }
            }
            U2Fleet.add(currentRocket);
            currentRocket = new U2();
        }
        return U2Fleet;
    }

    public int runSimulation(ArrayList<Rocket> allRockets) {
        int rocketCount = allRockets.size();
        int rocketCost = 0;

        for (Rocket rocket : allRockets) {
            boolean isLaunchSuccessful = rocket.launch();
            boolean isLandSuccessful = rocket.land();
            rocketCost = rocket.rocketCost;

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