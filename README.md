# Email_client
- Đây là project bài tập kết thúc môn Lập trình mạng
- Báo cáo word và powerpoint lưu vào thư mục documents
- IDE: Apache Netbeans (mới nhất) chỉ cần ít nhất trong phiên bản 12 cũng được
- JDK: JDK 14 trở lên
- Vui lòng để lại comment trong dòng code để các thành viên hiểu function của code
# Mục tiêu
- Chú ý: các mục tiêu các thành viên có thể add thêm
1. Có đầy đủ chức năng gửi thư và fetch đc nội dung hộp thư đến của tài khoản
2. Có thể thêm nhiều tài khoản
3. Kiểm tra định dạnh email hợp lệ
4. Có thể đính kèm tập tin để gửi
5. Có tính năng đề xuất gì mới thì thêm vào
# Look and Feed (Hay gọi là giao diện cũng được)
- Giao diện: Flatlaf Light
- Class dùng chung: lookandfeel.java (folder global)
- Cách goi: lookandfeel.setTheme();
- Thêm vào sau: public static void main(String args[]) { .... }
- Trước khi thêm vui lòng xóa: Look and feel settings code (optional) trong public static void main(String args[]) { .... }
# Các thư viện hỗ trợ
1. activation.jar
2. javax.mail-1.6.2.jar
3. sqlite-jdbc-3.36.0.3.jar
4. flatlaf-2.3.jar (chính là giao diện đó)
