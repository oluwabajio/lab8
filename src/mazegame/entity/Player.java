package mazegame.entity;

public class Player extends Character { //sets and gets current location
	
	private Location currentLocation;

    public Player()
    {
    }

    public Player(String name)
	{
	    super (name);
	}

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }




}
