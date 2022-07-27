package com.digital14.writer.api;

public abstract class Writer {

    private String STUPID = "stupid";
    private String STUPID_REPLACEMENT = "s*****";
    private boolean isClosed;

    public abstract String read();
    protected abstract void writeContent(String content);

    public Writer() {
        isClosed = false;
    }

    public final void write(String content) {
        if (!isClosed)
            writeContent(content);
    }
    public final void close() {
        isClosed = true;
    }

    public final void lowerCase() {
        writeContent(read().toLowerCase());
    }

    public final void upperCase() {
        writeContent(read().toUpperCase());
    }

    public final void stupidRemover() {
        writeContent(read().replace(STUPID, STUPID_REPLACEMENT));
    }

    public final void duplicateRemover() {
        String[] split = this.read().split(" ");
        String result = "";
        for (int i = 0; i < split.length; i++) {
            result+=split[i]+" ";
            final String duplicateWord = split[i];
            while (i < split.length - 1 && duplicateWord.equals(split[i+1])) {
                i++;
            }
        }
        writeContent(result.trim());
    }



}
