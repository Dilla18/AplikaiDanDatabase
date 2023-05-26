package klubukm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    private static final String DB_URL = "jdbc:mysql://localhost/mydatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    @Override
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM members")) {
            
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setAddress(rs.getString("address"));
                member.setPhoneNumber(rs.getString("phone_number"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return members;
    }
    
    @Override
public Member getMemberById(int id) {
    Member member = null;
    
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM members WHERE id = ?")) {
        
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            member = new Member();
            member.setId(rs.getInt("id"));
            member.setName(rs.getString("name"));
            member.setAddress(rs.getString("address"));
            member.setPhoneNumber(rs.getString("phone_number"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return member;
}

@Override
public void addMember(Member member) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO members (name, address, phone_number) VALUES (?, ?, ?)")) {
        
        stmt.setString(1, member.getName());
        stmt.setString(2, member.getAddress());
        stmt.setString(3, member.getPhoneNumber());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public void updateMember(Member member) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("UPDATE members SET name = ?, address = ?, phone_number = ? WHERE id = ?")) {
        
        stmt.setString(1, member.getName());
        stmt.setString(2, member.getAddress());
        stmt.setString(3, member.getPhoneNumber());
        stmt.setInt(4, member.getId());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public void deleteMember(int id) {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM members WHERE id = ?")) {
        
        stmt.setInt(1, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
