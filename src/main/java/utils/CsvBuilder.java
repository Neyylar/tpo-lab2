package utils;


import math.MathFunc;

import java.io.IOException;
import java.io.OutputStream;

public class CsvBuilder {
    private final MathFunc func;
    private final OutputStream outputStream;
    private Delimiter delimiter = Delimiter.COMMA;

    public CsvBuilder(MathFunc func, OutputStream outputStream) {
        this.func = func;
        this.outputStream = outputStream;
    }

    public CsvBuilder(MathFunc func, OutputStream outputStream, Delimiter delimiter) {
        this.func = func;
        this.outputStream = outputStream;
        this.delimiter = delimiter;
    }

    public void build(double from, double to, int parts) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("x").append(delimiter.value).append("f(x)\n");
        for (double x = from; x <= to; x += (to - from) / parts) {
            builder.append(x).append(delimiter.value).append(func.compute(x)).append("\n");
        }

        outputStream.write(builder.toString().getBytes());
    }

    public enum Delimiter {
        COMMA(','),
        SEMICOLON(';'),
        TAB('\t'),
        SPACE(' '),
        PIPE('|');

        private final char value;

        Delimiter(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }
}
