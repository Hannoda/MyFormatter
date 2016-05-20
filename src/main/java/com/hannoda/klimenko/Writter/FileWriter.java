package com.hannoda.klimenko.Writter;

import java.io.*;
import java.nio.charset.Charset;


/**
 *Provides writing character of the file
 */
public class FileWriter implements IWriter {

    OutputStream fileStream = new FileOutputStream(new File("output.txt"));
    Writer fileWriter = new OutputStreamWriter(fileStream);
    PrintWriter printWriter = new PrintWriter(fileWriter, true);

    /**
     *Constructor
     * @throws FileNotFoundException
     */
    public FileWriter() throws FileNotFoundException {
    }

    /**
     * @param st
     * @throws IOException
     */
    public void write(String st) throws IOException {

        try {

            printWriter.print(st);
            printWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    /**
     * Closes the stream
     * @throws IOException
     */
    public void close() throws IOException {
        printWriter.close();
    }
}
