package br.com.cadastrocliente.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastrocliente.dominio.Cidade;
import br.com.cadastrocliente.dominio.Estado;

public class DAO {
	public List<Estado> todos(){
		List<Estado> lista = new ArrayList<Estado>();
		Connection co = null; //Estabelece a comunicação com o mysql
		PreparedStatement pst = null; // 
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			co = DriverManager.getConnection("jdbc:mysql://localhost:3306/cidades?serverTimezone=UTC","root","");
			
			String consulta = ("Select * from estado");
			
			pst = co.prepareStatement(consulta);
			
			rs = pst.executeQuery();		
			
			while(rs.next()) {
				lista.add(new Estado(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4)));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			finally {
				try {
					co.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		return lista;
	}
}
		
		
public List<Cidade> listarCidades(int id){
			
			Connection cn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			List<Cidade> lista = new ArrayList<Cidade>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cidades?serverTimezone=UTC","root",""); // o caminho do banco de dado
				String consulta = ("Select * from cidade where estado=?");
				pst = cn.prepareStatement(consulta);
				
				pst.setInt(1,id);
				rs= pst.executeQuery();
				
				
				while(rs.next()) {
					lista.add(new Cidade(rs.getInt(1), rs.getString(2), rs.getInt(3)));
				
				
				
				
				}//fim do while
			
			
			} //fim do try
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
		
		finally {
			try {cn.close();} catch (Exception e) {e.printStackTrace();}
		}// fim do finally
			return lista;
		
		}// fim do List<Cidade> listarCidades()
	}




