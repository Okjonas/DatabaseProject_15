package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.util.ArrayList;

import connector01917.Connector;
import connector01917.SQLMapper;
import daointerfaces01917.DALException;
import daointerfaces01917.OperatoerDAO;
import dto01917.OperatoerDTO;
import dto01917.RoleDTO;

public class MySQLOperatoerDAO implements OperatoerDAO {
	
	
	
	public OperatoerDTO getOperatoer(int oprId) throws DALException {
		int id;
		String name, ini, cpr, password;
		List<RoleDTO> roles=new ArrayList<RoleDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM allOperatoere WHERE opr_id = " + oprId);
	    try {
	    	if (!rs.first()) throw new DALException("Operatoeren " + oprId + " findes ikke");
//	    	return new OperatoerDTO (rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"));
			id = rs.getInt("opr_id");
			name = rs.getString("opr_navn");
			ini = rs.getString("ini");
			cpr = rs.getString("cpr");
			password = rs.getString("password");
			roles.add(new RoleDTO(rs.getInt("role_id"), rs.getString("role")));

		while (rs.next()) {
			roles.add(new RoleDTO(rs.getInt("role_id"), rs.getString("role")));
		}

		OperatoerDTO opr = new OperatoerDTO(id, name, ini, cpr, password, roles);

		return opr;
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	
	public void createOperatoer(OperatoerDTO opr) throws DALException {
		Connector.doUpdate(
				SQLMapper.getSQL("createOperatoer",opr.toArray()));
		if(opr.getRoles().size()>1){
			for(int i =1;i<opr.getRoles().size();i++)
				Connector.doUpdate(SQLMapper.getSQL("addRole", String.valueOf(opr.getOprId()),String.valueOf(opr.getRoles().get(i).getRoleId())));
		}
		
	}
	
	public void updateOperatoer(OperatoerDTO opr) throws DALException {
		Connector.doUpdate(SQLMapper.getSQL("updateOperatoer",opr.toArray()));
		if(opr.getRoles().size()>1){
			for(int i =1;i<opr.getRoles().size();i++)
				Connector.doUpdate(SQLMapper.getSQL("addRole", String.valueOf(opr.getOprId()),String.valueOf(opr.getRoles().get(i).getRoleId())));
		}
	}
	
	public List<OperatoerDTO> getOperatoerList() throws DALException {
		List<OperatoerDTO> list = new ArrayList<OperatoerDTO>(1);
		int id;
		String name, ini, cpr, password;
		List<RoleDTO> roles = new ArrayList<RoleDTO>();

		ResultSet rs = Connector.doQuery(SQLMapper.getStatement("allOperatoere"));
		int tempID = 0;
		try {
			while (rs.next()) {
				if (rs.getInt("opr_id") == tempID) {
					list.get(list.size() - 1).addRole(new RoleDTO(rs.getInt("role_id"), rs.getString("role")));
				} else {
					id = rs.getInt("opr_id");
					name = rs.getString("opr_navn");
					ini = rs.getString("ini");
					cpr = rs.getString("cpr");
					password = rs.getString("password");
					
					roles.add(new RoleDTO(rs.getInt("role_id"), rs.getString("role")));
					
					list.add(new OperatoerDTO(id, name, ini, cpr, password, roles));
					tempID = rs.getInt("opr_id");
				}
			}
		} 
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
	public void deleteOperatoer(int opr_id) throws DALException{
		Connector.doUpdate(SQLMapper.getSQL("deleteOperatoer", String.valueOf(opr_id)));
	}
}
	
