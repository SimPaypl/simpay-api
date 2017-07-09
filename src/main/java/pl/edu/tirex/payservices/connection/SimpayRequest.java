package pl.edu.tirex.payservices.connection;

import com.google.gson.annotations.SerializedName;
import pl.edu.tirex.payservices.models.SimpayError;

import java.util.ArrayList;
import java.util.List;

public class SimpayRequest<P>
{
    @SerializedName("error")
    private final List<SimpayError> errors = new ArrayList<>();

    @SerializedName("params")
    private P parameters;

    public SimpayRequest(P parameters)
    {
        this.parameters = parameters;
    }

    public P getParameters()
    {
        return parameters;
    }

    public void setParameters(P parameters)
    {
        this.parameters = parameters;
    }

    public List<SimpayError> getErrors()
    {
        return errors;
    }
}
