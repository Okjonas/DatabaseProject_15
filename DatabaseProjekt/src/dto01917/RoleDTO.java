package dto01917;


public class RoleDTO{

	/**
	 * 
	 */
	private int roleId;
	private String roleName;

	public RoleDTO(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public void setRoleId(int id) {
		roleId = id;
	}
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getRoleId() {
		return roleId;
	}
	public String[] toArray(){
		String[] res = {String.valueOf(roleId),roleName};
		return res;
	}

}
