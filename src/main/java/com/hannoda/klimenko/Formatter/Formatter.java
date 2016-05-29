package com.hannoda.klimenko.Formatter;


import com.hannoda.klimenko.State.*;
import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Reader.ReaderException;
import com.hannoda.klimenko.Writter.IWriter;

import java.util.HashMap;
import java.util.Map;


/**
 * Provides formatting of character of the file
 */
public class Formatter {

    Map<Character, State> states = new HashMap<Character, State>();

    public Formatter() {
        state = null;

        states.put(';', new SemicolonState());
        states.put('{', new LeftBracketsState());
        states.put('}', new RightBracketState());
    }

    public char aloneSymbol;
    public int indent = 0;

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }


    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) throws FormatterException {
        if (indent < 0) {
            throw new FormatterException("Extra character \"}\"");
        } else this.indent = indent;
    }

    public void addIndent(int num) throws FormatterException {
        setIndent(getIndent() + num);
    }

    public void decreaseIndent(int num) throws FormatterException {
        if ((getIndent() - num) < 0) {
            throw new FormatterException("Extra character \"}\"");
        } else setIndent(getIndent() - num);

    }


    public int format(IReader reader, IWriter writer) throws FormatterException {

        try {
            while (reader.isTheNext()) {
                aloneSymbol = reader.read();

                if (states.get(aloneSymbol) == null) {
                    NormalState normalState = new NormalState();
                    normalState.doAction(this, writer);
                } else states.get(aloneSymbol).doAction(this, writer);

            }
        } catch (ReaderException er) {
            throw new FormatterException("Read error", er);
        } catch (StateException er) {
            throw new FormatterException("State Error", er);
        }

        try {
            reader.close();
        } catch (ReaderException er) {
            throw new FormatterException("Can't close the stream", er);
        }
        return 0;

    }

}
