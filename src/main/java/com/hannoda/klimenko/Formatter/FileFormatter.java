package com.hannoda.klimenko.Formatter;
//import com.hannoda.klimenko.Formatter.Formatter.Formater;

import com.hannoda.klimenko.Reader.FileReader;
import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Writter.IWriter;

import java.io.BufferedReader;
import java.io.IOException;


/**
 *
 */
public class FileFormatter implements Formater {

    // String s = "while (inputStream.hasNext()) {char symbol = inputStream.read();{jlhlhl;}}";

    // BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    //String str[] = new String[100];


    /**
     * @param reader
     * @param writer
     * @return
     * @throws IOException
     */
    public int format(FileReader reader, IWriter writer) throws IOException {

        String s = "While (inputStream.hasNext()) {char symbol = inputStream.read();{jlhlhl;}";

        while (reader.getNextSymb() != -1) {

            // for (int i = 0; i < s.length(); i++) {
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
        return 0;

    }

    public boolean hasNext(IReader reader) throws IOException {

        String s = "While (inputStream.hasNext()) {char symbol = inputStream.read();{jlhlhl;}";
        if ((reader.read(s)) != -1) ;

        return true;

    }

    public int format(IReader k, IWriter l) throws IOException {
        return 0;
    }
}

