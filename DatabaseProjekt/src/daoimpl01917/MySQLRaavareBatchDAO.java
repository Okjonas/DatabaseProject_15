package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import connector01917.SQLMapper;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.RaavareBatchDTO;

public class MySQLRaavareBatchDAO implements RaavareBatchDAO {

	@Override
	public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {
		ResultSet rs = Connector.doQuery(SQLMapper.getSQL("getRaavareBatch", String.valueOf(rbId)));
		try {
			if (!rs.first())
				throw new DALException("Raavarebatch med id: " + rbId + " findes ikke");
			return new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getInt("maengde"));
		} catch (SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = Connector.doQuery(SQLMapper.getSQL("select.all.from", "raavarebatch"));
		try {
			while (rs.next()) {
				list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getInt("maengde")));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = Connector.doQuery(SQLMapper.getSQL("getRaavareBatchList", String.valueOf(raavareId)));
		try {
			while (rs.next()) {
				list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getInt("maengde")));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		Connector.doUpdate(SQLMapper.getSQL("createRaavareBatch", raavarebatch.toArray()));

	}

	@Override
	public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		Connector.doUpdate(SQLMapper.getSQL("updateRaavareBatch", raavarebatch.toArray()));

	}
	}


