package longtimenosee.model.person;

import java.util.Comparator;

/**
 *  Encapsulation for a client's RiskAppetite
 */
public class RiskAppetite {

    public static final Comparator<Person> RISK_APPETITE_COMPARATOR = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            RiskLevel RA1 = p1.getRiskAppetite().getRiskLevel();
            RiskLevel RA2 = p2.getRiskAppetite().getRiskLevel();
            if (RA1 == RA2) {
                return 0;
            } else if (RA1 == RiskLevel.HIGH && (RA2 == RiskLevel.LOW || RA2 == RiskLevel.MEDIUM)) {
                return 1;
            } else if (RA1 == RiskLevel.MEDIUM && RA2 == RiskLevel.LOW) {
                return 1;
            } else if (RA2 == RiskLevel.HIGH && (RA1 == RiskLevel.LOW || RA1 == RiskLevel.MEDIUM)) {
                return -1;
            } else {
                return -1;
            }
        }
    };
    public static final String MESSAGE_FORMAT_CONSTRAINTS = "Error: RiskAppetite must be one "
            + "of the following indicators: "
            + "{H, M, L}";
    public static final String SORT_RISK_APPETITE = "risk appetite";

    public final String value;

    private final RiskLevel rl;

    /**
     * Enumerator representing RiskLevel.
     * Encapsulates 3 different categories, High, Medium and Low risk.
     * Tagged with messages to be represented in String format.
     */

    public enum RiskLevel {
        HIGH("High"), MEDIUM("Medium"), LOW("Low");

        private String message;

        RiskLevel(String message) {
            this.message = message;
        }
        @Override
        public String toString() {
            return message;
        }
    }
    /**
     * Default constructor.
     * @param riskLevel
     */
    public RiskAppetite(String riskLevel) {
        value = riskLevel;
        rl = parseRiskLevel(riskLevel);
    }

    public RiskLevel getRiskLevel() {
        return this.rl;
    }


    public static boolean isValidFormat(String ra) {
        return MESSAGE_FORMAT_CONSTRAINTS.contains(ra);
    }

    /**
     * Utility function to parse risklevel from string
     * @param indicator to parseRiskLevel from Json
     * @return the appropriate risklevel wrapped in an enum
     */
    public static RiskLevel parseRiskLevel(String indicator) {
        switch (indicator) {
        case "H":
            return RiskLevel.HIGH;
        case "M":
            return RiskLevel.MEDIUM;
        case "L":
            return RiskLevel.LOW;

        default:
            return RiskLevel.MEDIUM;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof RiskAppetite)) {
            return false;
        }

        RiskAppetite otherRA = (RiskAppetite) other;
        boolean isSameRA = this.getRiskLevel() == otherRA.getRiskLevel();
        return isSameRA;
    }

    @Override
    public String toString() {
        return rl.toString();
    }

}
