package newpackage2;
public class Main {
    public static void main(String[] args) {
        String str100 = "100" + "    ";
        String str1000 = "1000" + "      ";

        // Độ dài của chuỗi có số lượng ký tự là 100 và 1000
        int length100 = str100.length();
        int length1000 = str1000.length();

        // Sự khác biệt trong độ dài
        int difference = length1000 - length100;

        // Giảm độ dài của chuỗi có số lượng ký tự là 1000 thêm một bậc
        str1000 = str1000.substring(0, length1000 - difference);

        // Kiểm tra độ dài của hai chuỗi
        System.out.println("Chuỗi có số lượng ký tự là 100: " + str100.length());
        System.out.println("Chuỗi có số lượng ký tự là 1000: " + str1000.length());
    }
}
