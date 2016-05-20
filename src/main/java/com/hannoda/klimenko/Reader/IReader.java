package com.hannoda.klimenko.Reader;

import java.io.BufferedReader;
import java.io.IOException;

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
