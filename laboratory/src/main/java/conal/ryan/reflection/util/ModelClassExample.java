package conal.ryan.reflection.util;

import org.joda.time.DateTime;

/**
 * Created by Conal on 4/10/2015.
 */
public class ModelClassExample {

    private String aString;
    private int aInt;
    private boolean aBoolean;
    private DateTime aDateTime;

    public ModelClassExample(String aString, int aInt, boolean aBoolean, DateTime aDateTime) {
        this.aString = aString;
        this.aInt = aInt;
        this.aBoolean = aBoolean;
        this.aDateTime = aDateTime;
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public int getaInt() {
        return aInt;
    }

    public void setaInt(int aInt) {
        this.aInt = aInt;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public DateTime getaDateTime() {
        return aDateTime;
    }

    public void setaDateTime(DateTime aDateTime) {
        this.aDateTime = aDateTime;
    }
}
