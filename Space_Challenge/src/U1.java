public class U1 extends Rocket {
    int rocketWeight = 10;
    int maxWeight = 18;
    double chanceOfLaunchExplosion;
    double chanceOfLandExplosion;

    @Override
    public boolean land() {
        chanceOfLandExplosion = 0.01 * (cargo / (maxWeight - rocketWeight));
        return super.land();
    }

    @Override
    public boolean launch() {
        chanceOfLaunchExplosion = 0.05 * (cargo / (maxWeight - rocketWeight));
        return super.launch();
    }

}


//    Rocket cost = $100 Million
//return either true or false based on a random number using the probability equation for each