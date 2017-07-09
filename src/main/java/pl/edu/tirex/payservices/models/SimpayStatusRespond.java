package pl.edu.tirex.payservices.models;

import com.google.gson.annotations.SerializedName;

public class SimpayStatusRespond
{
    private final String code;
    private final String status;
    private final boolean test;

    @SerializedName("time_used")
    private final long timeUsed;

    public SimpayStatusRespond(String code, String status, boolean test, long timeUsed)
    {
        this.code = code;
        this.status = status;
        this.test = test;
        this.timeUsed = timeUsed;
    }

    public String getCode()
    {
        return code;
    }

    public String getStatus()
    {
        return status;
    }

    public boolean isTest()
    {
        return test;
    }

    public long getTimeUsed()
    {
        return timeUsed;
    }
}
