package utility;

import java.text.DecimalFormat;

public class ConsoleHelper {

    private static long time;

    public static void printConsole(String s)
    {
        long timeNowMils = System.currentTimeMillis() - time;
        long timeNowSec = (System.currentTimeMillis() - time)/1000;

        int millis = (int)((timeNowMils%1000));
        int sec = (int)((timeNowSec%60));
        int min = (int)(timeNowSec/60);

        String millisPattern = "000";
        String secPattern = "00";

        DecimalFormat millisFormat = new DecimalFormat(millisPattern);
        DecimalFormat secFormat = new DecimalFormat(secPattern);

        String millisOutput = millisFormat.format(millis);
        String secOutput = secFormat.format(sec);

        System.out.println("[" + min + ":" + secOutput + "." + millisOutput + "] " + s);

    }

    public static void setTime()
    {
        time = System.currentTimeMillis();
    }

    public static long getTime()
    {
        return time;
    }

}
