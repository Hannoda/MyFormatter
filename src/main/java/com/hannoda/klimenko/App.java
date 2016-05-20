package com.hannoda.klimenko;

import com.hannoda.klimenko.Formatter.FileFormatter;
import com.hannoda.klimenko.Formatter.Formatter;
import com.hannoda.klimenko.Reader.*;
import com.hannoda.klimenko.Reader.FileReader;
import com.hannoda.klimenko.Reader.StringReader;
import com.hannoda.klimenko.Writter.FileWriter;
import com.hannoda.klimenko.Writter.StringWriter;

import java.io.*;

/**
 * Main
 */
public class App
{
    public static void main( String[] args ) throws IOException
    {

        StringReader stringReader = new StringReader();
        StringWriter stringWriter = new StringWriter();

        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();

        Formatter formatter = new Formatter();
        FileFormatter fileFormatter = new FileFormatter();

        //fileFormatter.format(fileReader,stringWriter);
       fileFormatter.format(fileReader,fileWriter);

    }
}
