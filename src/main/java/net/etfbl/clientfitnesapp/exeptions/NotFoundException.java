package net.etfbl.clientfitnesapp.exeptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException()
    {
        super("Resurs nije pronadjen.");
    }
}
