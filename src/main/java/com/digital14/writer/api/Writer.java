package com.digital14.writer.api;

public abstract class Writer {

    private String content;

    private String STUPID = "stupid";
    private String STUPID_REPLACEMENT = "s*****";
    protected boolean isClosed;

    public Writer() {
        isClosed = false;
    }

    public abstract void write(String content);
    public abstract void close();
    public abstract String read();

    public void lowerCase() {
        update(read().toLowerCase());
    }

    public void upperCase() {
        update(read().toUpperCase());
    }

    public void stupidRemover() {
        update(read().replace(STUPID, STUPID_REPLACEMENT));
    }

    public void duplicateRemover() {
        String[] split = this.read().split(" ");
        String result = "";
        for (int i = 0; i < split.length; i++) {
            result+=split[i]+" ";
            final String duplicateWord = split[i];
            while (i < split.length - 1 && duplicateWord.equals(split[i+1])) {
                i++;
            }
        }
        update(result.trim());
    }

    private void update(String content) {
        this.isClosed = false;
        this.write(content);
        this.isClosed = true;
    }

}
