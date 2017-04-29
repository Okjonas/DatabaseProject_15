package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import connector01917.SQLMapper;
import dto01917.RoleDTO;
import daointerfaces01917.DALException;
import daointerfaces01917.IRoleDAO;

public class MySQLRoleDAO implements IRoleDAO {

	@Override
	public RoleDTO getRole(int roleId) throws DALException {
		
		String[] input={String.valueOf(roleId)};
		ResultSet rs = Connector.doQuery(SQLMapper.getSQL("getRole",input));
		try {
			if (!rs.first()) {
				throw new DALException("Role " + roleId + " not found");
			}
			rs.first();
			RoleDTO r = new RoleDTO(roleId, rs.getString("role"));

			return r;
		} catch (SQLException e) {
			throw new DALException(e);
		}

	}

	@Override
	public List<RoleDTO> getRoleList() throws DALException {

		List<RoleDTO> roles = new ArrayList<RoleDTO>();

		ResultSet rs = Connector.doQuery(SQLMapper.getStatement("allRoles"));

		try {
			while (rs.next()) {
				int id = rs.getInt("role_id");
				String name = rs.getString("role");

				RoleDTO r = new RoleDTO(id, name);
				roles.add(r);

			}
		} catch (SQLException e) {
			throw new DALException("SQLException");
		}

		return roles;
	}

	@Override
	public void createRole(RoleDTO role) throws DALException {
		String[] input = {String.valueOf(role.getRoleId()), role.getRoleName()};
		Connector.doUpdate(
				SQLMapper.getSQL("createRole",input));

	}

	@Override
	public void updateRole(RoleDTO role) throws DALException {
		String[] input = {String.valueOf(role.getRoleId()), role.getRoleName()};
		Connector.doUpdate(
				SQLMapper.getSQL("updateRole",input));
		
	}

	@Override
	public void deleteRole(int roleId) throws DALException {
		String[] input = {String.valueOf(roleId)};
		Connector.doUpdate(SQLMapper.getSQL("deleteRole",input)); 
	}

}
