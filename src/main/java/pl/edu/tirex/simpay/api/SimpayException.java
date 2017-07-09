package pl.edu.tirex.simpay.api;

public class SimpayException extends Exception
{
    private final int code;
    private final String name;
    private final String value;

    public SimpayException(int code, String name, String value)
    {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    @Override
    public String getMessage()
    {
        return "Status Code " + this.code + ". " + this.name + ": " + this.value;
    }
}
