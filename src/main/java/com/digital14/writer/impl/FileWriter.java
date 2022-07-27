package com.digital14.writer.impl;

import com.digital14.writer.api.Writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileWriter extends Writer {

    private String target;

    public FileWriter() {
        super();
        this.target = System.getProperty("user.dir")+"/demo.txt";
    }

    @Override
    public String read() {
        try {
            return Files.readString(Paths.get(target));
        } catch (IOException ex) {
            throw new RuntimeException("Error reading : ", ex);
        }
    }

    @Override
    protected void writeContent(String content) {
        Path path = Paths.get(target);
        byte[] strToBytes = content.getBytes();
        try {
            Files.write(path, strToBytes);
        } catch (IOException ex) {
            throw new RuntimeException("Error Writing : ", ex);
        }
    }


}
