package test01917;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import connector01917.Connector;
import connector01917.SQLMapper;
import daoimpl01917.MySQLOperatoerDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;
import dto01917.RoleDTO;

public class MySQLOperatoerDAO_Test {

	private static MySQLOperatoerDAO oprDao = new MySQLOperatoerDAO();

	private static OperatoerDTO opr1 = new OperatoerDTO(1, "opr1", "o1", "010411-1452", "1ugf7&2",new ArrayList<RoleDTO>());
	private static OperatoerDTO opr2 = new OperatoerDTO(2, "opr2", "o2", "020411-1452", "2ugf7&2",new ArrayList<RoleDTO>());
	private static OperatoerDTO opr3 = new OperatoerDTO(3, "opr3", "o3", "030411-1452", "3ugf7&2",new ArrayList<RoleDTO>());
	private static OperatoerDTO tempOpr;

	@BeforeClass
	public static void setUpBeforeClass() {
		try {
			Connector.connectToDatabase();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		opr1.addRole(new RoleDTO(2,null));
		opr2.addRole(new RoleDTO(3,null));
		opr3.addRole(new RoleDTO(4,null));
		try {
			oprDao.createOperatoer(opr1);
			oprDao.createOperatoer(opr2);
			oprDao.createOperatoer(opr3);

		} catch (DALException e) {
			System.err.println("Error in setUpBeforeClass");
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		try {
			oprDao.deleteOperatoer(opr1.getOprId());
			oprDao.deleteOperatoer(opr2.getOprId());
			oprDao.deleteOperatoer(opr3.getOprId());
		} catch (DALException e) {
			System.err.println("Error in tearDownAfterClass");
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {
		assertEquals(opr1.getCpr(), oprDao.getOperatoer(opr1.getOprId()).getCpr());
		assertEquals(opr1.getIni(), oprDao.getOperatoer(opr1.getOprId()).getIni());
		assertEquals(opr1.getPassword(), oprDao.getOperatoer(opr1.getOprId()).getPassword());
		// assertEquals(user1.getRoles(),userdao.getUser(user1.getUserId()).getRoles());
		assertEquals(opr1.getOprNavn(), oprDao.getOperatoer(opr1.getOprId()).getOprNavn());

		assertEquals(opr2.getCpr(), oprDao.getOperatoer(opr2.getOprId()).getCpr());
		assertEquals(opr2.getIni(), oprDao.getOperatoer(opr2.getOprId()).getIni());
		assertEquals(opr2.getPassword(), oprDao.getOperatoer(opr2.getOprId()).getPassword());
		// assertEquals(user2.getRoles(),userdao.getUser(user2.getUserId()).getRoles());
		assertEquals(opr2.getOprNavn(), oprDao.getOperatoer(opr2.getOprId()).getOprNavn());

		assertEquals(opr3.getCpr(), oprDao.getOperatoer(opr3.getOprId()).getCpr());
		assertEquals(opr3.getIni(), oprDao.getOperatoer(opr3.getOprId()).getIni());
		assertEquals(opr3.getPassword(), oprDao.getOperatoer(opr3.getOprId()).getPassword());
		// assertEquals(user3.getRoles(),userdao.getUser(user3.getUserId()).getRoles());
		assertEquals(opr3.getOprNavn(), oprDao.getOperatoer(opr3.getOprId()).getOprNavn());
	}

	@After
	public void tearDown() throws Exception {
		opr1 = new OperatoerDTO(1, "opr1", "o1", "010411-1452", "1ugf7&2",new ArrayList<RoleDTO>());
		opr2 = new OperatoerDTO(2, "opr2", "o2", "020411-1452", "2ugf7&2",new ArrayList<RoleDTO>());
		opr3 = new OperatoerDTO(3, "opr3", "o3", "030411-1452", "3ugf7&2",new ArrayList<RoleDTO>());
		
		opr1.addRole(new RoleDTO(1,null));
		opr1.addRole(new RoleDTO(2,null));
		opr2.addRole(new RoleDTO(3,null));
		opr3.addRole(new RoleDTO(4,null));
		
		
		oprDao.updateOperatoer(opr1);
		oprDao.updateOperatoer(opr2);
		oprDao.updateOperatoer(opr3);
	}
	
	
	@Test
	public void test1(){
		try {
			tempOpr=oprDao.getOperatoer(1);
			tempOpr.setIni("asd");
			oprDao.updateOperatoer(tempOpr);
			assertEquals(tempOpr.getIni(),oprDao.getOperatoer(1).getIni());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
