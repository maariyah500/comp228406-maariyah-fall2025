package exercise1;

import java.sql.*;

public class PlayerDAO {

    public void insertPlayer(String first, String last, String address,
                             String postal, String province, String phone) {

        String sql = "INSERT INTO Player(first_name, last_name, address, postal_code, province, phone_number) VALUES (?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, first);
            ps.setString(2, last);
            ps.setString(3, address);
            ps.setString(4, postal);
            ps.setString(5, province);
            ps.setString(6, phone);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePlayer(int id, String phone, String address) {
        String sql = "UPDATE Player SET phone_number = ?, address = ? WHERE player_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone);
            ps.setString(2, address);
            ps.setInt(3, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

