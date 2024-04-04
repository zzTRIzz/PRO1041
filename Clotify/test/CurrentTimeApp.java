import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeApp extends JFrame {
    private JLabel timeLabel;

    public CurrentTimeApp() {
        setTitle("Hiển thị thời gian hiện tại");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel();
        updateTime();
        add(timeLabel);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        timeLabel.setText("Thời gian hiện tại: " + sdf.format(now));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CurrentTimeApp::new);
    }
}
