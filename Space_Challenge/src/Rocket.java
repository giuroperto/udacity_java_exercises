public class Rocket implements Spaceship {
    int rocketWeight;
    int maxWeight;
    int rocketCost;
    double cargo;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (rocketWeight + cargo + item.weight <= maxWeight);
    }

    @Override
    public void carry(Item item) {
        cargo += item.weight;
    }
}
