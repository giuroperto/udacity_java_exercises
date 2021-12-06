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
                newItem.weight = Integer.parseInt(nextItem[1]);
                items.add(newItem);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        return items;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> allItems) {
        ArrayList<U1> U1Fleet = new ArrayList<>();
        U1 currentRocket = new U1();

        for (Item item : allItems) {
            if (currentRocket.cargo + (item.weight / 1000.0) >
                    (currentRocket.maxWeight - currentRocket.rocketWeight)) {
                U1Fleet.add(currentRocket);
                System.out.println("u1 currentRocket: " + currentRocket.cargo);
                currentRocket = new U1();
            }

            currentRocket.cargo += (item.weight / 1000.0);
        }
        return U1Fleet;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> allItems) {
        ArrayList<U2> U2Fleet = new ArrayList<>();
        U2 currentRocket = new U2();

        for (Item item : allItems) {
            if (currentRocket.cargo + (item.weight / 1000.0) >
                    (currentRocket.maxWeight - currentRocket.rocketWeight)) {
                U2Fleet.add(currentRocket);
                System.out.println("u2 currentRocket: " + currentRocket.cargo);
                currentRocket = new U2();
            }

            currentRocket.cargo += (item.weight / 1000.0);
        }
        return U2Fleet;
    }

    public int runSimulation(ArrayList<Rocket> allRockets) {
        int rocketCount = 0;

        for (Rocket rocket : allRockets) {
            boolean isLandSuccessful = rocket.land();
            boolean isLaunchSuccessful = rocket.launch();


            while (!isLandSuccessful) {
                isLandSuccessful = rocket.land();
                rocketCount += 1;
            }

            while (!isLaunchSuccessful) {
                isLaunchSuccessful = rocket.launch();
                rocketCount += 1;
            }
        }

        return rocketCount;
    }
}