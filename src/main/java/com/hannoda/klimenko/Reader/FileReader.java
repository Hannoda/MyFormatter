package com.hannoda.klimenko.Reader;

import java.io.*;

/**
 * Provides reading character of the file
 */
public class FileReader implements IReader {

    InputStream fileStream;
    Reader fileReader;
    BufferedReader reader;
    private char ch;
    private int index = 0;
    private int nextSymb;

    private void setIndex(int index) {
        this.index = index;
    }

    public FileReader() throws ReaderException {

        try {
            fileStream = new FileInputStream(new File("input.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ReaderException("FileNotFound", e);
        }
        fileReader = new InputStreamReader(fileStream);
        reader = new BufferedReader(fileReader);

    }

    public char read() throws ReaderException {

        try {

            fileStream = new FileInputStream(new File("input.txt"));
             fileReader = new InputStreamReader(fileStream);
             reader = new BufferedReader(fileReader);

            reader.skip((long) index);
            nextSymb = getNext();

            if (nextSymb != -1) {
                this.ch = (char) nextSymb;

                reader.mark(index);

                setIndex(index + 1);
                return this.ch;
            } else {
                reader.close();
                return '\u0000';
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ReaderException("FileNotFound", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ReaderException("IOException", e);
        }
    }


    public void close() throws ReaderException {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNext() throws ReaderException {

        int nextSymbol = 0;
        try {
            nextSymbol = reader.read();
        } catch (IOException e) {
            e.printStackTrace();

        }
        if (nextSymbol != -1)
            return nextSymbol;
        else {
            return -1;
        }
    }

}
