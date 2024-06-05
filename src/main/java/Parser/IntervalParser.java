package Parser;

import java.util.Set;

import Enum.CronFieldType;

public class IntervalParser implements ParserInterface{
    @Override
    public Set<Integer> parseField(String text, CronFieldType type) throws Exception {
        int interval = 1;
        String[] intervals = text.split("/");
        if(intervals.length > 2)
            throw new Exception("Number has too many intervals");
        if(intervals.length == 2)
            interval = ParserInterface.parseNumber(intervals[1], type);
        return ParserInterface.populateValues(text, type.min, type.max, interval, type);
    }
}
