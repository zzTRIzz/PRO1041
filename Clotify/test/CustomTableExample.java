import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableExample extends JFrame {
    private JTable table;

    public CustomTableExample() {
        setTitle("Custom Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Dữ liệu mẫu
        Object[][] data = {
                {1, "Item 1", 100},
                {2, "Item 2", 200},
                {3, "Item 3", 300}
        };

        // Tiêu đề cột
        String[] columnNames = {"ID", "Name", "Value"};

        // Tạo bảng với dữ liệu mẫu
        table = new JTable(data, columnNames);

        // Renderer tùy chỉnh cho cột cuối cùng (cột số 2)
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // Lấy giá trị của cột cuối cùng (cột số 2)
                Object lastColumnValue = table.getValueAt(row, table.getColumnCount() - 1);
                
                // Đổi màu nền của ô dữ liệu cuối cùng nếu giá trị lớn hơn 200
                if (lastColumnValue instanceof Integer && (Integer) lastColumnValue > 200) {
                    cellComponent.setBackground(Color.RED);
                } else {
                    cellComponent.setBackground(Color.WHITE);
                }
                
                return cellComponent;
            }
        };

        // Đặt renderer cho cột cuối cùng
        table.getColumnModel().getColumn(columnNames.length - 1).setCellRenderer(cellRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomTableExample example = new CustomTableExample();
            example.setVisible(true);
        });
    }
}
