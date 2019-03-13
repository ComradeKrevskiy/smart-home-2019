public class TestDoor {
    public void testDoorFirstOpen(){
        SmartHome smartHome = NewSmartHome.NewHome();
        EventDealer eventDealer = new EventDoorDealer();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "1");
        for(Room room : smartHome.getRooms()){
            for(Door door : room.getDoors()){
                if (door.getId().equals("1"))
                    eventDealer.DealEvent(event, smartHome, room, door);
            }
        }

        for(Room room : smartHome.getRooms()){
            for(Door door : room.getDoors()){
                if (door.getId().equals("1"))
                    assert(door.isOpen());
            }
        }
    }
    public void testDoorThirdClose() {
        SmartHome smartHome = NewSmartHome.NewHome();
        EventDealer eventDealer = new EventDoorDealer();
        SensorEvent event = new SensorEvent(DOOR_CLOSED, "3");
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals("3"))
                    eventDealer.DealEvent(event, smartHome, room, door);
            }
        }

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals("3"))
                    assert (!door.isOpen());
            }
        }
    }
}

}
