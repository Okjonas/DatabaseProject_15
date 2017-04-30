package test01917;

import daoimpl01917.MySQLOperatoerDAO;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;
import dto01917.RoleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

import connector01917.Connector;
import connector01917.SQLMapper;

public class Main {
	public static void main(String[] args) {
		try {
			Connector.connectToDatabase();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			
			

			
// TEST1			
//			MySQLProduktBatchDAO r = new MySQLProduktBatchDAO();
//			ProduktBatchDTO dto= new ProduktBatchDTO(27, 5, 1);
//			r.createProduktBatch(dto);
//			dto.setStatus(4);
//			r.updateProduktBatch(dto);
//			dto=r.getProduktBatch(27);
//			System.out.println(dto.getStatus());
//			MySQLProduktBatchKompDAO t = new MySQLProduktBatchKompDAO();
//			ProduktBatchKompDTO dto1= new ProduktBatchKompDTO(27, 1, 1, 2, 12);
//			t.createProduktBatchKomp(dto1);
//			dto1.setOprId(11);
//			t.updateProduktBatchKomp(dto1);
//			dto1=t.getProduktBatchKomp(27, 1);
//			System.out.println(dto1.getOprId());
			

// TEST2			
//			MySQLRaavareBatchDAO rb = new MySQLRaavareBatchDAO();
//			RaavareBatchDTO dto2= new RaavareBatchDTO(27, 1, 1);
//			rb.createRaavareBatch(dto2);
//			dto2.setMaengde(12);
//			rb.updateRaavareBatch(dto2);
//			dto2=rb.getRaavareBatch(27);
//			System.out.println(dto2.getMaengde());
			
// TEST3
//			MySQLRaavareDAO rv=new MySQLRaavareDAO();
//			RaavareDTO dto3 = new RaavareDTO(17,"smør","Egelykke");
//			rv.createRaavare(dto3);
//			dto3.setRaavareNavn("stegemargarine");
//			rv.updateRaavare(dto3);
//			dto3=rv.getRaavare(17);
//			System.out.println(dto3.getRaavareNavn());

		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
