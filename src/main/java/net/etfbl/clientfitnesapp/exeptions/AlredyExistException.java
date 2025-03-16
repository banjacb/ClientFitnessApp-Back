package net.etfbl.clientfitnesapp.exeptions;

public class AlredyExistException extends RuntimeException{
    public  AlredyExistException()
    {
        super("Podaci vec postoje.");
    }
}
