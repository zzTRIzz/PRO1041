package gui.nhanvien;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.github.sarxos.webcam.*;
import com.github.sarxos.webcam.ds.buildin.WebcamDefaultDriver;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private QRScanner qrScanner;

    public MainFrame() {
        super("QR Scanner");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        qrScanner = new QRScanner();
        add(qrScanner, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton toggleButton = new JButton("Mở / tắt camera");
        toggleButton.addActionListener(e -> toggleCamera());
        JButton closeButton = new JButton("Đóng ứng dụng");
        closeButton.addActionListener(e -> closeApp());

        controlPanel.add(toggleButton);
        controlPanel.add(closeButton);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
    }

    private void toggleCamera() {
        qrScanner.toggleCamera();
    }

    private void closeApp() {
        qrScanner.closeCamera();
        dispose(); // Đóng cửa sổ JFrame
    }

    public static void main(String[] args) {
        // Set driver for webcam
        Webcam.setDriver(new WebcamDefaultDriver());
        
        // Create and display the main frame
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
