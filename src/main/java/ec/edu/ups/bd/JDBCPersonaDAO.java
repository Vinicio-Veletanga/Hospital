package ec.edu.ups.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.model.Persona;

public class JDBCPersonaDAO extends JDBCGenericDAO<Persona, String> implements PersonaDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Persona entity) {
		connection.insertBD("INSERT INTO public.\"Persona\"(cedula, nombres, apellidos, direccion, telefono, correo, rol, password)\n"
				+ "	VALUES ("
				+ "'" + entity.getCedula() + "', "
				+ "'" + entity.getNombres() +"', "
				+ "'" + entity.getApellidos() + "', "
				+ "'" + entity.getDireccion() + "', "
				+ "'" + entity.getTelefono() + "', "
				+ "'" + entity.getCorreo() + "' , "
				+ "'" + entity.getRol() + "' , "	
				+ "'" + entity.getPassword() + "');");
	}

	@Override
	public Persona read(String id) {
		Persona persona = null;
		ResultSet resultSet = connection.queryBD("SELECT *\n"
				+ "	FROM public.\"Persona\" p WHERE p.cedula =  '" + id + "'");
		
		try {
			if (resultSet != null && resultSet.next()) {
				persona = new Persona(resultSet.getInt("id_persona"), resultSet.getString("cedula"), resultSet.getString("apellidos"), 
									resultSet.getString("nombres"), resultSet.getString("direccion"), resultSet.getString("telefono"),
									resultSet.getString("correo"), resultSet.getString("rol"), resultSet.getString("password")
						);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return persona;
	}

	@Override
	public void update(Persona entity) {
		connection.insertBD("UPDATE Persona SET nombres = " + entity.getNombres() + ", apellidos = " + entity.getApellidos() 
		+ ", cedula = " + entity.getCedula() + ", direccion = " + entity.getDireccion() + 
		", telefono = " + entity.getTelefono() + 
		", correo = " + entity.getCorreo() + ", password = " + entity.getPassword()
		+ "WHERE id_persona = " + entity.getIDPersona()
	);
		
	}

	@Override
	public void delete(Persona entity) {
		connection.insertBD("DELETE FROM Persona p WHERE p.id_persona = " + entity.getIDPersona());
		
	}

	@Override
	public List<Persona> find() {
		List<Persona> usuarios = new ArrayList<Persona>();
		ResultSet resultSet = connection.queryBD("SELECT *\n"
				+ "	FROM public.\"Persona\" p; ");
		
		
		try {
			while (resultSet.next()) {
				usuarios.add(new Persona(resultSet.getInt("id_persona"), resultSet.getString("cedula"), resultSet.getString("nombres"), 
										 resultSet.getString("apellidos"), resultSet.getString("direccion"), 
										 resultSet.getString("telefono"), resultSet.getString("correo"), 
										 resultSet.getString("rol"), resultSet.getString("password"))
							);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:allMedico): " + e.getMessage());
		}
		return usuarios;
	}

	@Override
	public Persona getEmailbyUsername(String email) {
		Persona persona = null;
		ResultSet resultSet = connection.queryBD("SELECT *\n"
				+ "	FROM public.\"Persona\" p WHERE p.correo =  '" + email + "'");
		
		try {
			if (resultSet != null && resultSet.next()) {
				persona = new Persona(resultSet.getInt("id_persona"), resultSet.getString("cedula"), resultSet.getString("apellidos"), 
									resultSet.getString("nombres"), resultSet.getString("correo"), resultSet.getString("direccion"),
									resultSet.getString("telefono"), resultSet.getString("rol"), resultSet.getString("password")
						);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return persona;
	}

	@Override
	public List<Persona> allSecretaria() {
		List<Persona> secretarias = new ArrayList<Persona>();
		ResultSet resultSet = connection.queryBD("SELECT *\n"
				+ "	FROM public.\"Persona\" p WHERE p.rol = 'Secretaria' ; ");
		
		
		try {
			while (resultSet.next()) {
				secretarias.add(new Persona(resultSet.getInt("id_persona"), resultSet.getString("cedula"), resultSet.getString("nombres"), 
										 resultSet.getString("apellidos"), resultSet.getString("direccion"), 
										 resultSet.getString("telefono"), resultSet.getString("correo"), 
										 resultSet.getString("rol"), resultSet.getString("password"))
							);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:allMedico): " + e.getMessage());
		}
		return secretarias;
	}

	@Override
	public List<Persona> allMedico() {
		List<Persona> doctores = new ArrayList<Persona>();
		ResultSet resultSet = connection.queryBD("SELECT *\n"
				+ "	FROM public.\"Persona\" p WHERE p.rol = 'Doctor' ; ");
		
		
		try {
			while (resultSet.next()) {
				doctores.add(new Persona(resultSet.getInt("id_persona"), resultSet.getString("cedula"), resultSet.getString("nombres"), 
										 resultSet.getString("apellidos"), resultSet.getString("direccion"), 
										 resultSet.getString("telefono"), resultSet.getString("correo"), 
										 resultSet.getString("rol"), resultSet.getString("password"))
							);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:allMedico): " + e.getMessage());
		}
		return doctores;
	}

	@Override
	public List<Persona> allAdmin() {
		List<Persona> administradores = new ArrayList<Persona>();
		ResultSet resultSet = connection.queryBD("SELECT *\n"
				+ "	FROM public.\"Persona\" p WHERE p.rol = 'Administrador' ; ");
		
		
		try {
			while (resultSet.next()) {
				administradores.add(new Persona(resultSet.getInt("id_persona"), resultSet.getString("cedula"), resultSet.getString("nombres"), 
										 resultSet.getString("apellidos"), resultSet.getString("direccion"), 
										 resultSet.getString("telefono"), resultSet.getString("correo"), 
										 resultSet.getString("rol"), resultSet.getString("password"))
							);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:allMedico): " + e.getMessage());
		}
		return administradores;
	}

}
