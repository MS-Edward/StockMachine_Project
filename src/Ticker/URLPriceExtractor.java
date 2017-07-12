package Ticker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Function;

public class URLPriceExtractor
{
    public double getCurrentStockPrice(String stockSymbol)
    {
        try
        {
            String buffer = connectToURL(stockSymbol);
            return parser(buffer);
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public String connectToURL(String stockSymbol) throws IOException
    {
        String csvURL = "http://ichart.finance.yahoo.com/table.csv?s=" + stockSymbol;
        String buffer;

            InputStream input = new URL(csvURL).openStream();
            Scanner fileReader = new Scanner(input);
            buffer = fileReader.nextLine();
            buffer = fileReader.nextLine();
            return buffer;


    }

    private double parser(String buffer)
    {
        Scanner stringReader = new Scanner(buffer);

            String ignore;
            stringReader.useDelimiter(",");

            for (int i = 0; i < 6; i++) {
                ignore = stringReader.next();
            }
            return stringReader.nextDouble();
    }
}
