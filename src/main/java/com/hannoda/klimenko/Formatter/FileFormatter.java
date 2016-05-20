package com.hannoda.klimenko.Formatter;

import com.hannoda.klimenko.Reader.FileReader;
import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Writter.IWriter;

import java.io.BufferedReader;
import java.io.IOException;


/**
 *Provides formatting of character of the file
 */
public class FileFormatter implements Formater {


    /**
     * @param reader
     * @param writer
     * @return
     * @throws IOException
     */
    public int format(FileReader reader, IWriter writer) throws IOException {

        String s = "input.txt";

        while (reader.getNextSymb() != -1) {

            char aloneSymbol = reader.read(s);
            switch (aloneSymbol) {
                case ';':
                    writer.write(String.valueOf(aloneSymbol)+"\r\n");
                    break;
                case '{':
                    writer.write(String.valueOf(aloneSymbol)+"\r\n    ");
                    break;
                case '}':
                    writer.write(String.valueOf(aloneSymbol)+"\r\n");
                    break;

                default:
                    writer.write(String.valueOf(aloneSymbol));
                    break;
            }
        }

        reader.close();
        return 0;

    }

    public int format(IReader k, IWriter l) throws IOException {
        return 0;
    }
}

