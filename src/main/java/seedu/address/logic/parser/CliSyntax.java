package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_OWNER_NAME = new Prefix("o/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_DIET = new Prefix("d/");
    public static final Prefix PREFIX_DATE = new Prefix("date/");
    public static final Prefix PREFIX_DROPOFF = new Prefix("do/");
    public static final Prefix PREFIX_PICKUP = new Prefix("pu/");
    public static final Prefix PREFIX_ATTENDANCE_DATE = new Prefix("att/");
    public static final Prefix PREFIX_APPOINTMENT_DATE_TIME = new Prefix("dt/");
    public static final Prefix PREFIX_APPOINTMENT_LOCATION = new Prefix("at/");
    public static final Prefix PREFIX_CLEAR = new Prefix("clear");
    public static final Prefix PREFIX_CHARGE_MONTH_YEAR = new Prefix("m/");
    public static final Prefix PREFIX_CHARGE = new Prefix("c/");

    /* Valid parameters for sort command */
    public static final String SORT_BY_NAME = "name";
    public static final String SORT_BY_OWNER = "owner";
    public static final String SORT_BY_APPOINTMENT = "app";

}
