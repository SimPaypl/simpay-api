package pl.edu.tirex.simpay.api.connection;

import com.google.gson.annotations.SerializedName;
import pl.edu.tirex.simpay.api.models.SimpayError;

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

    @Override
    public String toString()
    {
        return "SimpayRequest{" + "errors=" + errors + ", parameters=" + parameters + '}';
    }
}
