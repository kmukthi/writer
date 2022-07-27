package com.digital14.writer;

import com.digital14.writer.api.Writer;
import com.digital14.writer.impl.WriterFactory;

public class WriterApplication {

	public static void main(String[] args) {
		WriterFactory writerFactory = new WriterFactory();
		Writer stringWriter = writerFactory.getWriter("String Writer");
		Writer fileWriter = writerFactory.getWriter("File Writer");
		fileWriter.write("Write to a file");
		stringWriter.write("Write to a variable");

	}

}
