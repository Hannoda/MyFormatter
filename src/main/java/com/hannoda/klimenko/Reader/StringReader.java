package com.hannoda.klimenko.Reader;

import java.io.*;


/**
 * Provides reading first character of the String
 */
public  class StringReader implements IReader {

    private char ch;
    private int index = 0;

    /**
     * reading first character of the String s
     * @param s
     * @return
     * @throws IOException
     */
    public char read(String s)throws IOException {

        java.io.StringReader input = new java.io.StringReader(s);

        if ((input.read()) != -1) {
            input.reset();
        input.skip((long) index);
        this.ch = (char)input.read();

        input.mark(index);
        setIndex(index + 1);
    } else  close();
    return this.ch;
    }


    /**
     * Field values ​​to the initial state
     */
    public void close() {
        index=0;
        this.ch = '\u0000';

    }

    /**
     * Gets the value of index
     * @return value of index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of index
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }
}
