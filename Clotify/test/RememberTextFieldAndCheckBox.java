import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.prefs.Preferences;

public class RememberTextFieldAndCheckBox extends JFrame {
    private JTextField textField;
    private JCheckBox checkBox;
    private final Preferences prefs;

    public RememberTextFieldAndCheckBox() {
        super("Remember TextField and CheckBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        prefs = Preferences.userNodeForPackage(RememberTextFieldAndCheckBox.class);

        textField = new JTextField(20);
        String savedText = prefs.get("textFieldText", "");
        textField.setText(savedText);

        checkBox = new JCheckBox("Remember Text");

        // Load saved state of checkbox
        boolean saveCheck = prefs.getBoolean("checkBoxState", false);
        checkBox.setSelected(saveCheck);

        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = checkBox.isSelected();
                prefs.putBoolean("checkBoxState", isChecked);
                if (!isChecked) {
                    prefs.remove("textFieldText");
                    textField.setText(""); // Clear text field if checkbox is unchecked
                } else {
                    prefs.put("textFieldText", textField.getText()); // Save text if checkbox is checked
                }
            }
        });

        // If checkbox is not selected, clear text field and remove stored text
        if (!saveCheck) {
            prefs.remove("textFieldText");
            textField.setText("");
        }

        add(textField);
        add(checkBox);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RememberTextFieldAndCheckBox::new);
    }
}
