package com.zac.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zac.common.ben.Tb_Obj;

public class DBTest {

	/**
	 * SQLite ,a database in memory
	 */
	public static void sqlite(){
		 String fileName = "E:/info/zac/lean/db/db/zac.db";
		 String driver="org.sqlite.JDBC";
		 String url="jdbc:sqlite:"+fileName;
		 //execSql(driver, url, null, null);
		 Tb_Obj[][] res=querySql(driver,url,null,null);
		 for (Tb_Obj[] tb_Objs : res) {
			 System.out.println("======================");
			 for (Tb_Obj tb_Obj : tb_Objs) {
				System.out.println(tb_Obj.getColName()+":"+tb_Obj.getColValue());
			}
			 System.out.println("======================");
		}
		
	}
	public static void sqlserver(){
		
	}
	public static void mysql(){
		
	}
	
	public static Tb_Obj[][] querySql(String driver,String url,String uname,String pwd){
		try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            
            String sqlStr="SELECT bok_name,bok_cid,bok_mobile FROM info_book ";
            sqlStr="SELECT * FROM info_address  ";
            
            ResultSet rsConut= stmt.executeQuery("select count(*) rowCount from ("+sqlStr+") t");
            int rows=rsConut.getInt("rowCount");
            System.out.println("【total size:"+rows+"】");	
            
            // Create a result set object for the statement
            ResultSet rs = stmt.executeQuery(sqlStr);
           
            
            //获取列明
            List<String> colNames=new ArrayList<String>();
            
            ResultSetMetaData rsmd = rs.getMetaData() ;
            for (int i = 1; i < rsmd.getColumnCount(); i++) {
            	 String colName=rsmd.getColumnName(i);
            	 System.out.println(colName);
            	 colNames.add(colName);
            	 
			}
           
            
            
            
           /* int rows=rs.getRow();
            System.out.println("【total size:"+rows+"】");*/
           
            System.out.println("【colNames size:"+colNames.size()+"】");	
            
            Tb_Obj[][] allDate=new Tb_Obj[rows][colNames.size()];
            int rowIndex=0;
            
            while (rs.next()) {
            	Tb_Obj[] col=new Tb_Obj[colNames.size()];
            	//System.out.println("======================");
            	int colIndex=0;
            	for (String colname : colNames) {
            		String colvalue=rs.getString(colname);
            		//System.out.println(colvalue);
            		col[colIndex]=new Tb_Obj(colname,colvalue);
            		colIndex++;
    			}
            	//System.out.println("======================["+rowIndex+"]");
            	allDate[rowIndex]=col;
            	
            	
            	rowIndex++;
            }
           
            conn.close();
            return allDate;
        }
        catch (Exception e) {
           e.printStackTrace();
        }
		return null;
	}
	
	public static int execSql(String driver,String url,String uname,String pwd){
		 try {
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			 Class.forName(driver);
			 Connection conn = DriverManager.getConnection(url);
			 Statement stmt = conn.createStatement();
			 
			 Date proSt=new Date();
			 System.out.println(sdf.format(proSt));
			
			 String sql="insert into test values ";
			 StringBuffer sb=new StringBuffer();
			 sb.append("insert into test values ");
			 for (int i = 0; i < 12000000; i++) {
				//sql+="(1,2),";
				sb.append("(1,2), ");
				System.out.println(i);
				
			}
			sql= sb.substring(0, sb.length()-2);
			//System.out.println(sql);
			
			 Date proend=new Date();
			 System.out.println("db end:"+sdf.format(proend));
			 long df = proend.getTime() - proSt.getTime();
			 long msp = df / (1000 );
			 System.out.println("sql总耗时:"+msp+","+df);
			
			 Date dbst=new Date();
			 System.out.println("db start:"+sdf.format(dbst));
			 int res=stmt.executeUpdate(sql);
			 Date dbend=new Date();
			 System.out.println("db end:"+sdf.format(dbend));
			 long diff = dbend.getTime() - dbst.getTime();
			 long ms = diff / (1000 );
			 System.out.println("DB总耗时:"+ms+","+diff);
			
			 stmt.close();
			 return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		return 0;
	}
	
	public static void sql(){
		try {
            // The SQLite (3.3.8) Database File
            // This database has one table (pmp_countries) with 3 columns (country_id, country_code, country_name)
            // It has like 237 records of all the countries I could think of.
            String fileName = "E:/info/zac/lean/db/db/zac.db";
            // Driver to Use
            // http://www.zentus.com/sqlitejdbc/index.html
            Class.forName("org.sqlite.JDBC");
            // Create Connection Object to SQLite Database
            // If you want to only create a database in memory, exclude the +fileName
            Connection conn = DriverManager.getConnection("jdbc:sqlite:"+fileName);
            // Create a Statement object for the database connection, dunno what this stuff does though.
            Statement stmt = conn.createStatement();
            
            String sqlStr="SELECT bok_name,bok_cid,bok_mobile FROM info_book ";
            sqlStr="SELECT * FROM info_address  ";
            
            // Create a result set object for the statement
            ResultSet rs = stmt.executeQuery(sqlStr);
            
            
            //获取列明
            ResultSetMetaData rsmd = rs.getMetaData() ;
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
            	 rsmd.getColumnName(i);
			}
           
            
            
            
            //int rows=rs.getRow();
            
            // Iterate the result set, printing each column
            // if the column was an int, we could do rs.getInt(column name here) as well, etc.
            while (rs.next()) {
               /* String id   = rs.getString("bok_name");   // Column 1
                String code = rs.getString("bok_cid"); // Column 2
                String name = rs.getString("bok_mobile"); // Column 3
                System.out.println("ID: "+id+" Code: "+code+" Name: "+name);*/
            	
            	//rs.getString(columnIndex)

            }
            // Close the connection
            conn.close();
        }
        catch (Exception e) {
            // Print some generic debug info
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
	}
	
}
