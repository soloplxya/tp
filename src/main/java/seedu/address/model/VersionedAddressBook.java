package seedu.address.model;

import java.util.ArrayList;

public class VersionedAddressBook extends AddressBook {

    private static final ArrayList<ReadOnlyAddressBook> addressBookStateList = new ArrayList<>();
    private Integer currentStatePointer = 0;

    public VersionedAddressBook() {}

    /**
     * Creates a VersionedAddressBook using the Pets in the {@code toBeCopied}
     */
    public VersionedAddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        addressBookStateList.add(new AddressBook(toBeCopied));
    }

    /**
     * Commits a new addressBook state to the addressBookStateList
     * @param currentAddressBookState current address book state
     */
    public void commit(ReadOnlyAddressBook currentAddressBookState) {
        addressBookStateList.add(new AddressBook(currentAddressBookState));
        this.currentStatePointer = addressBookStateList.size() - 1;
    }

    /**
     * Shifts the current state pointer to the left.
     * @return The previous state of the address book.
     */
    public ReadOnlyAddressBook undo() throws Exception {
        if (addressBookStateList.size() <= 0) {
            throw new Exception("No commands to undo");
        }

        this.currentStatePointer -= 1;
        addressBookStateList.remove(this.currentStatePointer + 1);
        return addressBookStateList.get(this.currentStatePointer);
    }
}
