package com.hannoda.klimenko.Formatter;

import com.hannoda.klimenko.Reader.FileReader;
import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Reader.ReaderException;
import com.hannoda.klimenko.Writter.IWriter;
import com.hannoda.klimenko.Writter.WriterException;


/**
 * Provides formatting of character of the file
 */
public class FileFormatter implements Formater {


    /**
     * @param reader
     * @param writer
     * @return
     * @throws ReaderException, WriterException
     */
    public int format(FileReader reader, IWriter writer) throws ReaderException, WriterException {

        char aloneSymbol;
        String s = "input.txt";
        try {
            while (reader.getNextSymb() != -1) {
                aloneSymbol = reader.read(s);

                switch (aloneSymbol) {
                    case ';':
                        writer.write(String.valueOf(aloneSymbol) + "\r\n");
                        break;
                    case '{':
                        writer.write(String.valueOf(aloneSymbol) + "\r\n    ");
                        break;
                    case '}':
                        writer.write(String.valueOf(aloneSymbol) + "\r\n");
                        break;

                    default:
                        writer.write(String.valueOf(aloneSymbol));
                        break;
                }

            }
        } catch (ReaderException er) {
            er.printStackTrace();
            throw new ReaderException("hkh", er);
        } catch (WriterException e) {
            e.printStackTrace();
            throw new WriterException("WriterException", e);
        }

        reader.close();
        return 0;

    }

    public int format(IReader k, IWriter l) {
        return 0;
    }
}

