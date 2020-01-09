package com.origamisoftware.teach.advanced;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A simple Date Range Class for magazine subscriptions
 *
 * @author Spencer A Marks
 */
public class SubscriptionPeriod {

    final static long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

    private Date startDate;
    private Date endDate;

    /**
     * Creates a  SubscriptionPeriod instance
     *
     * @param startDate the starting date of the subscription period
     * @param endDate   the end date of the subscription period
     */
    public SubscriptionPeriod(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Returns the the start date of the subscription
     *
     * @return the starting date of the subscription period
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @return the the end date of the subscription
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @return Returns the total Days in the subscription
     */
    public int getTotalDays() {
        return (int) ((endDate.getTime() - startDate.getTime()) / DAY_IN_MILLIS);
    }

    /**
     * @return the total months on the subscription
     */
    public int getTotalMonths() {
        Calendar stop = new GregorianCalendar();
        Calendar start = new GregorianCalendar();
        stop.setTime(endDate);
        start.setTime(startDate);
        int stopYear = stop.get(Calendar.YEAR);
        int startYear = start.get(Calendar.YEAR);
        int stopMonth = stop.get(Calendar.MONTH);
        int startMonth = start.get(Calendar.MONTH);
        return (stopYear - startYear) * 12 + (stopMonth - startMonth);
    }
}
