package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {
        Collection<EventDealer> eventDealer = new ArrayList<>();
        eventDealer.add(new EventDoorDealer);
        eventDealer.add(new EventHallDoorDealer);
        eventDealer.add(new EventLightDealer);

        // считываем состояние дома из файла

        SmartHomeReader smartHomeReader = new SmartHomeReader();
        SmartHome smartHome = SmartHomeReader.create();
        // начинаем цикл обработки событий
        SensorEvent event = CreatorOfNextSensorEvent.getNextSensorEvent();
        while (event != null) {
            dealer.DealEvent(event, smartHome);
            event = CreatorOfNextSensorEvent.getNextSensorEvent();
        }
    }
}

