public class U2 extends Rocket {
    int rocketWeight = 18;
    int maxWeight = 29;
    double chanceOfLaunchExplosion;
    double chanceOfLandExplosion;
    double cargo;

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

//    Rocket cost = $120 Million
//return either true or false based on a random number using the probability equation for each