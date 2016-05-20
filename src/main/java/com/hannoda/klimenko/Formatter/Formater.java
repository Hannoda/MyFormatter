package com.hannoda.klimenko.Formatter;


import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Reader.ReaderException;
import com.hannoda.klimenko.Writter.IWriter;
import com.hannoda.klimenko.Writter.WriterException;

import java.io.IOException;


/**
 * Provides formatting of input
 */
public interface Formater {
    int format(IReader k, IWriter l) throws ReaderException, WriterException;
}
