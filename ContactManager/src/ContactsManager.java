public class ContactsManager {
    Contact[] myContacts;
    int contactsCount;

    ContactsManager() {
        this.contactsCount = 0;
        this.myContacts = new Contact[500];
    }

    void addContact(Contact contact) {
        myContacts[contactsCount] = contact;
        contactsCount++;
    }

    Contact searchContact(String name) {
        for (int i = 0; i < contactsCount; i++) {
            if (myContacts[i].name.equals(name)) {
                return myContacts[i];
            }
        }
        return null;
    }
}
