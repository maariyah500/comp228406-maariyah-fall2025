package exercise1;

import java.sql.*;

public class PlayerGameDAO {

    public void insertPlayerGame(int gameId, int playerId, Date date, int score) {

        String sql = "INSERT INTO PlayerAndGame (game_id, player_id, playing_date, score) VALUES (?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, gameId);
            ps.setInt(2, playerId);
            ps.setDate(3, date);
            ps.setInt(4, score);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

