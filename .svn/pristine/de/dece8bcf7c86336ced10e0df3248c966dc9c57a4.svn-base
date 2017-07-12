package ticker;

import Ticker.fileReader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.io.IOException;
import java.util.HashMap;
import static org.junit.Assert.*;

public class fileReaderTest {

    fileReader reader;

    @Before
    public void setUp()
    {
        reader = new fileReader();
    }

    @Test
    public void testFileOpening()
    {
        try
        {
            reader.openFile();
        }
        catch(IOException e)
        {
           e.printStackTrace();
        }
    }

    @Test
    public void testCheckIfFIleDataWasStoredInHash()
    {
        try
        {
            reader.openFile();

            HashMap<String, Integer> shares = reader.readFromFile();
            HashMap<String, Integer> check  = new HashMap<>();
            check.put("GOOG", 10);

            assertEquals(shares.get("GOOG"),check.get("GOOG"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}