package flight;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Flight extends JFrame{
    JLabel citiesLabel = new JLabel();
    JList citiesList = new JList();
    JScrollPane citiesScrollPane = new JScrollPane();
    JLabel seatLabel = new JLabel();
    JComboBox seatComboBox = new JComboBox();
    JLabel mealLabel = new JLabel();
    JComboBox mealComboBox = new JComboBox();
    JButton assignButton = new JButton();
    JButton exitButton = new JButton();

    public static void main(String[] args) {
        new Flight();
    }

    public Flight(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setTitle("Flight Planner");
        //setResizable(false);
        setVisible(true);
        setIconImage(new ImageIcon("plane.png").getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setLayout(new GridBagLayout());

        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //Toolkit.getDefaultToolkit().getScreenSize();
        //setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height-getHeight()-getHeight())), getWidth(), getHeight());
        //setLocation(screenSize.width/2 - getWidth()/2, screenSize.height/2 - getHeight()/2);
        GridBagConstraints gridConstraints;
        citiesLabel.setText("Destination City");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        add(citiesLabel, gridConstraints);

        citiesScrollPane.setViewportView(citiesList);
        gridConstraints = new GridBagConstraints();
        citiesScrollPane.setPreferredSize(new Dimension(150, 100));
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        add(citiesScrollPane, gridConstraints);


        seatLabel.setText("Seat Location");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        add(seatLabel, gridConstraints);

        seatComboBox.setBackground(Color.WHITE);
        gridConstraints = new GridBagConstraints();
        seatComboBox.setPreferredSize(new Dimension(100, 25));
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        gridConstraints.anchor = GridBagConstraints.NORTH;
        add(seatComboBox, gridConstraints);


        mealLabel.setText("Meal Preference");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        add(mealLabel, gridConstraints);

        mealComboBox.setEditable(true);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        gridConstraints.anchor = GridBagConstraints.NORTH;
        add(mealComboBox, gridConstraints);

        assignButton.setText("Assign");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(0, 0, 10, 0);
        add(assignButton, gridConstraints);
        assignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                assignButtonActionPerformed(e);
            }
        });

        exitButton.setText("Exit");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(0, 0, 10, 0);
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitButtonActionPerformed(e);
            }
        });
        pack();

        DefaultListModel citiesListModel = new DefaultListModel();
        citiesListModel.addElement("San Diego");
        citiesListModel.addElement("Los Angeles");
        citiesListModel.addElement("Orange County");
        citiesListModel.addElement("Ontario");
        citiesListModel.addElement("Bakerfield");
        citiesListModel.addElement("Oakland");
        citiesListModel.addElement("Sacramento");
        citiesListModel.addElement("San Jose");
        citiesListModel.addElement("San Francisco");
        citiesListModel.addElement("Eureka");
        citiesListModel.addElement("Eugene");
        citiesListModel.addElement("Portland");
        citiesListModel.addElement("Spokane");
        citiesListModel.addElement("Seattle");
        citiesList.setModel(citiesListModel);

        seatComboBox.addItem("Aisle");
        seatComboBox.addItem("Middle");
        seatComboBox.addItem("Window");
        seatComboBox.setSelectedIndex(0);

        mealComboBox.addItem("Chicken");
        mealComboBox.addItem("Mystery Meat");
        mealComboBox.addItem("Kosher");
        mealComboBox.addItem("Vegetarian");
        mealComboBox.addItem("Fruit Plate");
        mealComboBox.setSelectedItem("No Preference");
    }
    private void assignButtonActionPerformed(ActionEvent e) {
        String message;
        message = "Destination: " + citiesList.getSelectedValue() + "\n";
        message += "Seat Location: " + seatComboBox.getSelectedItem() + "\n";
        message += "Meal: " + mealComboBox.getSelectedItem() + "\n";
        JOptionPane.showConfirmDialog(null, message, "Your Assignment", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
    private void exitButtonActionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
