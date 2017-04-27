package connector01917;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class SQLMapper {

	public static String getStatement(String text) {
		Properties props = new Properties();
		try {
			File file = new File("SQLStatements.txt");
			FileInputStream in = new FileInputStream(file);
			props.load(in);
			String res = props.getProperty(text);
			return res;
		} catch (IOException e) {
			throw new IllegalStateException("Properties failed to load");
		}
	}

	public static String getSQL(String SQL_Query, String[] array_list) {

		String query = MessageFormat.format(SQLMapper.getStatement(SQL_Query), array_list);

		return query;
	}
}
