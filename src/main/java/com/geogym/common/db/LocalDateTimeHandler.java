package com.geogym.common.db;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class LocalDateTimeHandler extends BaseTypeHandler<LocalDateTime>{

	@Override
	public LocalDateTime getNullableResult(ResultSet rs, String colname) throws SQLException {
	    return getLocalDateTime(rs.getString(colname));
	}

	@Override
	public LocalDateTime getNullableResult(ResultSet rs, int colindex) throws SQLException {
		return getLocalDateTime(rs.getString(colindex));
	}

	@Override
	public LocalDateTime getNullableResult(CallableStatement cs, int colindex) throws SQLException {
		return getLocalDateTime(cs.getString(colindex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, LocalDateTime date, JdbcType type)
			throws SQLException {
		ps.setString(index, date.toString());
	}

	private LocalDateTime getLocalDateTime(String timestr) {
		return LocalDateTime.parse(timestr);
	}

}
