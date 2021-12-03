public class Person {
    public static int instanceCounter;
    public int localCounter;

    Person() {
        instanceCounter++;
        localCounter++;
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();

        System.out.println("(" + p4.localCounter + "," + Person.instanceCounter + ")");
    }
}