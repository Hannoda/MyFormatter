package com.hannoda.klimenko.Formatter;


import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Reader.ReaderException;
import com.hannoda.klimenko.Writter.IWriter;
import com.hannoda.klimenko.Writter.WriterException;



/**
 * Provides formatting of character of the file
 */
public class FileFormatter {
    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
        if(indent<0)this.indent = 0;
    }
    public void addIndent(int num){
    setIndent(getIndent()+num);
    }
    public void decreaseIndent(int num){
    setIndent(getIndent()-num);
    }

    int indent=0;


    public int format(IReader reader, IWriter writer) throws ReaderException, WriterException {
        char aloneSymbol;
        try {
            while (reader.getNext() != -1) {
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

                        decreaseIndent(4);
                        writer.write("\r\n");
                        writer.printIndent(indent);
                        writer.write(String.valueOf(aloneSymbol)+System.lineSeparator());

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

        //reader.close();
        return 0;

    }

   // public int format(IReader k, IWriter l) {
    //    return 0;
   // }
}

