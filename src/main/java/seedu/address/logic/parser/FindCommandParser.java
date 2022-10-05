package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.Arrays;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.AddressMatchesInputPredicate;
import seedu.address.model.person.EmailMatchesInputPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.PhoneMatchesNumberPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_ADDRESS, PREFIX_EMAIL);

        if (!isAtLeastOnePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_PHONE, PREFIX_ADDRESS, PREFIX_EMAIL)
                || !argMultimap.getPreamble().isEmpty()
                || moreThanOnePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_PHONE, PREFIX_ADDRESS, PREFIX_EMAIL)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            String trimmedArgs = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()).fullName.trim();
            String[] nameKeywords = trimmedArgs.split("\\s+");
            return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
        }

        if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
            String phoneNumber = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()).value;
            return new FindCommand(new PhoneMatchesNumberPredicate(phoneNumber));
        }

        if (argMultimap.getValue(PREFIX_ADDRESS).isPresent()) {
            String address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get()).value;
            return new FindCommand(new AddressMatchesInputPredicate(address));
        }

        if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
            String email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()).value;
            return new FindCommand(new EmailMatchesInputPredicate(email));
        }

        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    /**
     * Checks if there is at least one of the specified prefixes is present in the argument multimap.
     *
     * @param argumentMultimap contains the tokenized arguments
     * @param prefixes to be checked
     * @return boolean to indicate if any prefix is present
     */
    boolean isAtLeastOnePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        for (Prefix prefix : prefixes) {
            if (argumentMultimap.getValue(prefix).isPresent()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is more than one of the specified prefixes present in the argument multimap.
     *
     * @param argumentMultimap contains the tokenized arguments
     * @param prefixes to be checked
     * @return boolean to indicate if more than one prefix is present
     */
    boolean moreThanOnePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        int count = 0;
        for (Prefix prefix : prefixes) {
            if (argumentMultimap.getValue(prefix).isPresent()) {
                count += 1;
            }
        }
        return count > 1;
    }

}
