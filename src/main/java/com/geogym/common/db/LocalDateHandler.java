package com.geogym.common.db;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class LocalDateHandler extends BaseTypeHandler<LocalDate>{

	@Override
	public LocalDate getNullableResult(ResultSet rs, String colname) throws SQLException {
	    return getLocalDate(rs.getString(colname));
	}

	@Override
	public LocalDate getNullableResult(ResultSet rs, int colindex) throws SQLException {
		return getLocalDate(rs.getString(colindex));
	}

	@Override
	public LocalDate getNullableResult(CallableStatement cs, int colindex) throws SQLException {
		return getLocalDate(cs.getString(colindex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, LocalDate date, JdbcType type)
			throws SQLException {
		ps.setString(index, date.toString());
	}

	private LocalDate getLocalDate(String timestr) {
		return LocalDate.parse(timestr);
	}

}
