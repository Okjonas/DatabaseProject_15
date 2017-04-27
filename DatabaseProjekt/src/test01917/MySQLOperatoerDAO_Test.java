package test01917;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import connector01917.Connector;
import daoimpl01917.MySQLOperatoerDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;

public class MySQLOperatoerDAO_Test {

	private static MySQLOperatoerDAO userdao = new MySQLOperatoerDAO();

	private static OperatoerDTO user1 = new OperatoerDTO(1, "user1", "u1", "010411-1452", "1ugf7&2");
	private static OperatoerDTO user2 = new OperatoerDTO(2, "user2", "u2", "020411-1452", "2ugf7&2");
	private static OperatoerDTO user3 = new OperatoerDTO(3, "user3", "u3", "030411-1452", "3ugf7&2");
	private static OperatoerDTO tempUser;

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

		try {

			userdao.createOperatoer(user1);
			userdao.createOperatoer(user2);
			userdao.createOperatoer(user3);

		} catch (DALException e) {
			System.err.println("Error in setUpBeforeClass");
			e.printStackTrace();
		}
	}

//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		try {
//			userdao.deleteUser(user1.getOprId());
//			userdao.deleteUser(user2.getOprId());
//			userdao.deleteUser(user3.getOprId());
//		} catch (DALException e) {
//			System.err.println("Error in tearDownAfterClass");
//			e.printStackTrace();
//		}
//	}

	@Before
	public void setUp() throws Exception {
		assertEquals(user1.getCpr(), userdao.getOperatoer(user1.getOprId()).getCpr());
		assertEquals(user1.getIni(), userdao.getOperatoer(user1.getOprId()).getIni());
		assertEquals(user1.getPassword(), userdao.getOperatoer(user1.getOprId()).getPassword());
		// assertEquals(user1.getRoles(),userdao.getUser(user1.getUserId()).getRoles());
		assertEquals(user1.getOprNavn(), userdao.getOperatoer(user1.getOprId()).getOprNavn());

		assertEquals(user2.getCpr(), userdao.getOperatoer(user2.getOprId()).getCpr());
		assertEquals(user2.getIni(), userdao.getOperatoer(user2.getOprId()).getIni());
		assertEquals(user2.getPassword(), userdao.getOperatoer(user2.getOprId()).getPassword());
		// assertEquals(user2.getRoles(),userdao.getUser(user2.getUserId()).getRoles());
		assertEquals(user2.getOprNavn(), userdao.getOperatoer(user2.getOprId()).getOprNavn());

		assertEquals(user3.getCpr(), userdao.getOperatoer(user3.getOprId()).getCpr());
		assertEquals(user3.getIni(), userdao.getOperatoer(user3.getOprId()).getIni());
		assertEquals(user3.getPassword(), userdao.getOperatoer(user3.getOprId()).getPassword());
		// assertEquals(user3.getRoles(),userdao.getUser(user3.getUserId()).getRoles());
		assertEquals(user3.getOprNavn(), userdao.getOperatoer(user3.getOprId()).getOprNavn());
	}

	@After
	public void tearDown() throws Exception {
		user1 = new OperatoerDTO(1, "user1", "u1", "010411-1452", "1ugf7&2");
		user2 = new OperatoerDTO(2, "user2", "u2", "020411-1452", "2ugf7&2");
		user3 = new OperatoerDTO(3, "user3", "u3", "030411-1452", "3ugf7&2");

		userdao.updateOperatoer(user1);
		userdao.updateOperatoer(user2);
		userdao.updateOperatoer(user3);
	}

	

}
