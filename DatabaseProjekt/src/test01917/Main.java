package test01917;

import daoimpl01917.MySQLOperatoerDAO;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import daoimpl01917.MySQLReceptDAO;
import daoimpl01917.MySQLReceptKompDAO;
import daoimpl01917.MySQLRoleDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;
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
//		try {
//			

			
// TEST1			
//			MySQLProduktBatchDAO r = new MySQLProduktBatchDAO();
//			ProduktBatchDTO dto= new ProduktBatchDTO(27, 5, 1);
//			r.createProduktBatch(dto);
//			dto.setStatus(4);
//			r.updateProduktBatch(dto);
//			dto=r.getProduktBatch(27);
//			System.out.println(dto.getStatus());
//			System.out.println(r.getProduktBatchList());
//			
//			MySQLProduktBatchKompDAO t = new MySQLProduktBatchKompDAO();
//			ProduktBatchKompDTO dto1= new ProduktBatchKompDTO(27, 1, 1, 2, 12);
//			t.createProduktBatchKomp(dto1);
//			dto1.setOprId(11);
//			t.updateProduktBatchKomp(dto1);
//			dto1=t.getProduktBatchKomp(27, 1);
//			System.out.println(dto1.getOprId());
//			System.out.println(t.getProduktBatchKompList(27));
			

// TEST2			
//			MySQLRaavareBatchDAO rb = new MySQLRaavareBatchDAO();
//			RaavareBatchDTO dto2= new RaavareBatchDTO(27, 1, 1);
//			rb.createRaavareBatch(dto2);
//			dto2.setMaengde(12);
//			rb.updateRaavareBatch(dto2);
//			dto2=rb.getRaavareBatch(27);
//			System.out.println(dto2.getMaengde());
//			System.out.println(rb.getRaavareBatchList());
//			System.out.println(rb.getRaavareBatchList(1));
			
			
// TEST3
//			MySQLRaavareDAO rv=new MySQLRaavareDAO();
//			RaavareDTO dto3 = new RaavareDTO(17,"smør","Egelykke");
//			rv.createRaavare(dto3);
//			dto3.setRaavareNavn("stegemargarine");
//			rv.updateRaavare(dto3);
//			System.out.println(rv.getRaavare(17).getRaavareNavn());
//			System.out.println(rv.getRaavareList());
//			
//		
//			MySQLReceptDAO rec = new MySQLReceptDAO();
//			ReceptDTO dto4 = new ReceptDTO(47, "carbonara");
//			rec.createRecept(dto4);
//			rec.updateRecept(dto4);
//			System.out.println(rec.getRecept(47).getReceptNavn());
//			System.out.println(rec.getReceptList());
//			
//			MySQLReceptKompDAO rek = new MySQLReceptKompDAO();
//			ReceptKompDTO dto5 = new ReceptKompDTO(47, 17, 500, 0.0001);
//			rek.createReceptKomp(dto5);
//			rek.updateReceptKomp(dto5);
//			System.out.println(rek.getReceptKomp(47, 17).getNomNetto());
//			System.out.println(rek.getReceptKompList());
//			System.out.println(rek.getReceptKompList(47));
			
// TEST4
//			MySQLRoleDAO ro = new MySQLRoleDAO();
//			RoleDTO dto6= new RoleDTO(27,"Baws");
//			ro.createRole(dto6);
//			ro.updateRole(dto6);
//			System.out.println(ro.getRole(27).getRoleName());
//			System.out.println(ro.getRoleList());


//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
	}
}
