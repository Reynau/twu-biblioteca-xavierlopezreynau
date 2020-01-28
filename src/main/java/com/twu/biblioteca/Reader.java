package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {
    private BufferedReader reader;

    public Reader(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public int readInt () throws IOException, NumberFormatException {
        String input = reader.readLine();
        return Integer.parseInt(input);
    }

    public String readStr () throws IOException {
        return reader.readLine();
    }
}
