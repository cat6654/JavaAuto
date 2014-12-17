package HomeWork2;

import tasks.LeapYearAlgorithm;

import java.util.Date;

/**
 * Created by akosatuchenko on 12/9/2014.
 */
public  class LeapYear implements LeapYearAlgorithm{
    public boolean isLeapYear(int year)
    {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }
    }

}
