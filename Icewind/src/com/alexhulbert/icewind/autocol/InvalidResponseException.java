package com.alexhulbert.icewind.autocol;

/**
 *
 * @author Taconut
 */
public class InvalidResponseException extends Exception {

    /**
     * If this exception is linked to another Exception, it's logged here
     */
    public Exception source;
    
    /**
     * Creates a new instance of <code>BadResponseException</code> without
     * detail message.
     */
    public InvalidResponseException() {}

    /**
     * Constructs an instance of <code>BadResponseException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidResponseException(String msg) {
        super(msg);
    }
    
    /**
     * Constructs an instance of <code>BadResponseException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     * @param src another exception linked to this one
     */
    public InvalidResponseException(String msg, Exception src) {
        super(msg);
        source = src;
    }
}
