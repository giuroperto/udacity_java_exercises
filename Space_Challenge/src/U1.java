public class U1 extends Rocket {
    double chanceOfLaunchExplosion;
    double chanceOfLandExplosion;

    U1() {
        rocketWeight = 10;
        maxWeight = 18;
        rocketCost = 100;
    }

    @Override
    public boolean land() {
        chanceOfLandExplosion = 0.01 * (cargo / (maxWeight - rocketWeight));
        int randomNumber = (int) (Math.random() * 101);
        return randomNumber >= chanceOfLandExplosion * 100;
    }

    @Override
    public boolean launch() {
        chanceOfLaunchExplosion = 0.05 * (cargo / (maxWeight - rocketWeight));
        int randomNumber = (int) (Math.random() * 101);
        return randomNumber >= chanceOfLandExplosion * 100;
    }

}
