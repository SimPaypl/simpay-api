package pl.edu.tirex.simpay.api.connection;

import com.google.gson.annotations.SerializedName;
import pl.edu.tirex.simpay.api.models.SimpayError;

import java.util.ArrayList;
import java.util.List;

public class SimpayResponse<R, P>
{
    @SerializedName("error")
    private final List<SimpayError> errors = new ArrayList<>();

    @SerializedName("params")
    private P parameters;

    private R respond;

    public SimpayResponse(R respond, P parameters)
    {
        this.respond = respond;
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

    public R getRespond()
    {
        return respond;
    }

    public void setRespond(R respond)
    {
        this.respond = respond;
    }

    public List<SimpayError> getErrors()
    {
        return errors;
    }

    @Override
    public String toString()
    {
        return "SimpayResponse{" + "errors=" + errors + ", parameters=" + parameters + ", respond=" + respond + '}';
    }
}
