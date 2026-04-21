package service;
import entity.Degree;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

import config.DBConnect;
import DAO.DegreeDAO;

public class DegreeService {
	
	public final DegreeDAO dao = new DegreeDAO();
	public final Scanner sc = new Scanner(System.in);
	public void showAll() throws Exception{
		List<Degree> list = dao.getAllDegrees();
		System.out.printf( 
				"%-5s %-30s %-10s %-20s %-25s %-6s %-15s%n",
				"ID", "Degree Name", "EmpID", "Date", "School", "Year", "Classtification"
				);
		
		for (Degree d : list) {
			System.out.printf( 
					"%-5s %-30s %-10s %-20s %-25s %-6s %-15s%n",
					d.getDergeeId(),
					d.getDegreeName(),
					d.getEmpId(),
					d.getDegreeDate(),
					d.getSchoolName(),
					d.getDegreeYear(),
					d.getDegreeClassification()
					);
		}
	}
	
	public void add() throws Exception{
		Degree d = new Degree();
		
		 d.setDegreeName(inputNotEmpty("Tên bằng cấp: "));
	     d.setEmpId(inputNotEmpty("Emp ID (Emp001): "));
	     d.setDegreeDate(new Timestamp(System.currentTimeMillis()));
	     d.setSchoolName(inputNotEmpty("Tên trường: "));
	     d.setDegreeYear(inputYear("Năm cấp: "));
	     d.setDegreeClassification(inputNotEmpty("Xếp loại: "));
	     dao.insertDegree(d);
	        System.out.println("Thêm thành công");
	}
	
	 public void update() throws Exception {
	        Degree d = new Degree();

	        d.setDergeeId(inputInt("ID cần cập nhật: "));
	        d.setDegreeName(inputNotEmpty("Tên bằng cấp: "));
	        d.setEmpId(inputNotEmpty("Emp ID (Emp001): "));
	        d.setDegreeDate(new Timestamp(System.currentTimeMillis()));
	        d.setSchoolName(inputNotEmpty("Tên trường: "));
	        d.setDegreeYear(inputYear("Năm cấp: "));
	        d.setDegreeClassification(inputNotEmpty("Xếp loại: "));

	        dao.updateDegree(d);
	        System.out.println("Cập nhật thành công");
	    }

	    public void delete() throws Exception {
	        System.out.print("ID cần xóa: ");
	        dao.deleteDegree(Integer.parseInt(sc.nextLine()));
	        System.out.println("Xóa thành công");
	    }

	    public void search() throws Exception {
	        System.out.print("Nhập tên: ");
	        dao.searchByName(sc.nextLine())
	                .forEach(d ->
	                        System.out.println(d.getDergeeId() + " | " + d.getDegreeName()));
	    }
	
	
	public String inputNotEmpty(String mess) {
		String input;
		do {
			System.out.println(mess);
			input = sc.nextLine().trim();
			if (input.isEmpty()) {
				System.out.println("Not Emptry!");
			}
		} while (input.isEmpty());
		return input;
		
	}
	
	public int inputInt(String mess) {
		while (true) {
			try {
				if (!mess.isEmpty()) System.out.print(mess);
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Buoc phai nhap so!");
			}
		}
	}
	
	public int inputYear(String mess) {
		int year;
		int currentYear = Year.now().getValue();
		while (true) {
			year = inputInt(mess);
			if(year >= 1980 && year <= currentYear) {
				return year;
			}
			System.out.println("Nam phai lon hon 1980 va nho hon " + currentYear);
			
		}
	}
	
	
	
	
	
}
