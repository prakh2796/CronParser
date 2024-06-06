package Parser;

import java.util.Set;
import java.util.TreeSet;

import Enum.CronFieldType;

public class FixedValueParser implements ParserInterface{

    /**
     * {@inheritDoc}
     *
     * Parses fields with fixed values
     */
    @Override
    public Set<Integer> parseField(String text, CronFieldType type) throws Exception {
        Set<Integer>values =new TreeSet<>();
        String[] fixedDates =text.split(",");
        if(fixedDates.length > 1) {
            for(String date : fixedDates) {
                int val = ParserInterface.parseNumber(date, type);
                values.addAll(ParserInterface.populateValues(text, val, val, 1, type));
            }
        }
        return values;
    }
}
