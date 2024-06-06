package Parser;

import Enum.CronFieldType;

import java.util.Set;
import java.util.TreeSet;

/**
 * Represents an interface for parsing cron fields.
 * Provides methods to parse and manipulate cron values.
 */
public interface ParserInterface {

    /**
     * Parses the cron field represented by the given text.
     *
     * @param text The cron string for this field.
     * @param type The type of cron field (e.g., minutes, hours, etc.).
     * @return A set of parsed integer values.
     * @throws Exception If parsing the cron string fails.
     */
    Set<Integer> parseField(String text, CronFieldType type) throws Exception;

    /**
     * Parses a numeric string into an integer.
     *
     * @param numString The numeric string to parse.
     * @param type      The type of cron field (e.g., minutes, hours, etc.).
     * @return The parsed integer value.
     * @throws Exception If parsing the numeric string fails.
     */
    static int parseNumber(String numString, CronFieldType type) throws Exception {
        try {
            return Integer.parseInt(numString);
        } catch (NumberFormatException nfe) {
            throw new Exception("Invalid Number");
        }
    }

    /**
     * Populates a set of values within the specified range and increment.
     *
     * @param text      The cron string for this field.
     * @param start     The starting value of the range.
     * @param end       The ending value of the range.
     * @param increment The increment value.
     * @param type      The type of cron field (e.g., minutes, hours, etc.).
     * @return A set of populated integer values.
     * @throws Exception If the interval is invalid or outside the range.
     */
    static Set<Integer>populateValues(String text, int start, int end, int increment, CronFieldType type) throws Exception {
        Set<Integer> values =new TreeSet<>();

        if(increment == 0)
            throw new Exception("Interval is 0");
        if(end < start)
            throw new Exception("Number ends before it starts");
        if(start < type.min || end > type.max)
            throw new Exception("Number is outside the range");

        for(int i = start; i <= end; i += increment)
            values.add(i);

        return values;
    }
}
