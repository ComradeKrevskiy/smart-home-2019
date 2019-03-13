public class TestLight {
    public void testLightFirstOn(){
        SmartHome smartHome = NewSmartHome.NewHome();
        EventDealer eventDealer = new EventLightDealer();
        SensorEvent event = new SensorEvent(LIGHT_ON, "1");
        for(Room room : smartHome.getRooms()){
            for(Light light : room.getLights()){
                if (light.getId().equals("1"))
                    eventDealer.DealEvent(event, smartHome, room, light);
            }
        }

        for(Room room : smartHome.getRooms()){
            for(Light light : room.getLights()){
                if (light.getId().equals("1"))
                    assert(light.isOn());
            }
        }
    }
    public void testLightThirdOff() {
        SmartHome smartHome = NewSmartHome.NewHome();
        EventDealer eventDealer = new EventLightDealer();
        SensorEvent event = new SensorEvent(LIGHT_OFF, "3");
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("3"))
                    eventDealer.DealEvent(event, smartHome, room, light);
            }
        }

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("3"))
                    assert (!light.isOn());
            }
        }
    }
}

}
