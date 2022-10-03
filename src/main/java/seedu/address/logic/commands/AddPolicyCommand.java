package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.policy.Policy;

import static java.util.Objects.requireNonNull;

import static seedu.address.logic.parser.CliSyntax.PREFIX_COMMISSION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COVERAGES;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;

public class AddPolicyCommand extends Command {
    public static final String COMMAND_WORD = "newPolicy";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a policy to the address book. "
            + "Parameters: "
            + PREFIX_TITLE + "TITLE "
            //Todo: Replace message with a command that lists out different companies
            + PREFIX_COMPANY + "'One of: {MNF, PRU, AXA, GEL, NTU, ETQ, TML, AIA, AVI, FWD}'"
            + PREFIX_COMMISSION + "Year1% Year2% Remaining%"
            + "[" + PREFIX_COVERAGES + "COVERAGE]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TITLE + "PruShield "
            + PREFIX_COMPANY + "PRU "
            + PREFIX_COMMISSION + "15% 7.5% 1% "
            //Todo: Replace message with a command that lists out different coverages
            + PREFIX_COVERAGES + "HEALTH "
            + PREFIX_COVERAGES + "LIFE";

    public static final String MESSAGE_SUCCESS = "New policy added: %1$s";
    public static final String MESSAGE_DUPLICATE_POLICY = "This policy already exists in the address book";

    private final Policy toAdd;

    /**
     * Creates an AddPolicyCommand to add the specified {@code Policy}
     *
     * @param policy
     */
    public AddPolicyCommand(Policy policy) {
        requireNonNull(policy);
        toAdd = policy;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPolicy(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_POLICY);
        }

        model.addPolicy(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddPolicyCommand // instanceof handles nulls
                && toAdd.equals(((AddPolicyCommand) other).toAdd));
    }
}
