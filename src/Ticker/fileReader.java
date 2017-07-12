package Ticker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class fileReader
{
    public File file = new File("C:\\Users\\Edward\\Desktop\\ProjectStockMachine\\Assign2\\Assign2\\src\\Ticker\\userStocks");
    InputStream fin;

    public void openFile() throws IOException
    {
            fin = new FileInputStream(file);
    }

    public HashMap<String, Integer> readFromFile()
    {
        HashMap<String, Integer> SharesMap = new HashMap<>();
        Scanner scr = new Scanner(fin);
        scr.useDelimiter(",");

        while(scr.hasNext())
        {
            SharesMap.put(scr.next(),scr.nextInt());
        }
        return SharesMap;
    }
}
