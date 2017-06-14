package it.polito.tdp.artsmia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.artsmia.model.ArtObject;
import it.polito.tdp.artsmia.model.Coppia;
import it.polito.tdp.artsmia.model.Exhibitions;

public class ArtsmiaDAO {
	
	public List<ArtObject> listObject() {
		
		String sql = "SELECT * from objects";

		List<ArtObject> result = new ArrayList<>();

		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				result.add(new ArtObject(res.getInt("object_id"), res.getString("classification"), res.getString("continent"), 
						res.getString("country"), res.getInt("curator_approved"), res.getString("dated"), res.getString("department"), 
						res.getString("medium"), res.getString("nationality"), res.getString("object_name"), res.getInt("restricted"), 
						res.getString("rights_type"), res.getString("role"), res.getString("room"), res.getString("style"), res.getString("title")));
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
public List<Exhibitions> listExhibitions() {
	List<Exhibitions>exhibitions=new ArrayList<Exhibitions>();

		String sql = "SELECT exhibition_id,exhibition_department,exhibition_title,begin,end FROM exhibitions";


		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				exhibitions.add(new Exhibitions(res.getInt("exhibition_id"),res.getString("exhibition_department"),res.getString("exhibition_title"),res.getInt("begin"),res.getInt("end")));
			}

			conn.close();
			return exhibitions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
public List<Integer> year() {
	List<Integer> anno=new ArrayList<Integer>();
	String sql = "SELECT DISTINCT begin FROM exhibitions e ORDER BY e.`begin`";


	Connection conn = DBConnect.getConnection();

	try {
		PreparedStatement st = conn.prepareStatement(sql);

		ResultSet res = st.executeQuery();

		while (res.next()) {
			
			anno.add(res.getInt("begin"));
		}

		conn.close();
		return anno;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
public List<Exhibitions> listExhibitionsFromYear(int anno) {
	List<Exhibitions>exhibitions=new ArrayList<Exhibitions>();

	String sql = "SELECT e.exhibition_id,e.exhibition_department,e.exhibition_title,e.`begin`,e.`end` FROM exhibitions e WHERE e.`begin`>= ? ";

	Connection conn = DBConnect.getConnection();

	try {
		
		PreparedStatement st = conn.prepareStatement(sql);

		st.setInt(1, (anno));
		ResultSet res = st.executeQuery();

		while (res.next()) {
			
			exhibitions.add(new Exhibitions(res.getInt("exhibition_id"),res.getString("exhibition_department"),res.getString("exhibition_title"),res.getInt("begin"),res.getInt("end")));
		}

		conn.close();
		return exhibitions;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}

public List<Coppia>getAdiacenti(int anno){
	List<Coppia>coppia=new ArrayList<Coppia>();
	String sql="SELECT  e1.exhibition_id,e1.exhibition_department,e1.exhibition_title,e1.`begin`,e1.`end`,e2.exhibition_id,e2.exhibition_department,e2.exhibition_title,e2.`begin`,e2.`end` FROM exhibitions e1,exhibitions e2 WHERE e1.`begin`>= ? AND e2.`begin`>= ? AND e1.exhibition_id <> e2.exhibition_id AND e2.`begin`> e1.`begin` AND e1.`end`> e2.`begin`";
	Connection conn = DBConnect.getConnection();
try {
		
		PreparedStatement st = conn.prepareStatement(sql);

		st.setInt(1, (anno));
		st.setInt(2, (anno));
		ResultSet res = st.executeQuery();

		while (res.next()) {
			
			coppia.add(new Coppia((new Exhibitions(res.getInt("e1.exhibition_id"),res.getString("e1.exhibition_department"),res.getString("e1.exhibition_title"),res.getInt("e1.begin"),res.getInt("e1.end"))),new Exhibitions(res.getInt("e2.exhibition_id"),res.getString("e2.exhibition_department"),res.getString("e2.exhibition_title"),res.getInt("e2.begin"),res.getInt("e2.end"))));
		}

		conn.close();
		return coppia;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
public Exhibitions getMax(int anno){
	
	String sql="SELECT count(*)AS tot,e.exhibition_id,e.exhibition_department,e.exhibition_title,e.`begin`,e.`end` FROM exhibitions e,exhibition_objects eo,objects o WHERE eo.exhibition_id=e.exhibition_id AND eo.object_id=o.object_id AND e.`begin`>=? GROUP BY e.exhibition_id,e.exhibition_department,e.exhibition_title,e.`begin`,e.`end`  ORDER BY tot DESC " ;
	Connection conn = DBConnect.getConnection();
try {
		
		PreparedStatement st = conn.prepareStatement(sql);

		st.setInt(1, (anno-1));
	
		ResultSet res = st.executeQuery();

		if (res.next()) {
			
Exhibitions e=new Exhibitions(res.getInt("exhibition_id"),res.getString("exhibition_department"),res.getString("exhibition_title"),res.getInt("begin"),res.getInt("end"));
int max=res.getInt("tot");
return e;
		}

		conn.close();
		return null;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}

}
