package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.PreparedStatement;


public class ModelSoci {
	// Nombre de los campos de la tabla cadetes de la BD
	private final String ID = "id_soci";
	private final String NOM = "nom";
	private final String COGNOM = "cognoms";
	private final String DNI = "dni";
	private final String DOMICILI = "domicili";
	private final String LOCALITAT = "localitat";
	private final String TIPUS = "tipus_soci";
	private final String IMPORT = "import_quota";

	
	private Connection conexion;
	private ResultSet resultado;
	private Statement statement;
	
	public ModelSoci() {
		//Conexion a la BD
		BD bd=BD.getInstance();
		conexion=bd.getConexion();
	}
	
	public ArrayList<Soci> consultaImpagaments(){
		ArrayList<Soci> socis = new ArrayList<Soci>();
		try {
			statement = conexion.createStatement();
			resultado = statement.executeQuery("SELECT `quotes`.`import_quota`, `socis`.`nom`, `socis`.`cognoms` FROM quotes INNER JOIN socis ON `quotes`.`id_soci`=`socis`.`id_soci` ");
			while (resultado.next()) {
				// asignamos los dato a un nuevo cadete
				Soci s = new Soci();
				s.setNom(resultado.getString(NOM));
				s.setCognom(resultado.getString(COGNOM));
				s.setImportQuota(resultado.getFloat(IMPORT));
				// añadimos cadete al aRraylist
				socis.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();//cerramos statement
				resultado.close();// cerramos resultset
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return socis;
	}
	
	public Soci consultaSoci(String idSoci){
		Soci s = new Soci();
		try {
			statement = conexion.createStatement();
			resultado = statement.executeQuery("SELECT * from socis WHERE id_soci="+idSoci);
			while (resultado.next()) {
				// asignamos los dato a un nuevo cadete
				s.setNom(resultado.getString(NOM));
				s.setId(resultado.getInt(ID));
				s.setCognom(resultado.getString(COGNOM));
				s.setTipusSoci(resultado.getString(TIPUS));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();//cerramos statement
				resultado.close();// cerramos resultset
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	public Soci consultaSoci(String nom,String cognom){
		Soci s = new Soci();
		String sqlSoci="";
		try {
			statement = conexion.createStatement();
			if(((nom.trim()).length()>0)&&((cognom.trim()).length()>0))
				sqlSoci="SELECT * from socis WHERE nom='"+nom+"'AND cognoms='"+cognom+"'";
			else if(((nom.trim()).length()>0))
				sqlSoci="SELECT * from socis WHERE nom='"+nom+"'";
			else if(((cognom.trim()).length()>0))
				sqlSoci="SELECT * from socis WHERE cognoms='"+cognom+"'";
			resultado = statement.executeQuery(sqlSoci);
			while (resultado.next()) {
				// asignamos los dato a un nuevo cadete
				s.setNom(resultado.getString(NOM));
				s.setId(resultado.getInt(ID));
				s.setCognom(resultado.getString(COGNOM));
				s.setLocalitat(resultado.getString(LOCALITAT));
				s.setTipusSoci(resultado.getString(TIPUS));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();//cerramos statement
				resultado.close();// cerramos resultset
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	public void actualitzaSoci(Soci s){
		try {
			String sqlUpdate="UPDATE socis set "+TIPUS+"=? WHERE "+ID+"="+s.getId();
			PreparedStatement updateSoci = conexion.prepareStatement(sqlUpdate);
			//Añadimos el dato del tipus de Soci, si se necesita hacer mas actualizaciones se realizarían de la misma forma
			updateSoci.setString(1, s.getTipusSoci());
			updateSoci.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
