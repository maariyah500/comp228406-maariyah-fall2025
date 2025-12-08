package exercise1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MainGUI extends JFrame {

    PlayerDAO playerDAO = new PlayerDAO();
    GameDAO gameDAO = new GameDAO();
    PlayerGameDAO pgDAO = new PlayerGameDAO();

    public MainGUI() {
        setTitle("Player Game Database");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();

        tabs.add("Add Player", createAddPlayerPanel());
        tabs.add("Add Game", createAddGamePanel());
        tabs.add("Player Game Entry", createPlayerGamePanel());
        tabs.add("Reports", createReportPanel());

        add(tabs);
        setVisible(true);
    }

    private JPanel createAddPlayerPanel() {
        JPanel p = new JPanel(new GridLayout(8,2));

        JTextField f1 = new JTextField();
        JTextField f2 = new JTextField();
        JTextField address = new JTextField();
        JTextField postal = new JTextField();
        JTextField province = new JTextField();
        JTextField phone = new JTextField();

        JButton save = new JButton("Add Player");

        save.addActionListener(e -> {
            playerDAO.insertPlayer(f1.getText(), f2.getText(), address.getText(),
                    postal.getText(), province.getText(), phone.getText());
            JOptionPane.showMessageDialog(null, "Player added.");
        });

        p.add(new JLabel("First Name"));
        p.add(f1);
        p.add(new JLabel("Last Name"));
        p.add(f2);
        p.add(new JLabel("Address"));
        p.add(address);
        p.add(new JLabel("Postal Code"));
        p.add(postal);
        p.add(new JLabel("Province"));
        p.add(province);
        p.add(new JLabel("Phone Number"));
        p.add(phone);
        p.add(save);

        return p;
    }

    private JPanel createAddGamePanel() {
        JPanel p = new JPanel(new GridLayout(2,2));

        JTextField gameTitle = new JTextField();
        JButton add = new JButton("Add Game");

        add.addActionListener(e -> {
            gameDAO.insertGame(gameTitle.getText());
            JOptionPane.showMessageDialog(null, "Game added.");
        });

        p.add(new JLabel("Game Title"));
        p.add(gameTitle);
        p.add(add);

        return p;
    }

    private JPanel createPlayerGamePanel() {
        JPanel p = new JPanel(new GridLayout(5,2));

        JTextField gameId = new JTextField();
        JTextField playerId = new JTextField();
        JTextField date = new JTextField("YYYY-MM-DD");
        JTextField score = new JTextField();

        JButton add = new JButton("Save Entry");

        add.addActionListener(e -> {
            pgDAO.insertPlayerGame(
                    Integer.parseInt(gameId.getText()),
                    Integer.parseInt(playerId.getText()),
                    java.sql.Date.valueOf(date.getText()),
                    Integer.parseInt(score.getText())
            );
            JOptionPane.showMessageDialog(null, "Game entry saved.");
        });

        p.add(new JLabel("Game ID"));
        p.add(gameId);
        p.add(new JLabel("Player ID"));
        p.add(playerId);
        p.add(new JLabel("Playing Date"));
        p.add(date);
        p.add(new JLabel("Score"));
        p.add(score);
        p.add(add);

        return p;
    }

    private JPanel createReportPanel() {
        JPanel p = new JPanel(new BorderLayout());

        JTextField playerIdField = new JTextField();
        JButton load = new JButton("Load Report");
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        load.addActionListener(e -> {
            model.setRowCount(0);
            model.setColumnIdentifiers(new String[] {"Game Title", "Date", "Score"});

            try (Connection conn = DBConnection.getConnection()) {
                PreparedStatement ps = conn.prepareStatement("""
                SELECT g.game_title, pg.playing_date, pg.score
                FROM PlayerAndGame pg
                JOIN Game g ON pg.game_id = g.game_id
                WHERE pg.player_id = ?
                """);
                ps.setInt(1, Integer.parseInt(playerIdField.getText()));

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getString(1),
                            rs.getDate(2),
                            rs.getInt(3)
                    });
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JPanel top = new JPanel();
        top.add(new JLabel("Player ID:"));
        top.add(playerIdField);
        top.add(load);

        p.add(top, BorderLayout.NORTH);
        p.add(new JScrollPane(table), BorderLayout.CENTER);

        return p;
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}

