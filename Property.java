/**
 * Property is a class that defines a property for display.
 * <p>
 * Student name: Dylan Barker, K-number: 20001430.
 *
 * @author Michael Kölling and Josh Murphy
 * @version 2.0
 */
public class Property {
    private final String id;
    private final String hostID;
    private final String hostName;
    private final String neighbourhood;
    private final double latitude;
    private final double longitude;
    private final String roomType;
    private final int price;
    private final int minimumNights;
    private boolean isFavourite;

    /**
     * Create a new property with specified initial values.
     *
     * @param id            unique identification for the property
     * @param hostID        unique identification for the host
     * @param hostName      name of the host
     * @param neighbourhood general area of the property
     * @param latitude      geographical y coordinate of property
     * @param longitude     geographical x coordinate of property
     * @param roomType      indicates the type of room: entire property or a private room
     * @param price         price of staying the minimum nights
     * @param minimumNights required amount of nights in order to book.
     */
    public Property(String id, String hostID, String hostName, String neighbourhood, double latitude, double longitude,
                    String roomType, int price, int minimumNights) {
        this.id = id;
        this.hostID = hostID;
        this.hostName = hostName;
        this.neighbourhood = neighbourhood;
        this.latitude = latitude;
        this.longitude = longitude;
        this.roomType = roomType;
        this.price = price;
        this.minimumNights = minimumNights;

        isFavourite = false;
    }

    /**
     * Accessed to retrieve the ID to display on GUI.
     *
     * @return the ID of this property.
     */
    public String getID() {
        return id;
    }

    /**
     * Accessed to retrieve the host's ID to display on GUI.
     *
     * @return the hostID of this property.
     */
    public String getHostID() {
        return hostID;
    }

    /**
     * Accessed to retrieve the latitude to display on GUI.
     *
     * @return the latitude of this property.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Accessed to retrieve the longitude to display on GUI.
     *
     * @return the longitude of this property.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Accessed to retrieve the price to display on GUI.
     *
     * @return the price of this property.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Checks if the property is a favourite and displays on GUI.
     *
     * @return true if this property is currently marked as a favourite, false otherwise.
     */
    public boolean isFavourite() {
        return isFavourite;
    }

    /**
     * Accessed to retrieve the price to display on GUI.
     *
     * @return the host name of this property.
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * Accessed to retrieve the general area to display on GUI.
     *
     * @return the neighbourhood of this property.
     */
    public String getNeighbourhood() {
        return neighbourhood;
    }

    /**
     * Accessed to retrieve the room type to display on GUI.
     *
     * @return the room type of this property.
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Accessed to retrieve the minimum number of nights to book and displays on GUI.
     *
     * @return the minimum number of nights this property can be booked for.
     */
    public String getMinNights() {
        return "" + minimumNights;
    }

    /**
     * Toggles whether this property is marked as a favourite or not.
     */
    public void toggleFavourite() {
        isFavourite = !isFavourite;
    }

}
