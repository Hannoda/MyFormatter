package com.hannoda.klimenko;

import com.hannoda.klimenko.Formatter.FileFormatter;
import com.hannoda.klimenko.Formatter.Formatter;
import com.hannoda.klimenko.Reader.*;
import com.hannoda.klimenko.Reader.FileReader;
import com.hannoda.klimenko.Reader.StringReader;
import com.hannoda.klimenko.Writter.FileWriter;
import com.hannoda.klimenko.Writter.StringWriter;
import com.hannoda.klimenko.Writter.WriterException;


/**
 * Main
 */
public class App {
    public static void main(String[] args) throws WriterException {

        StringReader stringReader = new StringReader();
        StringWriter stringWriter = new StringWriter();

        FileReader fileReader = new FileReader();


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("output.txt");
        } catch (WriterException e) {
            e.printStackTrace();
            throw new WriterException("WriterException", e);

        }

        Formatter formatter = new Formatter();
        FileFormatter fileFormatter = new FileFormatter();


        try {
            fileFormatter.format(fileReader, fileWriter);
            formatter.format(stringReader,stringWriter);
        } catch (ReaderException e) {
            e.printStackTrace();
            throw new WriterException("ReaderException", e);
        }


    }
}
