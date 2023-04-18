package app.domain.model;

/**
 * It represents the opening and closing hours of the vaccination center
 */
public class WorkingHour implements Comparable <WorkingHour> {

    private int hours;
    private int minutes;

    /**
     * Working hour full constructor
     * @param hours
     * @param minutes
     */

    public WorkingHour(int hours, int minutes){
        setHours(hours);
        setMinutes(minutes);
    }

    /**
     * Method to get hours
     * @return hours
     */

    public int getHours() {
        return hours;
    }

    /**
     * Method to get minutes
     * @return minutes
     */

    public int getMinutes() {
        return minutes;
    }

    /**
     * Method to change and/or validate hours
     * if hours are less than 0 or greater than 23 throws an exception
     * @param hours
     */

    public void setHours(int hours) {
        if (hours < 0 || hours>23) {
            throw new IllegalArgumentException ("Not valid hour");
        }
        this.hours = hours;
    }

    /**
     * Method to change and/or validate minutes
     * if minutes less than 0 or greater than 59 throws an exception
     * @param minutes
     */

    public void setMinutes(int minutes) {
        if(minutes<0 || minutes>59 ) {
            throw new IllegalArgumentException ("Not valid minutes");
        }
        this.minutes = minutes;
    }

    /**
     * It obtains in text format the information of working hours
     *@return Textual and visible representation of hours
     *
     */

    public String toString () {
        return String.format("%d : %d ", hours, minutes);
    }

    /**
     * Conversion of working hours in seconds
     * @return seconds
     */

    private int toSeconds () {

        return this.hours*3600 + this.minutes*60;
    }

    /**
     * Method to compare different working hours
     * @param otherWorkingHour
     * @return -1 if the time to be compared is less than the other,  1 if it is higher than the other hour and 0 if they are equal.
     */

    @Override
    public int compareTo(WorkingHour otherWorkingHour) {
        return otherWorkingHour.isLaterTime(this) ? -1 : (this.isLaterTime(otherWorkingHour) ?1 : 0);
    }

    /**
     * Method to compare different working hours
     * @param otherWorkingHour
     * @return the time to compare is bigger than the other one
     */


    public boolean isLaterTime (WorkingHour otherWorkingHour) {
        return this.toSeconds() > otherWorkingHour.toSeconds();
    }


}

