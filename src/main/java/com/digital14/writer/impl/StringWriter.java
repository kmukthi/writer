package com.digital14.writer.impl;

import com.digital14.writer.api.Writer;

public class StringWriter extends Writer {

    private String target;

    @Override
    public void write(String content) {
        if (!isClosed) {
            this.target = content;
        }
    }

    @Override
    public void close() {
        isClosed = true;
    }

    @Override
    public String read() {
        return target;
    }



}
