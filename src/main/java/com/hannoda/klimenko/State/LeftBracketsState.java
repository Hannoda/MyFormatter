package com.hannoda.klimenko.State;

import com.hannoda.klimenko.Formatter.Formatter;
import com.hannoda.klimenko.Formatter.FormatterException;
import com.hannoda.klimenko.Writter.IWriter;
import com.hannoda.klimenko.Writter.WriterException;

/**
 *
 */
public class LeftBracketsState implements State {

    public void doAction(Formatter context, IWriter writer) throws StateException {
        try {
            writer.write(String.valueOf(context.aloneSymbol) + System.lineSeparator());
            context.addIndent(4);
            writer.printIndent(context.indent);
        } catch (WriterException e) {
            throw new StateException("Write error", e);
        } catch (FormatterException e) {
            throw new StateException("Formatter error", e);
        }
        context.setState(this);
    }

}