package com.liuyuhang.dao;

import com.liuyuhang.model.User;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert
        String sql ="insert into usertable values id=?,username=?,password=?,email=?,gender=?,birthdate=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,user.getId());
        st.setString(2,user.getUsername());
        st.setString(3,user.getPassword());
        st.setString(4,user.getEmail());
        st.setString(5,user.getGender());
        st.setDate(6, (java.sql.Date) user.getBirthdate());
        st.executeUpdate();
        ResultSet rs = st.executeQuery("select * from usertable");
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return true;
    }


    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete where id=?
        String deleteUser ="delete * from usertable where id=?";
        PreparedStatement st = con.prepareStatement(deleteUser);
        st.setInt(1,user.getId());
        st.executeUpdate();
        ResultSet rs = st.executeQuery("select * from usertable");
        user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return 0;
    }

    @Override
    public User updateUser(Connection con, User user) throws SQLException {
        //update user
        String updateUser ="update usertable set password=?,email=?,gender=?,birthdate=? where username=?";
        PreparedStatement st = con.prepareStatement(updateUser);
        st.setString(5,user.getUsername());
        st.setString(1,user.getPassword());
        st.setString(2,user.getEmail());
        st.setString(3,user.getGender());
        st.setDate(4, (java.sql.Date) user.getBirthdate());
        st.executeUpdate();
        String sql="select * from usertable where username='"+user.getUsername()+"'";
        Statement st1= con.createStatement();
        ResultSet rs = st1.executeQuery(sql);
        user = null;
        if(rs.next()){
            user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select * from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select * from usertable where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select * from usertable where eamil=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select * from usertable where gender=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select * from usertable where birthdate=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return (List<User>) user;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select * from usertable";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return (List<User>) user;
    }
}
