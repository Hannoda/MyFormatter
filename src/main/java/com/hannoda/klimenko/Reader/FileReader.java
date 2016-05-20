package com.hannoda.klimenko.Reader;

import java.io.*;

/**
 * Provides reading character of the file
 */
public class FileReader implements IReader {

    InputStream fileStream;

    /**
     * Character of the file
     */
    private char ch;
    /**
     * Character index of the file
     */
    private int index = 0;
    /**
     * Next symbol of the file
     */
    private int nextSymb;

    /**
     * Gets character of the file
     * @return character of the file
     */
    private char getCh() {
        return ch;
    }

    /**
     * Sets character of the file
     * @param ch
     */
    private void setCh(char ch) {
        this.ch = ch;
    }

    /**
     * Gets next symbol of the file
     * @return next symbol of the file
     */
    public int getNextSymb() {
        return nextSymb;
    }

    /**
     * Sets next symbol of the file
     * @param nextSymb
     */
    private void setNextSymb(int nextSymb) {
        this.nextSymb = nextSymb;
    }

    /**
     * Sets index of the file
     * @param index
     */
    private void setIndex(int index) {
        this.index = index;
    }

    public BufferedReader FileReader() throws ReaderException {

        try {
            fileStream = new FileInputStream(new File("input.txt"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ReaderException("FileNotFound", e);
        }
        Reader fileReader = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(fileReader);
        return reader;
    }


    /**
     * Reading first character of the file
     *
     * @param path
     * @return first character of the file
     * @throws ReaderException
     */

    public char read(String path) throws ReaderException {


        try {

            InputStream fileStream = null;
            fileStream = new FileInputStream(new File(path));
            Reader fileReader = new InputStreamReader(fileStream);
            BufferedReader reader = new BufferedReader(fileReader);

            reader.skip((long) index);
            nextSymb = getNext(reader);


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

    /**
     * Closes the stream
     * @throws ReaderException
     */
    public void close() throws ReaderException {
//    this.fileStream.close();
    }

    /**
     * returns the character if it exists
     *
     * @param reader
     * @return nextSymbol or end of file character
     * @throws ReaderException
     */
    public int getNext(BufferedReader reader) throws ReaderException {

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
