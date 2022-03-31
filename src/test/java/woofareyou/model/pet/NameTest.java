package woofareyou.model.pet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import woofareyou.testutil.Assert;

public class NameTest {
    public static final String PET_NAME_1 = "MOJO";
    public static final String PET_NAME_2 = "PIKA";
    public static final String PET_NAME_3 = "APPLE";
    public static final String PET_NAME_4 = "APPO";

    @Test
    public void constructor_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> new Name(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        Assert.assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
    }

    @Test
    public void isValidName() {
        // null name
        Assert.assertThrows(NullPointerException.class, () -> Name.isValidName(null));

        // invalid name
        assertFalse(Name.isValidName("")); // empty string
        assertFalse(Name.isValidName(" ")); // spaces only
        assertFalse(Name.isValidName("^")); // only non-alphanumeric characters
        assertFalse(Name.isValidName("peter*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(Name.isValidName("peter jack")); // alphabets only
        assertTrue(Name.isValidName("12345")); // numbers only
        assertTrue(Name.isValidName("peter the 2nd")); // alphanumeric characters
        assertTrue(Name.isValidName("Capital Tan")); // with capital letters
        assertTrue(Name.isValidName("David Roger Jackson Ray Jr 2nd")); // long names
    }

    @Test
    public void compareTo() {

        assertTrue(PET_NAME_1.compareTo(PET_NAME_1) == 0);
        assertTrue(PET_NAME_2.compareTo(PET_NAME_2) == 0);
        assertTrue(PET_NAME_3.compareTo(PET_NAME_3) == 0);

        assertTrue(PET_NAME_1.compareTo(PET_NAME_2) < 0);
        assertTrue(PET_NAME_2.compareTo(PET_NAME_3) > 0);
        assertTrue(PET_NAME_3.compareTo(PET_NAME_1) < 0);

        assertFalse(PET_NAME_1.compareTo(PET_NAME_2) > 0);
        assertFalse(PET_NAME_2.compareTo(PET_NAME_3) < 0);
        assertFalse(PET_NAME_3.compareTo(PET_NAME_1) > 0);

        assertFalse(PET_NAME_4.compareTo(PET_NAME_3) == 0);
        assertTrue(PET_NAME_4.compareTo(PET_NAME_3) > 0);
        assertTrue(PET_NAME_3.compareTo(PET_NAME_4) < 0);
    }
}
