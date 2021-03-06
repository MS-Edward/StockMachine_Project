package Ticker;

import java.util.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import java.util.function.Function;

public class TickerCalculator
{
    public double calculateValue(double tickerPrice, int numShares)
    {
        return tickerPrice * numShares;
    }

    public double calculateNetAssestValue(List<Double> values)
    {
        return values.stream()
                     .mapToDouble(e -> e)
                     .sum();
    }

    public Map<String, Double> computeValueAndNet(Map<String, Integer> shares, Function<String, Double> priceFinder )
    {

       Map<String, Double> shareValues =
         shares.keySet()
               .stream()
               .collect(toMap(ticker -> ticker,
                ticker -> calculateValue(priceFinder.apply(ticker), shares.get(ticker))));
      
      double net = 
        calculateNetAssestValue(shareValues.values()
                                           .stream()
                                           .collect(toList()));
      shareValues.put("Net Asset", net);
      return shareValues;

    }
}
