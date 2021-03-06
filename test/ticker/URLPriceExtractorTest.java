package ticker;

import Ticker.URLPriceExtractor;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.function.Function;

public class URLPriceExtractorTest 
{
    URLPriceExtractor extractor;

    @Before
    public void setUp()
    {
        extractor = new URLPriceExtractor();
    }

    @Test
    public void testValidTickerAssignedPriceIsGreaterThanZero()
    {
        assertTrue(extractor.getCurrentStockPrice("goog") > 0);
    }

    @Test
    public void testInvalidTickerPriceAssignedZero()
    {
        assertTrue(extractor.getCurrentStockPrice("appl") == 0);
    }

    @Test
    public void testInvalidURL()
    {
        try {
            extractor.connectToURL("http://ichart.finance.yahoo.com/table.csv?s=appl");
            fail();
        }
        catch (IOException e)
        {

        }
    }
}