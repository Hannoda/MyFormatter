package com.hannoda.klimenko.Writter;

import com.hannoda.klimenko.Writter.IWriter;

/**
 * Created by hanno on 15.05.2016.
 */
public class StringWriter implements IWriter {

    /**
     * @param s
     */
    public void write(String s) {

        java.io.StringWriter output = new java.io.StringWriter();

        output.append(s);
        System.out.print(output.toString());
    }
    
    public void close() {
    }
}
