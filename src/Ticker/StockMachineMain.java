package Ticker;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Function;

public class StockMachineMain
{
    public static void main(String[] args)
    {
        TickerCalculator tickerMachine = new TickerCalculator();
        URLPriceExtractor extractor = new URLPriceExtractor();
        fileReader reader = new fileReader();

        try
        {
            reader.openFile();
            HashMap<String, Integer> SharesMap = reader.readFromFile();
            Function<String, Double> priceExtractor = e -> {return extractor.getCurrentStockPrice(e);};
            System.out.println(tickerMachine.computeValueAndNet(SharesMap, priceExtractor));
            System.out.println(SharesMap);
        }
        catch(IOException e)
        {
            System.out.println("File could not be located.");
        }
    }
}
