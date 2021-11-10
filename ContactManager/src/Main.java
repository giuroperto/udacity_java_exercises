import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactsManager myContactsManager = new ContactsManager();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write your friend's name");
        String name = scanner.nextLine();
        System.out.println(name);

        Contact myFriend1 = new Contact(name, "123456789");
        myContactsManager.addContact(myFriend1);

        Contact myFriend2 = new Contact("Nelly", "123456788");
        myContactsManager.addContact(myFriend2);

        Contact myFriend3 = new Contact("Sally", "123456787");
        myContactsManager.addContact(myFriend3);

        Contact myFriend4 = new Contact("Shelly", "123456786");
        myContactsManager.addContact(myFriend4);

        Contact myFriend5 = new Contact("Wally", "123456785");
        myContactsManager.addContact(myFriend5);

        Contact searchedContact = myContactsManager.searchContact(name);
        System.out.println(searchedContact.phoneNumber);
    }
}
