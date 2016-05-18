package com.hannoda.klimenko.Reader;

import java.io.BufferedReader;
import java.io.IOException;

/**

 */
public interface IReader {

    char read(String s) throws IOException;

    void close();
}
