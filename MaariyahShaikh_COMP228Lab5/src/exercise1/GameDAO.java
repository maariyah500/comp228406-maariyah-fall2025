package exercise1;

import java.sql.*;

public class GameDAO {

    public void insertGame(String title) {
        String sql = "INSERT INTO Game (game_title) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

