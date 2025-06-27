import javax.swing.*;
import java.awt.*;

public class ZohaibProposalApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FYP System - Zohaib Ahmed");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setContentPane(createMainMenuPanel(frame));
            frame.setVisible(true);
        });
    }

    public static JPanel createMainMenuPanel(JFrame frame) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(15, 0, 15, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel heading = new JLabel("Welcome to the FYP Proposal System");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(new Color(33, 37, 41));
        panel.add(heading, gbc);

        JLabel desc = new JLabel("Submit and track your Final Year Project proposals easily.");
        desc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        desc.setForeground(new Color(80, 90, 110));
        panel.add(desc, gbc);

        

        JButton submitBtn = new JButton("Submit Proposal");
        JButton statusBtn = new JButton("Track Proposal Status");
        for (JButton btn : new JButton[] { submitBtn, statusBtn }) {
            btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
            btn.setBackground(new Color(51, 102, 255));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(12, 36, 12, 36));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(260, 48));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            panel.add(btn, gbc);
        }

        submitBtn.addActionListener(e -> {
            frame.setContentPane(new SubmitProposalPanel(frame));
            frame.revalidate();
        });

        statusBtn.addActionListener(e -> {
            frame.setContentPane(new StatusTrackingPanel(frame));
            frame.revalidate();
        });

        JLabel footer = new JLabel("Developed by Zohaib Ahmed | 2024");
        footer.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footer.setForeground(new Color(140, 150, 170));
        gbc.insets = new Insets(40, 0, 0, 0);
        panel.add(footer, gbc);

        return panel;
    }
}