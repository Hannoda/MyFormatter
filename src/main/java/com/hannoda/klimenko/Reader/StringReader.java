package com.hannoda.klimenko.Reader;

import java.io.*;


/**
 * Provides reading first character of the String
 */
public class StringReader implements IReader{

    private char ch;
    private int index = 0;
    private int nextSymbol;
    String s ="while (inputStream.hasNext()){char symbol = inputStream.read();if(symbol == ‘ ‘){whiteSpaceCount++;}}";
    java.io.StringReader reader;

    public StringReader(){
        reader = new java.io.StringReader(s);
    }
    /**
     * reading first character of the String s
     *
     * @param
     * @return
     * @throws ReaderException
     */
    public char read() throws ReaderException {

        try {
            if (nextSymbol != -1) {
               // reader.reset();
                this.ch = (char)nextSymbol;
                reader.mark(index);
                setIndex(index + 1);
            } else close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.ch;
    }

    /**
     * Field values ​​to the initial state
     */
    public void close() {
       // index = 0;
        //this.ch = '\u0000';
        reader.close();
    }

    /**
     * Gets the value of index
     *
     * @return value of index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of index
     *
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }


    public int getNext() throws ReaderException {

         nextSymbol = 0;

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
