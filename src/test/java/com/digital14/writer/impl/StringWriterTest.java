package com.digital14.writer.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringWriterTest {

    private StringWriter stringWriter;

    @Before
    public void setup() {
        this.stringWriter = new StringWriter();
    }

    @After
    public void tearDown() {
        this.stringWriter = null;
    }

    @Test
    public void shouldWrite() {
        this.stringWriter.write("Hello,");
        this.stringWriter.write("Hello, My Name is MUKTHI NATH");
        Assert.assertEquals("Hello, My Name is MUKTHI NATH", stringWriter.read());
    }

    @Test
    public void shouldNotWriteAfterCloses() {
        this.stringWriter.write("Hello,");
        this.stringWriter.close();
        this.stringWriter.write(" My Name is MUKTHI NATH");
        Assert.assertEquals("Hello,", stringWriter.read());
        this.stringWriter.write(" My Name is MUKTHI NATH");
        this.stringWriter.write(" My Name is MUKTHI NATH");
        Assert.assertEquals("Hello,", stringWriter.read());
    }

    @Test
    public void shouldConvertContentToLowercase() {
        this.stringWriter.write("Hello, My Name is MUKTHI NATH");
        Assert.assertEquals("Hello, My Name is MUKTHI NATH", stringWriter.read());

        this.stringWriter.lowerCase();
        Assert.assertEquals("hello, my name is mukthi nath", stringWriter.read());

    }

    @Test
    public void shouldConvertToUppercase() {
        this.stringWriter.write("Hello, My Name is MUKTHI NATH");
        Assert.assertEquals("Hello, My Name is MUKTHI NATH", stringWriter.read());

        this.stringWriter.upperCase();
        Assert.assertEquals("HELLO, MY NAME IS MUKTHI NATH", stringWriter.read());
    }

    @Test
    public void shouldRemoveStupid() {
        this.stringWriter.write("This is really really stupid!!!");
        this.stringWriter.stupidRemover();
        Assert.assertEquals("This is really really s*****!!!", stringWriter.read());
    }

    @Test
    public void shouldReturnSameStringIfStupidIsNotPresent() {
        this.stringWriter.write("This is really really");
        this.stringWriter.stupidRemover();
        Assert.assertEquals("This is really really", stringWriter.read());
    }

    @Test
    public void shouldRemoveConsecutiveDuplicate() {
        this.stringWriter.write("This is really really stupid!!!");
        this.stringWriter.duplicateRemover();
        Assert.assertEquals("This is really stupid!!!", stringWriter.read());
    }

    @Test
    public void shouldRemoveConsecutiveDuplicate1() {
        this.stringWriter.write("This is really stupid!!!");
        this.stringWriter.duplicateRemover();
        Assert.assertEquals("This is really stupid!!!", stringWriter.read());
    }

    @Test
    public void shouldRemoveConsecutiveDuplicate2() {
        this.stringWriter.write("This is really really really really stupid!!! really really");
        this.stringWriter.duplicateRemover();
        Assert.assertEquals("This is really stupid!!! really", stringWriter.read());
    }

    @Test
    public void shouldRemoveDuplicateAndStupidCombined() {
        this.stringWriter.write("This is really really stupid!!!");
        this.stringWriter.close();
        this.stringWriter.duplicateRemover();
        this.stringWriter.stupidRemover();
        Assert.assertEquals("This is really s*****!!!", stringWriter.read());
    }

}
