package com.hannoda.klimenko.Reader;

import java.io.*;

/**
 * Created by hanno on 16.05.2016.
 */
public  class StringReader implements IReader {

    private char ch;
    private int index = 0;


    /**
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
     *
     */
    public void close() {
        index=0;
        this.ch = '\u0000';

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
