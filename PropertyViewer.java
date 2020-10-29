import java.net.URI;
import java.util.ArrayList;

/**
 * This project implements a simple application. Properties from a fixed
 * file can be displayed.
 * <p>
 * Student name: Dylan Barker, K-number: 20001430.
 *
 * @author Michael Kölling and Josh Murphy
 * @version 2.0
 */
public class PropertyViewer {
    private final PropertyViewerGUI gui;           // the Graphical User Interface
    private final Portfolio portfolio;
    private final int portfolioSize;               // size of the property
    private final ArrayList<Integer> propertyPrices;
    private Property currentProperty;
    private int currentPropertyIndex;
    private int views;

    /**
     * Creates a PropertyViewer and displays the first property in its GUI.
     */
    public PropertyViewer() {
        gui = new PropertyViewerGUI(this);
        portfolio = new Portfolio();
        portfolioSize = portfolio.numberOfProperties();

        // collects property prices for the challenge method
        propertyPrices = new ArrayList<>();

        currentPropertyIndex = -1;
        this.nextProperty();
    }

    /**
     * Checks if next property index is within bounds and displays in its GUI.
     */
    public void nextProperty() {
        if (++currentPropertyIndex > portfolioSize - 1)
            currentPropertyIndex = 0;
        updateProperty();
    }

    /**
     * Checks if previous property index is within bounds and displays in its GUI.
     */
    public void previousProperty() {
        if (--currentPropertyIndex < 0)
            currentPropertyIndex = portfolioSize - 1;
        updateProperty();
    }

    /**
     * Updates GUI with the current property and its details.
     */
    private void updateProperty() {
        currentProperty = portfolio.getProperty(currentPropertyIndex);

        // updates views and prices for challenge methods
        views++;
        propertyPrices.add(currentProperty.getPrice());

        gui.showProperty(currentProperty);
        gui.showID(currentProperty);
        gui.showFavourite(currentProperty);
    }

    /**
     * Toggles the property favourite status and shows it in its GUI.
     */
    public void toggleFavourite() {
        currentProperty.toggleFavourite();
        gui.showFavourite(currentProperty);
    }


    //----- methods for challenge tasks -----

    /**
     * This method opens the system's default internet browser.
     * The Google maps page should show the current properties location on the map.
     *
     * @throws Exception if the default browser is not found or inaccessible.
     */
    public void viewMap() throws Exception {

        double latitude = currentProperty.getLatitude();
        double longitude = currentProperty.getLongitude();

        URI uri = new URI("https://www.google.com/maps/place/" + latitude + "," + longitude);
        java.awt.Desktop.getDesktop().browse(uri);
    }

    /**
     * Accessed to display how many property views there are which is displayed in a new window.
     *
     * @return how many properties are viewed.
     */
    public int getNumberOfPropertiesViewed() {
        return views;
    }


    /**
     * Calculates the average price of the properties viewed so far which is displayed in new window.
     *
     * @return the mean price.
     */
    public int averagePropertyPrice() {
        int sum = 0;
        for (int price : propertyPrices)
            sum += price;
        return sum / views;
    }

}
