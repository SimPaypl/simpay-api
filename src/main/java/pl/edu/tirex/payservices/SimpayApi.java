package pl.edu.tirex.payservices;

public class SimpayApi
{
    private static final int SIMPAY_API_VERSION = 1;
    private final String key;
    private final String secret;
    private final int version;

    public SimpayApi(String key, String secret)
    {
        this(key, secret, SIMPAY_API_VERSION);
    }

    public SimpayApi(String key, String secret, int version)
    {
        this.key = key;
        this.secret = secret;
        this.version = version;
    }

    public String getKey()
    {
        return key;
    }

    public String getSecret()
    {
        return secret;
    }

    public int getVersion()
    {
        return version;
    }


}
