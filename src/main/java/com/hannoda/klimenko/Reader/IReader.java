package com.hannoda.klimenko.Reader;



/**
 * Provides reading
 */
public interface IReader {
    /**
     * Reading
     *
     * @param s
     * @return
     * @throws ReaderException
     */
    char read(String s) throws ReaderException;
}
