/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import Entity.Building;
import Entity.Customer;
import java.sql.ResultSet;
/**
 *
 * @author Plamen
 */
public class DBFacade {

    
    
    
    public DBFacade(java.sql.Connection con){
            this.con = con;  //DBConnector.getInstance().getConnection();
	  }
    
    public static DBFacade getInstance()
	  {
		  if(instance == null)
			  instance = new DBFacade(DBConnector.getInstance().getConnection());
		  return instance;
	  }
    
    public static DBFacade getTestInstance()
    {
            instance = new DBFacade(TestDBConnector.getTestInstance().getTestConnection());
            return instance;
    }
    
    private final Connection con;
    private static DBFacade instance;
    
   public void addBuilding(String name, String address, int pno, String size){
       System.out.println(name + address + pno + size);
       try { 	
            Statement statement;
            statement = con.createStatement();
            String sql = "INSERT into buildings (name,address,pno,size) values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setInt(3, pno);
            stmt.setString(4, size);
            stmt.execute();
            
        }catch (SQLException ex){}
    }
   
    public Building getBuilding(String bname){
        Building bd = new Building();
        try{
            Statement statement;
            statement = con.createStatement();
            String sql = "SELECT name,address,pno,size from BUILDINGS where name = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,bname);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            bd.setName(rs.getString("name"));
            System.out.println(bd.getName());
            bd.setAddress(rs.getString("address"));
            bd.setPno(rs.getInt("pno"));
            bd.setSize(rs.getString("size"));
            
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return bd;
    }

    public void addCustomer(String cname, String email, String telephone, String caddress){
        System.out.println(cname + email + telephone + caddress);
        try{
            Statement statement;
            statement = con.createStatement();
            String sql = "INSERT into customers (cname,email,telephone,caddress) values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,cname);
            stmt.setString(2,email);
            stmt.setString(3,telephone);
            stmt.setString(4,caddress);
            stmt.executeUpdate();
        } catch (SQLException ex){
        ex.printStackTrace();
                }
        
    }
    
    public Customer getCustomer(String cname){
        Customer ct = new Customer();
        try{
            Statement statement;
            statement = con.createStatement();
            String sql = "SELECT cname,email,telephone,caddress from CUSTOMERS where cname = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,cname);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            rs.next();
            String name = rs.getString("cname");
            System.out.println(name);
            ct.setCname(name);
            System.out.println(ct.getCname());
            ct.setEmail(rs.getString("email"));
            ct.setTelephone(rs.getString("telephone"));
            ct.setCaddress(rs.getString("caddress"));
        }catch (SQLException ex){}
        return ct;
    }
}
    

