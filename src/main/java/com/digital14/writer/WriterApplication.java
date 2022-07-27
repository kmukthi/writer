package com.digital14.writer;

import com.digital14.writer.api.Writer;
import com.digital14.writer.impl.StringWriter;

public class WriterApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		Writer stringWriter = new StringWriter();
		stringWriter.write("This is really really really really stupid!!! really really");
		stringWriter.duplicateRemover();
		System.out.println(stringWriter.read());
	}

}
