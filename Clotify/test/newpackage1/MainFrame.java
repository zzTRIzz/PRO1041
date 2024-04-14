package newpackage1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private JDesktopPane desktopPane;

    public MainFrame() {
        setTitle("Ứng dụng Java Swing với JInternalFrame");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo Desktop Pane để chứa các JInternalFrame
        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        // Tạo menu bar và các menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu1 = new JMenu("Menu 1");
        JMenu menu2 = new JMenu("Menu 2");

        menuBar.add(menu1);
        menuBar.add(menu2);

        // Tạo các JMenuItem cho Menu 1 và Menu 2
        JMenuItem menuItem1 = new JMenuItem("One");
        JMenuItem menuItem2 = new JMenuItem("Two");

        menu1.add(menuItem1);
        menu2.add(menuItem2);

        // Xử lý sự kiện cho menuItem1
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInternalFrameOne();
            }
        });

        // Xử lý sự kiện cho menuItem2
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInternalFrameTwo();
            }
        });
    }

    // Phương thức tạo JInternalFrame One
    private void createInternalFrameOne() {
        JInternalFrame internalFrame = new JInternalFrame("Internal Frame One", true, true, true, true);
        internalFrame.setSize(200, 200);
        internalFrame.setVisible(true);
        desktopPane.add(internalFrame);
    }

    // Phương thức tạo JInternalFrame Two
    private void createInternalFrameTwo() {
        JInternalFrame internalFrame = new JInternalFrame("Internal Frame Two", true, true, true, true);
        internalFrame.setSize(200, 200);
        
        // Thêm chức năng quét QR Code vào InternalFrame Two
        JButton scanQRButton = new JButton("Quét QR Code");
        scanQRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Viết mã xử lý quét QR Code ở đây
                JOptionPane.showMessageDialog(MainFrame.this, "Chức năng quét QR Code sẽ được triển khai ở đây.");
            }
        });
        internalFrame.add(scanQRButton, BorderLayout.CENTER);
        
        internalFrame.setVisible(true);
        desktopPane.add(internalFrame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }
}
