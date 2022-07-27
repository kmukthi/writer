package com.digital14.writer.impl;

import com.digital14.writer.api.Writer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriterFactoryTest {

    private WriterFactory writerFactory;

    @Before
    public void setUp() {
        writerFactory = new WriterFactory();
    }

    @Test
    public void shouldGetWriter() {
        Writer stringWriter = writerFactory.getWriter("String Writer");
        Assert.assertEquals("StringWriter", stringWriter.getClass().getSimpleName());
    }

    @Test
    public void shouldGetNullWhenImplementationIsAbsent() {
        Writer string_writer = writerFactory.getWriter("New");
        Assert.assertEquals(null, string_writer);
    }

    @Test
    public void shouldGetFileWriter() {
        Writer fileWriter = writerFactory.getWriter("File Writer");
        Assert.assertEquals("FileWriter", fileWriter.getClass().getSimpleName());
    }
}
