package com.zac.util;

/**
 * DB SQL tools
 * @author ZacTang
 *
 */
public class DBUtil {

	public enum DBType{
		/**
		 * H2
		 */
		H2,
		/**
		 * MySql
		 */
		MYSQL,
		ORACLE,
		POSTGRESQL,
		SQLSERVER,
		/**
		 * org.sqlite.JDBC
		 */
		SQLITE
	}
	/**
	 * get type of DB by URL of JDBC
	 * @param jdbcUrl
	 * @return
	 */
	public static DBType getDBType(String jdbcUrl){
		
		if(!StringUtil.isEmpty(jdbcUrl)){
			if (jdbcUrl.contains(":h2:")) {
				return DBType.H2;
			} else if (jdbcUrl.contains("mysql:")) {
				return DBType.MYSQL;
			} else if (jdbcUrl.contains("oracle:")) {
				return DBType.ORACLE;
			} else if (jdbcUrl.contains("postgresql:")) {
				return DBType.POSTGRESQL;
			} else if (jdbcUrl.contains("sqlserver:")) {
				return DBType.SQLSERVER;
			} else if (jdbcUrl.contains(":sqlite:")) {
				return DBType.SQLITE;
			} else {
				throw new IllegalArgumentException("Unknown Database of " + jdbcUrl);
			}
		}else{
			throw new IllegalArgumentException("null Database of " + jdbcUrl);
		}
		
		
		
	}
}
