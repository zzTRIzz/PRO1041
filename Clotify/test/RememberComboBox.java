import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.prefs.Preferences;

public class RememberComboBox extends JFrame {
    private JComboBox<String> comboBox;
    private final Preferences prefs;

    public RememberComboBox() {
        super("Remember ComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        prefs = Preferences.userNodeForPackage(RememberComboBox.class);

        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        comboBox = new JComboBox<>(items);
        
        // Load saved selection
        int savedIndex = prefs.getInt("comboBoxIndex", 0);
        comboBox.setSelectedIndex(savedIndex);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Save selection when an item is selected
                int selectedIndex = comboBox.getSelectedIndex();
                prefs.putInt("comboBoxIndex", selectedIndex);
            }
        });

        add(comboBox);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RememberComboBox::new);
    }
}
