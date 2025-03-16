package net.etfbl.clientfitnesapp.exeptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException()
    {
        super("Pogresan zahtjev.");
    }

}
