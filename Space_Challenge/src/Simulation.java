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
            System.out.println("currentRocket: " + currentRocket.cargo);
            if (currentRocket.cargo < (currentRocket.maxWeight - currentRocket.rocketWeight) &&
                    currentRocket.cargo + (item.weight / 1000.0) <=
                            (currentRocket.maxWeight - currentRocket.rocketWeight)) {
                currentRocket.cargo += (item.weight / 1000.0);
            } else {
                U1Fleet.add(currentRocket);
                currentRocket = new U1();
                currentRocket.cargo += (item.weight / 1000.0);
            }
        }

        return U1Fleet;
    }

//    public U1 createU1Rocket() {
//
//    }
}

//        It first tries to fill up 1 rocket with as many items as possible before creating a
//        new rocket object and filling that one until all items are loaded.
//        The method then returns the ArrayList of those U1 rockets that are fully loaded.
