package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Parola;


public class ParolaDAO {

	public List<String> getDizionario() {

		final String sql = "SELECT p.nome "
				+ "FROM parola p";

		List<String> stringheNelDizionario = new ArrayList<String>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				String p = rs.getString("nome").strip();
				stringheNelDizionario.add(p);
			}
			st.close();
			rs.close();
			conn.close();
			return stringheNelDizionario;			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
}
