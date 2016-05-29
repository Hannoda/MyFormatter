package com.hannoda.klimenko.State;

import com.hannoda.klimenko.Formatter.Formatter;
import com.hannoda.klimenko.Writter.IWriter;

/**
 * Created by hanno on 29.05.2016.
 */
public interface State {
    public void doAction(Formatter context, IWriter writer) throws StateException;
}
