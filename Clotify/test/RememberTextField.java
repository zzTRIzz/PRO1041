import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;

public class RememberTextField extends JFrame {
    private JTextField textField;
    private final Preferences prefs;

    public RememberTextField() {
        super("Remember TextField");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        prefs = Preferences.userNodeForPackage(RememberTextField.class);

        textField = new JTextField(20);
        String savedText = prefs.get("textFieldText", "");
        textField.setText(savedText);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveTextField());

        add(textField);
        add(saveButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void saveTextField() {
        String text = textField.getText();
        prefs.put("textFieldText", text);
        JOptionPane.showMessageDialog(this, "Text saved successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RememberTextField::new);
    }
}
