package newpackage1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

public class Main_admin extends JFrame {
    private JDesktopPane desktopPane;

    public Main_admin() {
        initComponents();
        init();
        trang1();
    }

    private void initComponents() {
        setTitle("Main Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Menu 1");
        JMenuItem item1 = new JMenuItem("Trang 1");
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trang1();
            }
        });
        menu1.add(item1);
        menuBar.add(menu1);

        JMenu menu2 = new JMenu("Menu 2");
        JMenuItem item2 = new JMenuItem("Trang 2");
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trang2();
            }
        });
        menu2.add(item2);
        menuBar.add(menu2);

        setJMenuBar(menuBar);

        desktopPane = new JDesktopPane();
        add(desktopPane);
    }

    private void init() {
        setLocationRelativeTo(null);
        // Set label text
    }

    private void trang1() {
        System.out.println("Truy cap menu : 1");
        desktopPane.removeAll();
        TrangSP trang1 = new TrangSP();
        trang1.setSize(desktopPane.getSize());
        desktopPane.add(trang1).setVisible(true);
    }

    private void trang2() {
        System.out.println("Truy cap menu : 2");
        desktopPane.removeAll();
        TrangNhanVien trang2 = new TrangNhanVien();
        trang2.setSize(desktopPane.getSize());
        desktopPane.add(trang2).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main_admin().setVisible(true);
            }
        });
    }
}
