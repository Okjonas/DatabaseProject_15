
package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import connector01917.SQLMapper;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;

import dto01917.ProduktBatchKompDTO;

public class MySQLProduktBatchKompDAO implements ProduktBatchKompDAO {

	@Override
	public ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException {

<<<<<<< HEAD
		ResultSet rs = Connector.doQuery(SQLMapper.getSQL("getProduktBatchKomp", String.valueOf(pbId),String.valueOf(rbId)));
=======
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " + pbId+" and rb_id = "+rbId);
>>>>>>> branch 'master' of https://github.com/Okjonas/DatabaseProject_15.git
		try {
			if (!rs.first())
				throw new DALException("ProduktbatchKomp med Produkt id: " + pbId + " og Raavare id: "+rbId+" findes ikke");
			return new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id"));
		} catch (SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId) throws DALException {
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
<<<<<<< HEAD
		ResultSet rs = Connector.doQuery(SQLMapper.getSQL("getProduktBatchKompList", String.valueOf(pbId)));
=======
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " + pbId);
>>>>>>> branch 'master' of https://github.com/Okjonas/DatabaseProject_15.git
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList() throws DALException {
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
<<<<<<< HEAD
		ResultSet rs = Connector.doQuery(SQLMapper.getSQL("select.all.from", "produktbatchkomponent"));
=======
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
>>>>>>> branch 'master' of https://github.com/Okjonas/DatabaseProject_15.git
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	
	}

	@Override
	public void createProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doQuery(SQLMapper.getSQL("createProdBatchKomp", produktbatchkomponent.toArray()));
		

	}

	@Override
	public void updateProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doQuery(SQLMapper.getSQL("updateProdBatchKomp", produktbatchkomponent.toArray()));
		

	}

}
