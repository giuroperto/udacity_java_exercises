public class U2 extends Rocket {
    int rocketWeight = 18;
    int maxWeight = 29;
    double chanceOfLaunchExplosion;
    double chanceOfLandExplosion;

    @Override
    public boolean land() {
        chanceOfLandExplosion = 0.08 * (cargo / (maxWeight - rocketWeight));
        return super.land();
    }

    @Override
    public boolean launch() {
        chanceOfLaunchExplosion = 0.04 * (cargo / (maxWeight - rocketWeight));
        return super.launch();
    }
}

//    Rocket cost = $120 Million
//return either true or false based on a random number using the probability equation for each