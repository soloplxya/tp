package seedu.address.model.pet.comparator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Optional;

import seedu.address.model.attendance.AttendanceEntry;
import seedu.address.model.pet.Pet;

/**
 * Comparator class to compare pets based on pet's Pick Up Time.
 */
public class PetPickUpTimeComparator implements Comparator<Pet> {
    private LocalDate today = LocalDate.now();

    /**
     * Compares pet objects based on their pick up time attribute.
     * @param first Pet to be compared with.
     * @param second Pet to be compared with.
     * @return Value signifying in the difference between the comparing attribute.
     */
    @Override
    public int compare(Pet first, Pet second) {
        Optional<AttendanceEntry> firstAttendanceEntry = first.getAttendanceHashMap().getAttendance(today);
        Optional<AttendanceEntry> secondAttendanceEntry = second.getAttendanceHashMap().getAttendance(today);

        if (firstAttendanceEntry.isPresent() && secondAttendanceEntry.isPresent()) {
            return compareAttendanceEntries(firstAttendanceEntry, secondAttendanceEntry);
        } else if (firstAttendanceEntry.isPresent() && !secondAttendanceEntry.isPresent()) {
            return -1;
        } else if (!firstAttendanceEntry.isPresent() && secondAttendanceEntry.isPresent()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Compares AttendanceEntries of pets based on their pick up time. Used in compare method.
     * @param firstPet AttendanceEntry.
     * @param secondPet AttendanceEntry.
     * @return Value signifying in the difference between the comparing attribute.
     */
    private int compareAttendanceEntries(Optional<AttendanceEntry> firstPet, Optional<AttendanceEntry> secondPet) {
        AttendanceEntry firstPetAttendanceEntry = firstPet.get();
        AttendanceEntry secondPetAttendanceEntry = secondPet.get();

        boolean isFirstPetPickUpPresent = firstPetAttendanceEntry.hasTransportArrangement();
        boolean isSecondPetPickUpTimePresent = secondPetAttendanceEntry.hasTransportArrangement();

        if (isFirstPetPickUpPresent && isSecondPetPickUpTimePresent) {
            LocalTime firstDropOffTime = firstPetAttendanceEntry.getPickUpTime().get();
            LocalTime secondDropOffTime = secondPetAttendanceEntry.getPickUpTime().get();
            return firstDropOffTime.compareTo(secondDropOffTime);
        } else if (isFirstPetPickUpPresent && !isSecondPetPickUpTimePresent) {
            return -1;
        } else if (!isFirstPetPickUpPresent && isSecondPetPickUpTimePresent) {
            return 1;
        } else {
            return 0;
        }
    }
}
