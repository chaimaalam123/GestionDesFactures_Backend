package net.fst.FacturePaiement.exceptions;

public class UnableToSaveEntityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnableToSaveEntityException() {
        super();

    }

    public UnableToSaveEntityException(String message) {
        super(message);

    }


}
