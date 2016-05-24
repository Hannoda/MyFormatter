package com.hannoda.klimenko.Writter;



/**
 * Provides writing character of the string
 */
public class StringWriter implements IWriter {

    public StringWriter() {
    }

    public void write(String s) {
        java.io.StringWriter output = new java.io.StringWriter();
        output.append(s);
        System.out.print(output.toString());
    }

    public void printIndent(int theNumberOfIndents){
    for(int i=0; i<=theNumberOfIndents; i++)
        System.out.print(" ");
    }

}
