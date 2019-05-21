public class TestHallDoor {
    public void testDoorFirstClose(){
        SmartHome smartHome = NewSmartHome.NewHome();
        EventDealer eventDealer = new EventHallDoorDealer();
        SensorEvent event = new SensorEvent(DOOR_CLOSED, "1");
        for(Room room : smartHome.getRooms()){
            for(Door door : room.getDoors()){
                if (door.getId().equals("1"))
                    eventDealer.DealEvent(event, smartHome, room, door);
            }
        }

        for(Room room : smartHome.getRooms()){
            for(Light light : room.getLights()){
                if (light.getId().equals("2"))
                    assert(light.isOn());
            }
        }
    }
    public void testDoorFirstOpen() {
        SmartHome smartHome = NewSmartHome.NewHome();
        EventDealer eventDealer = new EventHallDoorDealer();
        SensorEvent event = new SensorEvent(DOOR_CLOSED, "4");
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals("4"))
                    eventDealer.DealEvent(event, smartHome, room, door);
            }
        }

        for(Room room : smartHome.getRooms()){
            for(Light light : room.getLights()){
                if (light.getId().equals("2"))
                    assert(!light.isOn());
            }
        }
    }
}

}
