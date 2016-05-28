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
    boolean isTheNext=true;


    private void setIndex(int index) {
        this.index = index;
    }

    public FileReader() throws ReaderException {

        try {
            fileStream = new FileInputStream(new File("input.txt"));

        } catch (FileNotFoundException e) {
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
            nextSymb = reader.read();
            if (nextSymb != -1) {

                this.setIsTheNext(true);
                this.ch = (char) nextSymb;
                reader.mark(index);
                setIndex(index + 1);
                return this.ch;
            } else {
                this.setIsTheNext(false);
                reader.close();
                return '\u0000';
            }
        } catch (FileNotFoundException e) {
            throw new ReaderException("FileNotFound", e);
        } catch (IOException e) {
            throw new ReaderException("IOException", e);
        }
    }


    public void close() throws ReaderException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new ReaderException("IOException",e);
        }
    }

    private void setIsTheNext (boolean value){
        this.isTheNext = value;
    }

    public boolean isTheNext(){
        return isTheNext;
    }

}
