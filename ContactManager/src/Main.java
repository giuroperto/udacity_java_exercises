import java.util.Scanner;

public class Main {
    static ContactsManager myContactsManager = new ContactsManager();
    static Scanner scanner = new Scanner(System.in);
    static boolean showMenu = true;

    public static void main(String[] args) {

        while (showMenu) {
            showMenu();
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("-------------------------------------------");
        System.out.println("-----------------CONTACTS------------------");
        System.out.println("-------------------------------------------");
        System.out.println("Please choose one of the following:");
        System.out.println("Press 1 + ENTER to add a new contact");
        System.out.println("Press 2 + ENTER to search a contact");
        System.out.println("Press 3 + ENTER to exit");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1 -> addNewContact();
            case 2 -> searchContact();
            case 3 -> exitProgram();
            default -> System.out.println("Invalid option");
        }
    }

    private static void exitProgram() {
        System.out.println("Exiting...");
        showMenu = false;
    }

    private static void addNewContact() {
        System.out.println("What's your contact's name?");
        String name = scanner.nextLine();

        System.out.println("And what's your contact's phone?");
        String phone = scanner.nextLine();

        Contact newContact = new Contact(name, phone);
        myContactsManager.addContact(newContact);

        System.out.println("Added " + name + "'s contact! Phone: " + phone);
        goBackToMenuOrExit();
    }

    private static void searchContact() {
        System.out.println("What name you'd like to search for?");
        String name = scanner.nextLine();
        Contact searchedContact = myContactsManager.searchContact(name);
        System.out.println("====================================");
        System.out.println(name + "'s phone is: " + searchedContact.phoneNumber);
        System.out.println("====================================");
        goBackToMenuOrExit();
    }

    private static void goBackToMenuOrExit() {
        System.out.println("To exit, press 0");
        System.out.println("To continue adding or searching, press 1");

        int response = scanner.nextInt();
        scanner.nextLine();

        switch (response) {
            case 0 -> exitProgram();
            case 1 -> showMenu();
            default -> System.out.println("Invalid option!");
        }
    }
}
