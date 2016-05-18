package com.hannoda.klimenko.Formatter;


import com.hannoda.klimenko.Reader.IReader;
import com.hannoda.klimenko.Writter.IWriter;

import java.io.IOException;

/**
 * Created by hanno on 15.05.2016.
 */
public interface Formater {
    int format(IReader k, IWriter l) throws IOException;
}
