package com.pedido.pedido.ExceptionHandler;

public class DatabaseTransactionException extends RuntimeException {
    public DatabaseTransactionException(String message, Throwable cause) {
        super(message);
        super.initCause(cause);
    }
}
