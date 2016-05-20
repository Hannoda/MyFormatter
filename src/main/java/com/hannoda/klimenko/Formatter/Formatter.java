package com.hannoda.klimenko.Formatter;

import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Reader.ReaderException;
import com.hannoda.klimenko.Writter.IWriter;
import com.hannoda.klimenko.Writter.WriterException;

import java.io.IOException;
import java.util.WeakHashMap;

/**
 * Provides formatting of character of the string
 */
public class Formatter implements Formater {


    /**
     * Formatting of character of the string
     *
     * @param reader
     * @param writer
     * @return
     * @throws ReaderException
     * @throws WriterException
     */
    public int format(IReader reader, IWriter writer) throws ReaderException, WriterException {

        String s = "While (inputStream.hasNext()) {char symbol = inputStream.read();{jlhlhl;}";

        for (int i = 0; i < s.length(); i++) {
            char aloneSymbol = 0;
            try {
                aloneSymbol = reader.read(s);

                switch (aloneSymbol) {
                    case ';':
                        writer.write(String.valueOf(aloneSymbol));
                        writer.write("\n");
                        break;
                    case '{':
                        writer.write(String.valueOf(aloneSymbol));
                        writer.write("\n    ");
                        break;
                    case '}':
                        writer.write(String.valueOf(aloneSymbol));
                        writer.write("\n");
                        break;

                    default:
                        writer.write(String.valueOf(aloneSymbol));
                        break;
                }
            } catch (ReaderException e) {
                e.printStackTrace();
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }
}

