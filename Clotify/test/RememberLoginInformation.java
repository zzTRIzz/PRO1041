import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.prefs.Preferences;

public class RememberLoginInformation extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox rememberCheckBox;
    private final Preferences prefs;

    public RememberLoginInformation() {
        super("Remember Login Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        prefs = Preferences.userNodeForPackage(RememberLoginInformation.class);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        rememberCheckBox = new JCheckBox("Remember login information");

        // Load saved state of checkbox
        boolean saveCheck = prefs.getBoolean("rememberLogin", false);
        rememberCheckBox.setSelected(saveCheck);

        // Load saved username and password if checkbox is selected
        if (saveCheck) {
            String savedUsername = prefs.get("savedUsername", "");
            String savedPassword = prefs.get("savedPassword", "");
            usernameField.setText(savedUsername);
            passwordField.setText(savedPassword);
        }

        rememberCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = rememberCheckBox.isSelected();
                prefs.putBoolean("rememberLogin", isChecked);
                if (!isChecked) {
                    prefs.remove("savedUsername");
                    prefs.remove("savedPassword");
                } else {
                    prefs.put("savedUsername", usernameField.getText());
                    prefs.put("savedPassword", new String(passwordField.getPassword()));
                }
            }
        });

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(rememberCheckBox);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RememberLoginInformation::new);
    }
}
