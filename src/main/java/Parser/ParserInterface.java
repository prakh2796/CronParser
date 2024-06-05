package Parser;

import Enum.CronFieldType;

import java.util.Set;
import java.util.TreeSet;

public interface ParserInterface {

    Set<Integer> parseField(String text, CronFieldType type)throws Exception;

    public static int parseNumber(String numString, CronFieldType type) throws Exception {
        try {
            return Integer.parseInt(numString);
        } catch (NumberFormatException nfe) {
            throw new Exception("Invalid Number");
        }
    }

    public static Set<Integer>populateValues(String text, int start, int end, int increment, CronFieldType type) throws Exception {
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
