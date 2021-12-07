public class U2 extends Rocket {
    double chanceOfLaunchExplosion;
    double chanceOfLandExplosion;

    U2() {
        rocketWeight = 18;
        maxWeight = 29;
        rocketCost = 120;
    }

    @Override
    public boolean land() {
        chanceOfLandExplosion = 0.08 * (cargo / (maxWeight - rocketWeight));
        int randomNumber = (int) (Math.random() * 101);
        return randomNumber >= chanceOfLandExplosion * 100;
    }

    @Override
    public boolean launch() {
        chanceOfLaunchExplosion = 0.04 * (cargo / (maxWeight - rocketWeight));
        int randomNumber = (int) (Math.random() * 101);
        return randomNumber >= chanceOfLandExplosion * 100;
    }
}
