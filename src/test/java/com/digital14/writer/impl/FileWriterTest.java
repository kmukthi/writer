package com.digital14.writer.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileWriterTest {

    private FileWriter fileWriter;

    @Before
    public void setup() {
        this.fileWriter = new FileWriter();
    }

    @Test
    public void shouldWrite() {
        this.fileWriter.write("This is a file writer");
        Assert.assertEquals("This is a file writer", this.fileWriter.read());
    }

    @Test
    public void shouldNotWriteAfterClosing() {
        this.fileWriter.write("This is a file writer");
        fileWriter.close();
        fileWriter.write("This wont be present");

        Assert.assertEquals("This is a file writer", this.fileWriter.read());

    }

    @Test
    public void shouldConvertContentToLowercase() {
        this.fileWriter.write("Hello, My Name is MUKTHI NATH");
        Assert.assertEquals("Hello, My Name is MUKTHI NATH", fileWriter.read());

        this.fileWriter.toLowerCase();
        Assert.assertEquals("hello, my name is mukthi nath", fileWriter.read());

    }

    @Test
    public void shouldConvertToUppercase() {
        this.fileWriter.write("Hello, My Name is MUKTHI NATH");
        Assert.assertEquals("Hello, My Name is MUKTHI NATH", fileWriter.read());

        this.fileWriter.toUpperCase();
        Assert.assertEquals("HELLO, MY NAME IS MUKTHI NATH", fileWriter.read());
    }

    @Test
    public void shouldRemoveStupid() {
        this.fileWriter.write("This is really really stupid!!!");
        this.fileWriter.removeStupid();
        Assert.assertEquals("This is really really s*****!!!", fileWriter.read());
    }

    @Test
    public void shouldReturnSameStringIfStupidIsNotPresent() {
        this.fileWriter.write("This is really really");
        this.fileWriter.removeStupid();
        Assert.assertEquals("This is really really", fileWriter.read());
    }

    @Test
    public void shouldRemoveConsecutiveDuplicate() {
        this.fileWriter.write("This is really really stupid!!!");
        this.fileWriter.removeDuplicate();
        Assert.assertEquals("This is really stupid!!!", fileWriter.read());
    }

    @Test
    public void shouldRemoveConsecutiveDuplicate1() {
        this.fileWriter.write("This is really stupid!!!");
        this.fileWriter.removeDuplicate();
        Assert.assertEquals("This is really stupid!!!", fileWriter.read());
    }

    @Test
    public void shouldRemoveConsecutiveDuplicate2() {
        this.fileWriter.write("This is really really really really stupid!!! really really");
        this.fileWriter.removeDuplicate();
        Assert.assertEquals("This is really stupid!!! really", fileWriter.read());
    }

    @Test
    public void shouldRemoveDuplicateAndStupidCombined() {
        this.fileWriter.write("This is really really stupid!!!");
        this.fileWriter.close();
        this.fileWriter.removeDuplicate();
        this.fileWriter.removeStupid();
        Assert.assertEquals("This is really s*****!!!", fileWriter.read());
    }

    @Test
    public void shouldWriteContent() {
        this.fileWriter.writeContent("This is really really stupid!!!");
        this.fileWriter.close();
        Assert.assertEquals("This is really really stupid!!!", fileWriter.read());
    }

    @Test
    public void shouldWriteTwoStupidWithExclamation() {
        this.fileWriter.writeContent("This is really really stupid stupid!!!");
        this.fileWriter.removeDuplicate();
        Assert.assertEquals("This is really stupid!!!", fileWriter.read());
    }

    @Test
    public void shouldWriteThreeStupidWithExclamation() {
        this.fileWriter.writeContent("This is really really stupid stupid!!! stupid stupid");
        this.fileWriter.removeDuplicate();
        Assert.assertEquals("This is really stupid!!!", fileWriter.read());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExcpetionWhileWrtingNull() {
        this.fileWriter.write(null);
    }
}
