package HomeWork2;


import tasks.LeapYearAlgorithm;

/**
 * Created by akosatuchenko on 12/9/2014.
 */
public  class LeapYear implements LeapYearAlgorithm{
    public boolean isLeapYear(int year)
    {
        if(year == 0) {
            throw new RuntimeException("I'm sorry, but 0 is not a valid year.");
        }
        if(year <0) {
            throw new RuntimeException("I'm sorry, but Year should be positive(e.g. > 0) is not a valid year.");
        }
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }
    }

}
