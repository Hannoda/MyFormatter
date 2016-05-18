package com.hannoda.klimenko.Writter;

import java.io.IOException;

/**
 *
 */
public interface IWriter {
    void write(String ch) throws IOException;
    void close() throws IOException;
}
