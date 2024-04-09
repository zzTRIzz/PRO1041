import java.time.LocalDate;

public class CheckDate {
    public static void main(String[] args) {
        // Ngày bất kỳ
        LocalDate ngayBatKy = LocalDate.of(2024, 4, 1);

        // Ngày hiện tại
        LocalDate ngayHienTai = LocalDate.now();

        // Kiểm tra xem ngày hiện tại có sau ngày bất kỳ hay không
        if (ngayHienTai.isAfter(ngayBatKy)) {
            // Nếu có, thực hiện hành động tương ứng
            System.out.println("Ngày hiện tại là sau ngày bất kỳ.");
            // Thực hiện đổi trạng thái từ hoạt động thành không hoạt động ở đây
        } else {
            // Nếu không, không thực hiện hành động gì
            System.out.println("Ngày hiện tại không phải sau ngày bất kỳ.");
        }
    }
}
