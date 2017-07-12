package ticker;

import Ticker.TickerCalculator;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TickerCalculatorTest {

    TickerCalculator ticker;

    @Before
    public void setUp()
    {
        ticker = new TickerCalculator();
    }

    @Test
    public void testCanary()
    {
        assertTrue(true);
    }

    @Test
    public void TestTotalAssetCalculation()
    {
        assertEquals(1000.0, ticker.calculateValue(100.0, 10), .0001);
    }

    @Test
    public void testCalculateNetAssetValue()
    {

        List<Double> values = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        assertEquals(15, ticker.calculateNetAssestValue(values), .0001);
    }

    @Test
    public void TestComputeStockValuesAndNetAsset()
    {
        Function<String, Double> fakePrice = symbol -> 10.00;

        Map<String, Integer> shares = new HashMap<>();
        shares.put("GOOG", 12);
        shares.put("AMZN", 10);
        shares.put("EBAY", 9);
        shares.put("MSFT", 8);

        Map<String, Double> checkhashmap = new HashMap<>();
        checkhashmap.put("GOOG", 120.0);
        checkhashmap.put("AMZN", 100.0);
        checkhashmap.put("EBAY", 90.0);
        checkhashmap.put("MSFT", 80.0);
        checkhashmap.put("Net Asset", 390.0);

        assertEquals(checkhashmap, ticker.computeValueAndNet(shares, fakePrice));
    }

    @Test
    public void TestInvalidStocksComputeValuesAndNetAsset()
    {
        Function<String, Double> invalidStockPrice = symbol -> 0.0;

        HashMap<String, Integer> shares = new HashMap<>();
        shares.put("InvalidStock1", 12);
        shares.put("InvalidStock2", 10);
        shares.put("InvalidStock3", 9);
        shares.put("InvalidStock4", 8);

        HashMap<String, Double> checkhashmap = new HashMap<>();
        checkhashmap.put("InvalidStock1", 0.0);
        checkhashmap.put("InvalidStock2", 0.0);
        checkhashmap.put("InvalidStock3", 0.0);
        checkhashmap.put("InvalidStock4", 0.0);
        checkhashmap.put("Net Asset", 0.0);

        assertEquals(checkhashmap, ticker.computeValueAndNet(shares, invalidStockPrice));
    }
}