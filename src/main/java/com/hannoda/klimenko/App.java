package com.hannoda.klimenko;


import com.hannoda.klimenko.Formatter.Formatter;
import com.hannoda.klimenko.Formatter.FormatterException;
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
    public static void main(String[] args) throws Exception {


        Formatter fileFormatter = new Formatter();
        Formatter stringFormatter = new Formatter();

        try {

            fileFormatter.format(new FileReader(), new FileWriter());
            stringFormatter.format(new StringReader(), new StringWriter());

        } catch (ReaderException e) {
            throw new WriterException("Read Error", e);
        } catch (WriterException e) {
            throw new WriterException("Write Error", e);
        } catch (FormatterException e) {
            throw new WriterException("Format Error", e).getHiddenException();

        }

    }

}
