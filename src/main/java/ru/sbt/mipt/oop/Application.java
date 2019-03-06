package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        CreatorOfNextSensorEvent CoNSE = new CreatorOfNextSensorEvent();
        StringReader stringReader = new StringReader();
        String json = stringReader.ReadString();
        EventDealer dealer = new EventDealer();
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);
        // начинаем цикл обработки событий
        SensorEvent event = CoNSE.getNextSensorEvent();
        while (event != null) {
            dealer.DealEvent(event, smartHome);
            event = CoNSE.getNextSensorEvent();
        }
    }
}
