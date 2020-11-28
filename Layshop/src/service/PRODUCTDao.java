package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Basedao;
import entity.Category;
import entity.Product;


public class PRODUCTDao {
	
	public static int insert(Product p) {
		String sql = "insert into Product values(null, ?, ?,?,?,?,?,?)";
		
		
		Object[] params = {
					p.getPRODUCT_NAME(),
					p.getPRODUCT_DESCRIPTION(),
					p.getPRODUCT_PRICE(),
					p.getPRODUCT_STOCK(),
					p.getPRODUCT_FID(),
					p.getPRODUCT_CID(),
					p.getPRODUCT_FILENAME()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	public static ArrayList<Product> selectAll() {
		ArrayList<Product> list = new ArrayList<Product>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from Product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Product p = new Product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	
	public static Product selectById(int id) {
		Product p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from Product where PRODUCT_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				  p = new Product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return p;
	}
	
	public static ArrayList<Product> selectAllByFid(int fid) {
		ArrayList<Product> list = new ArrayList<Product>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from Product where PRODUCT_FID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Product p = new Product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static ArrayList<Product> selectAllByCid(int cid) {
		ArrayList<Product> list = new ArrayList<Product>();
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from Product where PRODUCT_CID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Product p = new Product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static ArrayList<Product> selectAllById(ArrayList<Integer> ids) {
		ArrayList<Product> lastlylist = new ArrayList<Product>();

		Product p = null;
		//声明结果集
		ResultSet rs = null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
		    for(int i=0; i<ids.size(); i++) {
			
				String sql = "select * from Product where PRODUCT_ID=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ids.get(i));
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 p = new Product(
							 	rs.getInt("PRODUCT_ID"),
							 	rs.getString("PRODUCT_NAME"),
							 	rs.getString("PRODUCT_DESCRIPTION"),
							 	rs.getInt("PRODUCT_PRICE"),
							 	rs.getInt("PRODUCT_STOCK"),
							 	rs.getInt("PRODUCT_FID"),
							 	rs.getInt("PRODUCT_CID"),
							 	rs.getString("PRODUCT_FILENAME")
							 );
					 
					 
					 lastlylist.add(p);
					 
				 }
		    }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return lastlylist;
	}
}
