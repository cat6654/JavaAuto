package HomeWork2;

import java.util.Date;

/**
 * Created by akosatuchenko on 12/9/2014.
 */
public  class LeapYear {
    public static boolean isLeapYear(int year)
    {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }
    }

}
