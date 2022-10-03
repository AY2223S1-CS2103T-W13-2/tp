package seedu.address.model.policy;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Policy's commission.
 * Guarantees: immutable; is valid as declared in {@link #isValidCommission(String)}
 */
public class Commission {

    public static final String MESSAGE_CONSTRAINTS = "Commissions should take the format of '1st yr %, 2nd yr %, "
            + " 3rd year and beyond %'  : ";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "((([1-9]\\d*)?\\d)(\\.\\d*)?%(\\s)?){3}";

    public final String value;

    public final float[] percentages;


    /**
     * Constructs an {@code Commission}.
     *
     * @param commission A valid commission.
     */
    public Commission(String commission) {
        requireNonNull(commission);
        checkArgument(isValidCommission(commission), MESSAGE_CONSTRAINTS);
        value = commission;
        percentages = parseCommission(commission);
    }

    /**
     * Returns true if a given string is a valid commission.
     */
    public static boolean isValidCommission(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Utility function to parse parseCommission from string
     * @param indicator to parseCommission from Json
     * @return the appropriate array of Commission percentages
     */
    public static float[] parseCommission(String indicator) {
        String[] commissions = indicator.split("%");
        float[] percentages = new float[commissions.length - 1];
        for (int i = 0; i < commissions.length - 1; i++) {
            percentages[i] = Float.valueOf(commissions[i]);
        }
        return percentages;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Commission // instanceof handles nulls
                && value.equals(((Commission) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
