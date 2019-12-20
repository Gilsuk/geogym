package com.geogym.common.db;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class LocalTimeHandler extends BaseTypeHandler<LocalTime>{

	@Override
	public LocalTime getNullableResult(ResultSet rs, String colname) throws SQLException {
	    return getLocalTime(rs.getString(colname));
	}

	@Override
	public LocalTime getNullableResult(ResultSet rs, int colindex) throws SQLException {
		return getLocalTime(rs.getString(colindex));
	}

	@Override
	public LocalTime getNullableResult(CallableStatement cs, int colindex) throws SQLException {
		return getLocalTime(cs.getString(colindex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, LocalTime date, JdbcType type)
			throws SQLException {
		ps.setString(index, date.toString());
	}

	private LocalTime getLocalTime(String timestr) {
		return LocalTime.parse(timestr);
	}

}
