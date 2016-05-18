package com.hannoda.klimenko.Formatter;

import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Writter.IWriter;

import java.io.IOException;

/**
 * .
 */
public class Formatter implements Formater {

    /**
     * @param reader
     * @param writer
     * @return
     * @throws IOException
     */
    public int format(IReader reader, IWriter writer) throws IOException {


        String s = "While (inputStream.hasNext()) {char symbol = inputStream.read();{jlhlhl;}";

        for (int i = 0; i < s.length(); i++) {
            char aloneSymbol = reader.read(s);
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
        }

        reader.close();
        writer.close();
        return 0;

    }
}

