package newpackage1;
import com.github.sarxos.webcam.Webcam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.*;
import com.google.zxing.client.j2se.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class TrangNhanVien extends JInternalFrame {

    private Webcam webcam;

    public TrangNhanVien() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Trang Nhân Viên");
        setSize(400, 300);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        JButton scanButton = new JButton("Quét QR Code");
        scanButton.addActionListener(e -> {
            String qrCodeData = quetQRCode();
            JOptionPane.showMessageDialog(TrangNhanVien.this, "QR Code: " + qrCodeData);
        });
        add(scanButton, BorderLayout.CENTER);
    }

    private String quetQRCode() {
    // Sử dụng Camera để quét QR Code
    Webcam webcam = Webcam.getDefault();
    webcam.setViewSize(new Dimension(640, 480));

    // Tạo một luồng riêng để quét QR code
    Thread quetQRCodeThread = new Thread(() -> {
        try {
            webcam.open();
            Result result = null;

            do {
                if (webcam.isOpen()) {
                    BufferedImage image = webcam.getImage();
                    if (image == null) {
                        continue;
                    }

                    LuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                    try {
                        result = new MultiFormatReader().decode(bitmap);
                    } catch (NotFoundException e) {
                        // Không tìm thấy mã QR, tiếp tục quét
                    }
                }
            } while (result == null);

            webcam.close();

            // Hiển thị kết quả trong giao diện
            final String qrCodeData = result.getText();
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(TrangNhanVien.this, "QR Code: " + qrCodeData);
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(TrangNhanVien.this, "Không thể quét QR Code: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    });

    quetQRCodeThread.start();
        return null;
}
}