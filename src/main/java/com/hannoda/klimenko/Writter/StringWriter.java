package com.hannoda.klimenko.Writter;

import com.hannoda.klimenko.Writter.IWriter;

/**
 * Provides writing character of the string
 */
public class StringWriter implements IWriter {

    /**
     *Writing character of the string and output on the console
     * @param s
     */
    public void write(String s) {

        java.io.StringWriter output = new java.io.StringWriter();
        output.append(s);
        System.out.print(output.toString());
    }

}
