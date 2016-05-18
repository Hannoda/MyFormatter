package com.hannoda.klimenko.Writter;

import java.io.*;
import java.nio.charset.Charset;


/**
 *
 */
public class FileWriter implements IWriter {

    public FileWriter() throws FileNotFoundException {
    }


    OutputStream fileStream = new FileOutputStream(new File("output.txt"));

    Writer fileWriter = new OutputStreamWriter(fileStream);
    // Writer fileWriter = new OutputStreamWriter(fileStream);
    PrintWriter printWriter = new PrintWriter(fileWriter, true);

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
     * @throws IOException
     */
    public void close() throws IOException {
        printWriter.close();
    }
}
