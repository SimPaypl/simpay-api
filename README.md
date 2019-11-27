# Simpay-Api

Example API usage:
```java
SimpayApi simpayApi = new SimpayApi("key", "secret");
try
{
    SimpayStatusResponse statusResponse = simpayApi.getStatus(1, 7055, "code");
    if (statusResponse.isSuccess())
    {
        //code is valid
        System.out.println("Code is correct");
    }
    else if (statusResponse.isUsed())
    {
        //code is used [405]
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(statusResponse.getRespond().getTimeUsed()), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        System.out.println("Code has already been used: " + formatter.format(dateTime));
    }
    else if (statusResponse.isNotFound())
    {
        //code is not found [404]
        System.out.println("Code not found");
    }
    else
    {
        //some other errors [< 200]
        SimpayError error = statusResponse.getError();
        System.out.println("Undefined error: " + error.getName() + " [" + error.getCode() + "]");
    }
}
catch (IOException e)
{
    //problem with connection
    e.printStackTrace();
}
```

# Kontakt
W razie jakicholwiek pytań w implementacji , problemów, próśb o dodanie funkcjonalności zachęcamy do kontaktu poprzez:

<kontakt@simpay.pl>
