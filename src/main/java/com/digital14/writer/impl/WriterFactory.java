package com.digital14.writer.impl;

import com.digital14.writer.api.Writer;

public class WriterFactory {

    public Writer getWriter(String type) {
        if (type.equals("String Writer"))
            return new StringWriter();
        if (type.equals("File Writer"))
            return new FileWriter();
        return null;
    }
}
