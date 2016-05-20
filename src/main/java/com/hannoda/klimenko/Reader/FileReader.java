package com.hannoda.klimenko.Reader;

import java.io.*;

/**
 * Provides reading first character of the file
 */
public class FileReader implements IReader {

    InputStream fileStream;
     //  Reader fileReader;
   // BufferedReader reader;

    private char ch;
    private int index = 0;
    private int nextSymb;

   /*
    public FileReader(String path) throws FileNotFoundException {
        fileStream = new FileInputStream(new File(path));
        fileReader = new InputStreamReader(fileStream);
        reader = new BufferedReader(fileReader);
    }
*/
    private char getCh() {
        return ch;
    }
    private void setCh(char ch) {
        this.ch = ch;
    }

    public int getNextSymb() {
        return nextSymb;
    }
    private void setNextSymb(int nextSymb) {
        this.nextSymb = nextSymb;
    }

    private void setIndex(int index) {
        this.index = index;
    }

   public BufferedReader FileReader() throws FileNotFoundException {

        fileStream = new FileInputStream(new File("input.txt"));
        Reader fileReader = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(fileReader);
        return reader;
    }


    /**
     * reading first character of the file
     * @param path
     * @return
     * @throws IOException
     */

    public char read(String path) throws IOException {

        InputStream fileStream = new FileInputStream(new File(path));
        Reader fileReader = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(fileReader);
        reader.skip((long) index);
        nextSymb = getNext(reader);

        if (nextSymb != -1)
        {
            this.ch = (char)nextSymb;
            reader.mark(index);
            setIndex(index + 1);
            return this.ch;
        } else {
            reader.close();
            return '\u0000';
        }
    }

    /**
     * Closes the stream
     */
    public void close() throws IOException {
    this.fileStream.close();
    }

    /**
     *returns the character if it exists
     * @param reader
     * @return nextSymbol or end of file character
     * @throws IOException
     */
    public int getNext(BufferedReader reader) throws IOException {

        int nextSymbol = reader.read();
        if (nextSymbol != -1)
            return nextSymbol;
        else {
            return -1;
        }
    }

}
