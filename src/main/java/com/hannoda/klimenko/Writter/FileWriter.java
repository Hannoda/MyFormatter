package com.hannoda.klimenko.Writter;

import java.io.*;


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
     * @throws WriterException
     */
    public FileWriter() throws WriterException {
        try {
            fileStream = new FileOutputStream(new File("output.txt"));
            fileWriter = new OutputStreamWriter(fileStream);
            printWriter = new PrintWriter(fileWriter, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new WriterException("FileNotFound", e);
        }
    }

    /**
     * @param st
     * @throws WriterException
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

    public void printIndent(int theNumberOfIndents) throws WriterException {
        for (int i = 0; i <= theNumberOfIndents; i++) {
            try {
                printWriter.print(" ");

            } catch (Exception e) {
                e.printStackTrace();
                throw new WriterException("FileNotFound", e);
            }
        }
        printWriter.flush();

    }


    /**
     * Closes the stream
     *
     * @throws WriterException
     */
    public void close() throws WriterException {
        printWriter.close();
    }
}
