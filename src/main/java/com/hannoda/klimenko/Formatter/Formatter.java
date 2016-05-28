package com.hannoda.klimenko.Formatter;


import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Reader.ReaderException;
import com.hannoda.klimenko.Writter.IWriter;
import com.hannoda.klimenko.Writter.WriterException;


/**
 * Provides formatting of character of the file
 */
public class Formatter {
    int indent=0;
    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) throws FormatterException {
        if(indent<0){
            throw new FormatterException("Extra character \"}\"");
        }
        else this.indent = indent;
    }
    public void addIndent(int num) throws FormatterException {
        setIndent(getIndent()+num);
    }
    public void decreaseIndent(int num) throws FormatterException {
        if(getIndent()-num<0){
            throw new FormatterException("Extra character \"}\"");
        }
        else setIndent(getIndent()-num);

    }

    public int format(IReader reader, IWriter writer) throws FormatterException{
            char aloneSymbol;
        try {
            while (reader.isTheNext()) {
                aloneSymbol = reader.read();
                switch (aloneSymbol) {
                    case ';':
                        writer.write(String.valueOf(aloneSymbol)+System.lineSeparator());
                        writer.printIndent(indent);
                        break;
                    case '{':

                        writer.write(String.valueOf(aloneSymbol)+System.lineSeparator());
                        addIndent(4);
                        writer.printIndent(indent);
                        break;
                    case '}':

                        writer.write("\r\n");
                        decreaseIndent(4);
                        writer.printIndent(indent);
                        writer.write(String.valueOf(aloneSymbol)+System.lineSeparator());

                        break;

                    default:
                        writer.write(String.valueOf(aloneSymbol));
                        break;
                }

            }
        } catch (ReaderException er) {
            throw new FormatterException("Read error", er);
        } catch (WriterException er) {
            throw new FormatterException("Write error", er);
        }

        try {
            reader.close();
        } catch (ReaderException er) {
            throw new FormatterException("Can't close the stream", er);
        }
        return 0;

    }

}

