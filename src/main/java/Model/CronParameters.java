package Model;

import Enum.CronFieldType;
import static java.lang.String.format;

public class CronParameters {

    private CronField minutes;
    private CronField hours;
    private CronField dayOfMonth;
    private CronField month;
    private CronField dayOfWeek;
    private String command;

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

    @Override
    public String toString() {
        StringBuffer sb =new StringBuffer();
        sb.append(format("%-14s%s\n", "minute", minutes.toString()));
        sb.append(format("%-14s%s\n", "hour", hours.toString()));
        sb.append(format("%-14s%s\n", "day of month", dayOfMonth.toString()));
        sb.append(format("%-14s%s\n", "month", month.toString()));
        sb.append(format("%-14s%s\n", "day of week", dayOfWeek.toString()));
        sb.append(format("%-14s%s\n", "commmand", command));
        return sb.toString();
    }
}
