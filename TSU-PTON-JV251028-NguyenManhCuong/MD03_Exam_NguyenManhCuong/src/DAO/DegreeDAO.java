package DAO;

import entity.Degree;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;

import config.DBConnect;
public class DegreeDAO {

	public List<Degree> getAllDegrees() throws Exception{
		List<Degree> list = new ArrayList<>();
		Connection conn = DBConnect.getConnection();
		String sql = "{Call sp_get_all_degrees()}";
		CallableStatement cs = (CallableStatement) conn.prepareCall(sql);
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			Degree d = new Degree();
			d.setDergeeId(rs.getInt("degree_id"));
			d.setDegreeName(rs.getString("degree_name"));
			d.setEmpId(rs.getString("emp_id"));
			d.setDegreeDate(rs.getTimestamp("degree_date"));
			d.setSchoolName(rs.getString("school_nname"));
			d.setDegreeYear(rs.getInt("degree_year"));
			d.setDegreeClassification(rs.getString("degree_classification"));
			list.add(d);
		}
		conn.close();
		return list;
	}
	
	public void insertDegree(Degree d) throws Exception{
		Connection conn = DBConnect.getConnection();
		CallableStatement cs = (CallableStatement) conn.prepareCall("{ Call sp_insert_degree(?,?,?,?,?,?)}");
		
		cs.setString(1, d.getDegreeName());
		cs.setString(2, d.getEmpId());
		cs.setTimestamp(3, d.getDegreeDate());
		cs.setString(4, d.getSchoolName());
		cs.setInt(5, d.getDegreeYear());
		cs.setString(6, d.getDegreeClassification());
		cs.executeUpdate();
		conn.close();
	}
	
	public void updateDegree(Degree d) throws Exception{
		Connection conn = DBConnect.getConnection();
		CallableStatement cs = (CallableStatement) conn.prepareCall("{ Call sp_update_degree(?,?,?,?,?,?,?)}");
		cs.setInt(1, d.getDergeeId());
		cs.setString(2, d.getDegreeName());
		cs.setString(3, d.getEmpId());
		cs.setTimestamp(4, d.getDegreeDate());
		cs.setString(5, d.getSchoolName());
		cs.setInt(6, d.getDegreeYear());
		cs.setString(7, d.getDegreeClassification());
		cs.executeUpdate();
		conn.close();
	}
	
	public void deleteDegree(int id) throws Exception{
		Connection conn = DBConnect.getConnection();
		CallableStatement cs = (CallableStatement) conn.prepareCall("{ Call sp_delete_degree(?)}");
		cs.setInt(1, id);
		cs.executeUpdate();
		conn.close();
		
	}
	
	public List<Degree> searchByName(String name) throws Exception{
		List<Degree> list = new ArrayList<>();
		Connection conn = DBConnect.getConnection();
		String sql = "{Call sp_search_degree_by_name(?)}";
		CallableStatement cs = (CallableStatement) conn.prepareCall(sql);
		cs.setString(1, name);
		ResultSet rs = cs.executeQuery();
		
		while (rs.next()) {
			Degree d = new Degree();
			d.setDergeeId(rs.getInt("degree_id"));
			d.setDegreeName(rs.getString("degree_name"));
			d.setEmpId(rs.getString("emp_id"));
			list.add(d);
			
		}
		conn.close();
		return list;
		
	}
	
}
