package newpackage1;
import javax.swing.*;
import java.awt.*;

public class TrangSP extends JInternalFrame {
    public TrangSP() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Trang Sản Phẩm");
        setSize(400, 300);
        setClosable(true); // Cho phép đóng frame
        setMaximizable(true); // Cho phép phóng to frame
        setResizable(true); // Cho phép điều chỉnh kích thước frame

        JLabel label = new JLabel("Đây là Trang Sản Phẩm");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
