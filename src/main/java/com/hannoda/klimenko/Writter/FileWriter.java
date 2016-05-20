package com.hannoda.klimenko.Writter;

import com.hannoda.klimenko.Reader.ReaderException;

import java.io.*;
import java.nio.charset.Charset;


/**
 * Provides writing character of the file
 */
public class FileWriter implements IWriter {


    OutputStream fileStream;
    Writer fileWriter;
    PrintWriter printWriter;

    public FileWriter(String path) throws WriterException {
        try {
            fileStream = new FileOutputStream(new File(path));
            fileWriter = new OutputStreamWriter(fileStream);
            printWriter = new PrintWriter(fileWriter, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new WriterException("FileNotFound", e);

        }
    }

    /**
     * Constructor
     *
     * @throws FileNotFoundException
     */
    public FileWriter() throws WriterException {
    }

    /**
     * @param st
     * @throws IOException
     */
    public void write(String st) throws WriterException {

        try {

            printWriter.print(st);


        } catch (Exception e) {
            e.printStackTrace();
            throw new WriterException("FileNotFound", e);
        }
        printWriter.flush();

    }

    /**
     * Closes the stream
     *
     * @throws IOException
     */
    public void close() throws IOException {
        printWriter.close();
    }
}
