package Model;

import Enum.CronFieldType;
import static java.lang.String.format;

/**
 * Represents parameters parsed from a cron expression.
 * Provides access to individual cron fields (minutes, hours, etc.) and the command.
 */
public class CronParameters {

    private CronField minutes;
    private CronField hours;
    private CronField dayOfMonth;
    private CronField month;
    private CronField dayOfWeek;
    private String command;

    /**
     * Constructs a CronParameters object by parsing the input cron string.
     *
     * @param input The complete cron string containing all fields.
     * @throws Exception If parsing the cron string fails or if the number of fields is incorrect.
     */
    public CronParameters(String input) throws Exception {
        String[]cronFields = input.split("\\s");
        if(cronFields.length != 6)
            throw new Exception("Expected 6 fields in the following order: minutes, hours, dayOfMonth, month, dayOfWeek and command");

        minutes = new CronField(cronFields[0], CronFieldType.MINUTES);
        hours = new CronField(cronFields[1], CronFieldType.HOURS);
        dayOfMonth = new CronField(cronFields[2], CronFieldType.DAY_OF_MONTH);
        month = new CronField(cronFields[3], CronFieldType.MONTH);
        dayOfWeek = new CronField(cronFields[4], CronFieldType.DAY_OF_WEEK);
        command = cronFields[5];
    }

    /**
     * {@inheritDoc}
     *
     * @return A formatted string with field names and their corresponding values.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(format("%-14s%s\n", "minute", minutes.toString()));
        sb.append(format("%-14s%s\n", "hour", hours.toString()));
        sb.append(format("%-14s%s\n", "day of month", dayOfMonth.toString()));
        sb.append(format("%-14s%s\n", "month", month.toString()));
        sb.append(format("%-14s%s\n", "day of week", dayOfWeek.toString()));
        sb.append(format("%-14s%s\n", "command", command));
        return sb.toString();
    }
}
