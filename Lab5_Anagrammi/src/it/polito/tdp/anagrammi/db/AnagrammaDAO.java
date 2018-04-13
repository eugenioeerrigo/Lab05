package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import it.polito.tdp.anagrammi.model.Anagramma;

public class AnagrammaDAO {

public boolean isCorrect(Anagramma a) {
		
		String sql = "SELECT nome " + 
				"FROM parola";
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				String curr = res.getString("nome");
				if(curr.compareTo(a.toString())==0)
					return true;
			}
			
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}


}
