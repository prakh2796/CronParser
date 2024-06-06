package Parser;

import java.util.Set;
import java.util.TreeSet;

import Enum.CronFieldType;

public class RangeParser implements ParserInterface{

    /**
     * {@inheritDoc}
     *
     * Parses fields with range values
     */
    @Override
    public Set<Integer> parseField(String text, CronFieldType type) throws Exception {
        Set<Integer> values = new TreeSet<>();
        String[] range = text.split("-");
        if(range.length == 2) {
            int start = ParserInterface.parseNumber(range[0], type);
            int end = ParserInterface.parseNumber(range[1], type);
            values.addAll(ParserInterface.populateValues(text, start, end, 1, type));
        }
        return values;
    }
}
