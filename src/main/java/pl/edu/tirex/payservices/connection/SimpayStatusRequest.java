package pl.edu.tirex.payservices.connection;

import pl.edu.tirex.payservices.models.SimpayStatusParameters;

public class SimpayStatusRequest extends SimpayRequest<SimpayStatusParameters>
{
    public SimpayStatusRequest(SimpayStatusParameters parameters)
    {
        super(parameters);
    }
}
