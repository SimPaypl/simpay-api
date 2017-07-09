package pl.edu.tirex.payservices.connection;

import pl.edu.tirex.payservices.models.SimpayStatusParameters;
import pl.edu.tirex.payservices.models.SimpayStatusRespond;

public class SimpayStatusResponse extends SimpayResponse<SimpayStatusRespond, SimpayStatusParameters>
{
    public SimpayStatusResponse(SimpayStatusRespond respond, SimpayStatusParameters parameters)
    {
        super(respond, parameters);
    }
}
