package pl.edu.tirex.simpay.api.connection;

import pl.edu.tirex.simpay.api.models.SimpayStatusParameters;
import pl.edu.tirex.simpay.api.models.SimpayStatusRespond;

public class SimpayStatusResponse extends SimpayResponse<SimpayStatusRespond, SimpayStatusParameters>
{
    public SimpayStatusResponse(SimpayStatusRespond respond, SimpayStatusParameters parameters)
    {
        super(respond, parameters);
    }
}
