package com.digital14.writer.impl;

import com.digital14.writer.api.Writer;

class StringWriter extends Writer {

    private String target;

    @Override
    public String read() {
        return target;
    }

    @Override
    protected void writeContent(String content) {
        this.target = content;
    }

}
