package pl.edu.tirex.simpay.api.connection;

import pl.edu.tirex.simpay.api.models.SimpayStatusParameters;

public class SimpayStatusRequest extends SimpayRequest<SimpayStatusParameters>
{
    public SimpayStatusRequest(SimpayStatusParameters parameters)
    {
        super(parameters);
    }
}
