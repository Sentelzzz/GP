package org.example.utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser {

    private JsonParser(){
    }

    public static String parser(String label) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        String result;

        FileReader reader = new FileReader("src/test/resources/test.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        result = (String) jsonObject.get(label);

        return result;
    }
}
