package com.hannoda.klimenko.Reader;

import java.io.*;

/**
 *
 */
public class FileReader implements IReader {

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    private char ch;
    private int index = 0;

    public int getNextSymb() {
        return nextSymb;
    }

    public void setNextSymb(int nextSymb) {
        this.nextSymb = nextSymb;
    }

    private int nextSymb;
    private String path = "input.txt";

    public void setPath(String path) {
        this.path = path;
    }


    /**
     * @param path
     * @return
     * @throws IOException
     */
    public char read(String path) throws IOException {

        InputStream fileStream = new FileInputStream(new File("input.txt"));
        Reader fileReader = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(fileReader);

        reader.mark(0);
        reader.reset();
        reader.skip((long) index);
        nextSymb = hasNext(reader);

        if (nextSymb != -1) {

            this.ch = (char) nextSymb;
            reader.mark(index);
            setIndex(index + 1);
            return this.ch;
        } else {
            close();
            return '\u0000';
        }

    }


    /**
     *
     */
    public void close() {

    }

    public int hasNext(BufferedReader reader) throws IOException {

        int nextSymbol = reader.read();
        if (nextSymbol != -1)
            return nextSymbol;
        else {
            return -1;
        }
    }


    public void setIndex(int index) {
        this.index = index;
    }
}
