package daointerfaces01917;

import java.util.List;


import dto01917.RoleDTO;
import daointerfaces01917.DALException;

public interface RoleDAO {
	
	RoleDTO getRole(int roleId) throws DALException;
	List<RoleDTO> getRoleList() throws DALException;
	void createRole(RoleDTO role) throws DALException;
	void updateRole(RoleDTO role) throws DALException;
	void deleteRole(int roleId) throws DALException;
}
