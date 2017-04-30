package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import connector01917.SQLMapper;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptDAO;
import dto01917.ReceptDTO;

public class MySQLReceptDAO implements ReceptDAO {

	@Override
	public ReceptDTO getRecept(int receptId) throws DALException {
		ResultSet rs = Connector.doQuery(SQLMapper.getSQL("getRecept", String.valueOf(receptId)));
	    try {
	    	if (!rs.first()) throw new DALException("Recept med id: " + receptId + " findes ikke");
	    	return new ReceptDTO (rs.getInt("recept_id"),rs.getString("recept_navn"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}


	@Override
	public List<ReceptDTO> getReceptList() throws DALException {		
			List<ReceptDTO> list = new ArrayList<ReceptDTO>();
			ResultSet rs = Connector.doQuery(SQLMapper.getSQL("select.all.from", "recept"));
			try
			{
				while (rs.next()) 
				{
					list.add(new ReceptDTO(rs.getInt("recept_id"), rs.getString("recept_navn")));
				}
			}
			catch (SQLException e) { throw new DALException(e); }
			return list;
		}
	

	@Override
	public void createRecept(ReceptDTO recept) throws DALException {
		Connector.doUpdate(SQLMapper.getSQL("createRecept", recept.toArray()));
		
	}

	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {
		Connector.doUpdate(SQLMapper.getSQL("updateRecept", recept.toArray()));
	}

}