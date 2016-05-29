package com.hannoda.klimenko.State;

import com.hannoda.klimenko.Formatter.Formatter;
import com.hannoda.klimenko.Writter.IWriter;
import com.hannoda.klimenko.Writter.WriterException;

/**
 *
 */
public class NormalState implements State {

    public void doAction(Formatter context, IWriter writer) throws StateException {
        try {
            writer.write(String.valueOf(context.aloneSymbol));
        } catch (WriterException e) {
            throw new StateException("Write error", e);
        }
        context.setState(this);
    }
}

