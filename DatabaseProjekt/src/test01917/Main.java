package test01917;

import daoimpl01917.MySQLOperatoerDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;

import java.sql.SQLException;

import connector01917.Connector;

public class Main {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		System.out.println("Operatoer nummer 13:");
		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();
		try { System.out.println(opr.getOperatoer(13)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Indsaettelse af ny operatoer med opr_id =  34");
		OperatoerDTO oprDTO = new OperatoerDTO(34,"Don Juan","DJ","000000-0000","iloveyou");
		try { opr.createOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Operatoer nummer 34:");
		try { System.out.println(opr.getOperatoer(34)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af initialer for operatoer nummer 34");
		oprDTO.setIni("DoJu");
		try { opr.updateOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Operatoer nummer 34:");
		try { System.out.println(opr.getOperatoer(34)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Alle operatoerer:");
		try { System.out.println(opr.getOperatoerList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Operatoer nummer 5:");
		try { System.out.println(opr.getOperatoer(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		
		
	}
}
