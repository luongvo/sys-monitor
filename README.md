# sys-monitor

Khi làm việc với các dự án lớn liên quan đến các hệ thống thời gian thực, việc theo dõi và báo cáo tình trạng của hệ thống là vô cùng quan trọng. Việc theo dõi và gửi các thông số cho quản trị viên nắm được tình hình hệ thống tốt nhất mà không cần can thiệp và phân tích log trên server.

Phải xác định rằng, thành phần theo dõi và gửi báo cáo sẽ hoạt động như là một module độc lập tách rời khỏi hệ thống. Chúng ta có 2 cách:
 - Cung cấp các service để hệ thống chính ghi lại các thông số trong quá trình hoạt động. (Cách này khi implement thì sẽ thay đổi cấu trúc module chính nếu thay đổi cơ chế theo dõi từ module monitor).
 - Thông qua công nghệ Spring AOP, cho phép module monitor tự gắn kết và module chính mà không làm thay đổi cấu trúc của nó bằng cách lắng nghe theo class hoặc bắt các luồng dữ liệu được xử lý trong module đó.

Vì đây là hướng dẫn ban đầu nên mình chỉ đơn giản làm theo cách 1.
Bên cạnh việc theo dõi, chúng ta sẽ có các job cài đặt sẵn cho mục đích báo cáo như hằng ngày, hằng tuần…
