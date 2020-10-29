import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * PropertyViewerGUI provides the GUI for the project. It displays the property
 * and strings, and it listens to button clicks.
 * <p>
 * Student name: Dylan Barker, K-number: 20001430.
 *
 * @author Michael Kölling and Josh Murphy
 * @version 2.0
 */
public class PropertyViewerGUI {
    private final PropertyViewer viewer;
    // fields:
    private JFrame frame;
    private JPanel propertyPanel;
    private JLabel idLabel;
    private JLabel favouriteLabel;
    private JTextField hostIDLabel;
    private JTextField hostNameLabel;
    private JTextField neighbourhoodLabel;
    private JTextField roomTypeLabel;
    private JTextField priceLabel;
    private JTextField minNightsLabel;

    /**
     * Create a PropertyViewer and display its GUI on screen.
     *
     * @param viewer The base property viewer for the application.
     */
    public PropertyViewerGUI(PropertyViewer viewer) {
        this.viewer = viewer;
        makeFrame();
        this.setPropertyViewSize(400, 250);
    }


    // ---- public view functions ----

    /**
     * Displays a given property.
     *
     * @param property The property to be displayed.
     */
    public void showProperty(Property property) {
        hostIDLabel.setText(property.getHostID());
        hostNameLabel.setText(property.getHostName());
        neighbourhoodLabel.setText(property.getNeighbourhood());
        roomTypeLabel.setText(property.getRoomType());
        priceLabel.setText("£" + property.getPrice());
        minNightsLabel.setText(property.getMinNights());
        this.showID(property);
        this.showFavourite(property);
    }

    /**
     * Set a fixed size for the property display. If set, this size will be used for all properties.
     * If not set, the GUI will resize for each property.
     *
     * @param width  The selected width for the property panel
     * @param height The selected height for the property panel.
     */
    public void setPropertyViewSize(int width, int height) {
        propertyPanel.setPreferredSize(new Dimension(width, height));
        frame.pack();
    }

    /**
     * Show a message in the status bar at the bottom of the screen.
     *
     * @param property The currently displayed property.
     */
    public void showFavourite(Property property) {
        String favouriteText = " ";
        if (property.isFavourite()) {
            favouriteText += "This is one of your favourite properties!";
        }
        favouriteLabel.setText(favouriteText);
    }

    /**
     * Show the ID in the top of the screen.
     *
     * @param property The currently displayed property.
     */
    public void showID(Property property) {
        idLabel.setText("Current Property ID:" + property.getID());
    }

    // ---- implementation of button functions ----

    /**
     * Called when the 'Next' button was clicked.
     */
    private void nextButton() {
        viewer.nextProperty();
    }

    /**
     * Called when the 'Previous' button was clicked.
     */
    private void previousButton() {
        viewer.previousProperty();
    }

    /**
     * Called when the 'View on Map' button was clicked.
     */
    private void viewOnMapsButton() {
        try {
            viewer.viewMap();
        } catch (Exception e) {
            System.out.println("URL INVALID");
        }

    }

    /**
     * Called when the 'Toggle Favourite' button was clicked.
     */
    private void toggleFavouriteButton() {
        viewer.toggleFavourite();
    }


    /**
     * Creates a new window, displaying the current property statistics.
     */
    private void viewStatistics() {
        JFrame window = new JFrame("Statistics Window");

        // JLabel with html to center and put spaces between statements
        window.add(new JLabel("<html><center>Properties viewed: " + viewer.getNumberOfPropertiesViewed() +
                "<br/><br/>" + "Average price of properties viewed: £" + viewer.averagePropertyPrice()));

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    // ---- swing stuff to build the frame and all its components ----

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame() {
        frame = new JFrame("Portfolio Viewer Application");
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));

        // Specify the layout manager with nice spacing
        contentPane.setLayout(new BorderLayout(6, 6));

        // Create the property pane in the center
        propertyPanel = new JPanel();
        propertyPanel.setLayout(new GridLayout(6, 2));

        propertyPanel.add(new JLabel("HostID: "));
        hostIDLabel = new JTextField("default");
        hostIDLabel.setEditable(false);
        propertyPanel.add(hostIDLabel);

        propertyPanel.add(new JLabel("Host Name: "));
        hostNameLabel = new JTextField("default");
        hostNameLabel.setEditable(false);
        propertyPanel.add(hostNameLabel);

        propertyPanel.add(new JLabel("Neighbourhood: "));
        neighbourhoodLabel = new JTextField("default");
        neighbourhoodLabel.setEditable(false);
        propertyPanel.add(neighbourhoodLabel);

        propertyPanel.add(new JLabel("Room type: "));
        roomTypeLabel = new JTextField("default");
        roomTypeLabel.setEditable(false);
        propertyPanel.add(roomTypeLabel);

        propertyPanel.add(new JLabel("Price: "));
        priceLabel = new JTextField("default");
        priceLabel.setEditable(false);
        propertyPanel.add(priceLabel);

        propertyPanel.add(new JLabel("Minimum nights: "));
        minNightsLabel = new JTextField("default");
        minNightsLabel.setEditable(false);
        propertyPanel.add(minNightsLabel);

        propertyPanel.setBorder(new EtchedBorder());
        contentPane.add(propertyPanel, BorderLayout.CENTER);

        // Create two labels at top and bottom for the file name and status message
        idLabel = new JLabel("default");
        contentPane.add(idLabel, BorderLayout.NORTH);

        favouriteLabel = new JLabel(" ");
        contentPane.add(favouriteLabel, BorderLayout.SOUTH);

        // Create the toolbar with the buttons
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(0, 1));

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> nextButton());
        toolbar.add(nextButton);

        JButton previousButton = new JButton("Previous");
        previousButton.addActionListener(e -> previousButton());
        toolbar.add(previousButton);

        JButton mapButton = new JButton("View Property on Map");
        mapButton.addActionListener(e -> viewOnMapsButton());
        toolbar.add(mapButton);

        JButton favouriteButton = new JButton("Toggle Favourite");
        favouriteButton.addActionListener(e -> toggleFavouriteButton());
        toolbar.add(favouriteButton);

        JButton statisticsButton = new JButton("View Statistics");
        statisticsButton.addActionListener(e -> viewStatistics());
        toolbar.add(statisticsButton);


        // Add toolbar into panel with flow layout for spacing
        JPanel flow = new JPanel();
        flow.add(toolbar);

        contentPane.add(flow, BorderLayout.WEST);

        // building is done - arrange the components     
        frame.pack();

        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2 - frame.getHeight() / 2);
        frame.setVisible(true);
    }

}
