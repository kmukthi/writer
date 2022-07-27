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
        if (content == null)
            throw new RuntimeException("cannot write null");
        if (!isClosed)
            writeContent(content);
    }
    public final void close() {
        isClosed = true;
    }

    public final void toLowerCase() {
        writeContent(read().toLowerCase());
    }

    public final void toUpperCase() {
        writeContent(read().toUpperCase());
    }

    public final void removeStupid() {
        writeContent(read().replace(STUPID, STUPID_REPLACEMENT));
    }

    public final void removeDuplicate() {
        String[] split = this.read().split(" ");
        String result = "";
        for (int i = 0; i < split.length; i++) {
            final String currentWord = split[i];
            result+=currentWord + " ";
            while (i < split.length - 1 && currentWord.equals(alphaNumericValues(split[i+1]))) {
                String punctuations = getPunctuations(split[i+1]);
                if (punctuations.length() > 0) {
                    result = result.substring(0, result.length() - 1);
                    result += punctuations + " ";
                }
                i++;
            }
        }
        writeContent(result.trim());
    }

    private String alphaNumericValues(String word) {
        return word.replaceAll("[^A-Za-z0-9]", "");
    }

    private String getPunctuations(String word) {
        return word.replaceAll("[^!,.]", "");
    }



}
