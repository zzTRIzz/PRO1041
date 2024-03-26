import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.prefs.Preferences;

public class RememberCheckBox extends JFrame {
    private JCheckBox checkBox;
    private final Preferences prefs;

    public RememberCheckBox() {
        super("Remember CheckBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        prefs = Preferences.userNodeForPackage(RememberCheckBox.class);

        checkBox = new JCheckBox("Remember Me");
        
        // Load saved state
        boolean savedState = prefs.getBoolean("checkBoxState", false);
        checkBox.setSelected(savedState);

        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Save state when checkbox is clicked
                boolean isChecked = checkBox.isSelected();
                prefs.putBoolean("checkBoxState", isChecked);
            }
        });

        add(checkBox);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RememberCheckBox::new);
    }
}
