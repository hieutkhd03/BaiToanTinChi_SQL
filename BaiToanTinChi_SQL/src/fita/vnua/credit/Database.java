package fita.vnua.credit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/baitoantinchi";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "Duonghieutkhd123";


 // Phương thức trả về một kết nối
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// Phương thức thêm mới User
	public static void insertUser(String masv, String hodem, String ten, String gioitinh, String malop) {
		String INSERT_USERS_ACCESS = "INSERT INTO SINHVIEN (MaSV, Hodem, Ten, Gioitinh, Malop) VALUES (?,?,?,?,?)";
		// Bước 1: Thiết lập kết nối
		try (Connection connection = getConnection();
				// Bước 2: Tạo câu truy vấn
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_ACCESS)) {

			preparedStatement.setString(1, masv);
			preparedStatement.setString(2, hodem);
			preparedStatement.setString(3, ten);
			preparedStatement.setString(4, gioitinh);
			preparedStatement.setString(5, malop);

			System.out.println(preparedStatement);
			// Bước 3: Thực thi câu truy vấn
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Thêm mới thành công!");
			} else {
				System.out.println("Thêm mới không thành công!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
	// Phương thức lấy tất cả User trong bảng

	public static void selectAllUsers() {
		String SELECT_ALL_USERS_ACCESS= "SELECT * FROM SINHVIEN";
		try (Connection connection = getConnection();
				Statement statement = connection.createStatement()) {

			ResultSet rs = statement.executeQuery(SELECT_ALL_USERS_ACCESS);

			// Duyệt danh sach bản ghi trả về
			while (rs.next()) {
				String masv = rs.getString("MaSV");
				String hodem = rs.getString("Hodem");
				String ten = rs.getString("Ten");
				// Ngay sinh
				String gioitinh = rs.getString("Gioitinh");
				String malop = rs.getString("MaLop");
				
				System.out.println(masv + "," + hodem + "," + ten + "," + gioitinh + "," + malop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Phương thức kiểm tra sự tồn tại của một User
	public static void checkUser(String masv) {
		String SELECT_USERS_ACCESS = "SELECT * from SINHVIEN WHERE MaSV = ?";
		try (
			Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_ACCESS)) {
			preparedStatement.setString(1, masv);
			
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();

			boolean status = resultSet.next();
			// status = true: Co ton tai sinh vien
			if (status) {
				System.out.println("Sinh vien tồn tại!");
			} else {
				System.out.println("Sinh vien không tồn tại!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phương thức Sửa thông tin 1 sinh viên
	public static void changeUser(String ten, String tenMoi) {
		String UPDATE_USERS_ACCESS = "UPDATE SINHVIEN SET Ten = ? WHERE MaSV = ?";
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_ACCESS)) {
			preparedStatement.setString(1, tenMoi);
			preparedStatement.setString(2, ten);

			System.out.println(preparedStatement);
			int rowsUpdated = preparedStatement.executeUpdate();
			if (rowsUpdated > 0) {
			} else {
				System.out.println("Đổi tên không thành công!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phương thức xóa User
	public static void deleteUser(String masv) {
		String DELETE_USERS_ACCESS = "DELETE FROM tbluser WHERE MaSV=?";
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_ACCESS)) {
			preparedStatement.setString(1, masv);

			System.out.println(preparedStatement);
			int rowsDeleted = preparedStatement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Xóa thành công!");
			} else {
				System.out.println("Xóa không thành công!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
		//Bài 1
		public static void insertMark_1(String masv, String mamh) {
			String INSERT_USERS_ACCESS = "INSERT INTO KETQUA (MaSV, MaMH) VALUES (?,?)";
			// Bước 1: Thiết lập kết nối
			try (Connection connection = getConnection();
					// Bước 2: Tạo câu truy vấn
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_ACCESS)) {

				preparedStatement.setString(1, masv);
				preparedStatement.setString(2, mamh);
			
				System.out.println(preparedStatement);
				// Bước 3: Thực thi câu truy vấn
				int rowsInserted = preparedStatement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("Thêm mới thành công!");
				} else {
					System.out.println("Thêm mới không thành công!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//Bài 2
		public static void insertMark_2(String masv, String mamh, double diem) {
		    // Kiểm tra xem sinh viên đã tồn tại trong bảng KETQUA chưa
		    String CHECK_MARK_ACCESS = "SELECT * FROM KETQUA WHERE MaSV = ? AND MaMH = ?";
		    String UPDATE_MARK_ACCESS = "UPDATE KETQUA SET Diem = ? WHERE MaSV = ? AND MaMH = ?";
		    String ERROR_MESSAGE = "Sinh viên hoặc môn học không tồn tại.";

		    try (Connection connection = getConnection();
		         PreparedStatement checkStatement = connection.prepareStatement(CHECK_MARK_ACCESS)) {

		        checkStatement.setString(1, masv);
		        checkStatement.setString(2, mamh);

		        ResultSet resultSet = checkStatement.executeQuery();

		        // Nếu tồn tại, cập nhật điểm
		        if (resultSet.next()) {
		            try (PreparedStatement updateStatement = connection.prepareStatement(UPDATE_MARK_ACCESS)) {
		                updateStatement.setDouble(1, diem);
		                updateStatement.setString(2, masv);
		                updateStatement.setString(3, mamh);

		                int rowsUpdated = updateStatement.executeUpdate();
		                if (rowsUpdated > 0) {
		                    System.out.println("Điểm được cập nhật thành công.");
		                }
		            }
		        } else {
		            // Nếu không tồn tại, hiển thị lỗi
		            System.out.println(ERROR_MESSAGE);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		// Bài 3
		private static void showGrades(String masv) {
	        String QUERY = "SELECT MaMH, Diem FROM KETQUA WHERE MaSV = ?";

	        try (Connection connection = Database.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

	            preparedStatement.setString(1, masv);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            boolean hasData = false;
	            while (resultSet.next()) {
	                hasData = true;
	                String mamh = resultSet.getString("MaMH");
	                double diem = resultSet.getDouble("Diem");

	                System.out.println("Mã Môn Học: " + mamh + ", Điểm: " + diem);
	            }

	            if (!hasData) {
	                System.out.println("Không có thông tin điểm cho sinh viên với mã: " + masv);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
		
	 // Chạy chương trình
	public static void main(String[] args) throws ClassNotFoundException {
	
 // Thêm mới 1 sinh viên
		insertUser("12345", "Duong Minh", "Hieu", "Nam", "K66CNPMA");
		

		// In danh sách sinh viên
		selectAllUsers();

		// Kiểm tra sự tồn tại của sinh viên
		checkUser("12345");

		// Đổi thông tin của "Hieu"
		changeUser("12345", "Duong");

		// Xóa "12345"
		deleteUser("12345");

		// In lại danh sách Sinh viên để kiểm tra
		selectAllUsers(); 

		//main Bài1
		insertMark_1("12345", "9");
		
		// main Bài 2
		insertMark_2("12345", "9" , 9.2);
		
		// main Bài3
        showGrades("12345");
	}
	
} 