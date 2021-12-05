public class U1 extends Rocket {
    int rocketWeight = 10;
    int maxWeight = 18;
    double chanceOfLaunchExplosion;
    double chanceOfLandExplosion;
    double cargo;

    @Override
    public boolean land() {
        chanceOfLandExplosion = 0.01 * (cargo / (maxWeight - rocketWeight));
        int randomNumber = (int) (Math.random() * 101);
        return randomNumber <= chanceOfLandExplosion * 100;
    }

    @Override
    public boolean launch() {
        chanceOfLaunchExplosion = 0.05 * (cargo / (maxWeight - rocketWeight));
        int randomNumber = (int) (Math.random() * 101);
        return randomNumber <= chanceOfLandExplosion * 100;
    }

}


//    Rocket cost = $100 Million
//return either true or false based on a random number using the probability equation for each