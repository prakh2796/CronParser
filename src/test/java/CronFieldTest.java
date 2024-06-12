import Model.CronField;
import Enum.CronFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class CronFieldTest {

    @Test
    public void validateFields() throws Exception {
        // Range Field
        CronField cronField = new CronField("1-5", CronFieldType.DAY_OF_MONTH);
        assertEquals("1 2 3 4 5", cronField.toString());

        // Fixed Field
        cronField = new CronField("22", CronFieldType.HOURS);
        assertEquals("22", cronField.toString());

        // Inerval Field
        cronField = new CronField("*/10", CronFieldType.DAY_OF_MONTH);
        assertEquals("1 11 21 31", cronField.toString());

        // Incorrect Field
        tryParse("*/0", CronFieldType.DAY_OF_MONTH, "Interval is 0");
    }

    private void tryParse(String inputText, CronFieldType type, String message) {
        try {
            new CronField(inputText, type);
            fail(inputText + "should not be a valid" + type);
        } catch (Exception exception) {
            assertTrue(exception.getMessage().contains(message));
        }
    }
}
