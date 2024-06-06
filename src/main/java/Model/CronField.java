package Model;

import Enum.CronFieldType;
import Parser.*;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Represents a field in a cron expression.
 * Parses and stores values based on the provided cron string.
 */
public class CronField {

    private String text;
    private CronFieldType cronFieldType;
    private Set<Integer> values = new TreeSet<>();

    /**
     * Constructs a CronField object with the specified cron string and field type.
     *
     * @param text          The cron string for this field.
     * @param cronFieldType The type of cron field (e.g., minute, hour, etc.).
     * @throws Exception If parsing the cron string fails.
     */
    public CronField(String text, CronFieldType cronFieldType) throws Exception {
        this.text = text;
        this.cronFieldType = cronFieldType;

        if(this.text.split(",").length > 1)
            values = new FixedValueParser().parseField(this.text, this.cronFieldType);
        else if(this.text.split("-").length == 2)
            values = new RangeParser().parseField(this.text, this.cronFieldType);
        else if(this.text.startsWith("*"))
            values = new IntervalParser().parseField(this.text, this.cronFieldType);

        if(values.isEmpty())
            values.add(ParserInterface.parseNumber(this.text, this.cronFieldType));
    }


    /**
     * {@inheritDoc}
     *
     * @return A space-separated list of parsed values.
     */
    @Override
    public String toString() {
        return values.stream().map(Objects::toString).collect(Collectors.joining(" "));
    }
}
