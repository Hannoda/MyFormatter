package com.hannoda.klimenko.Writter;

import java.io.IOException;

/**
 * Provides writing
 */
public interface IWriter {

    /**
     * Writing
     *
     * @param ch
     * @throws IOException
     */
    void write(String ch) throws WriterException;

}
