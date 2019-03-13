package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {
        NewSmartHome newSmartHome = new NewSmartHome();
        SmartHome smartHome = newSmartHome.NewHome();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        System.out.println(jsonString);
        Path path = Paths.get("output.js");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }

}
