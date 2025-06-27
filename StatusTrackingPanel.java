import javax.swing.*;
import java.awt.*;

public class StatusTrackingPanel extends JPanel {
    public StatusTrackingPanel(JFrame frame) {
        setLayout(new BorderLayout(20, 20));
        setBackground(new Color(245, 248, 255));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel heading = new JLabel("Proposal Status", SwingConstants.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(new Color(33, 37, 41));
        add(heading, BorderLayout.NORTH);

        JTextArea statusArea = new JTextArea();
        statusArea.setEditable(false);
        statusArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        statusArea.setBackground(new Color(235, 240, 255));
        statusArea.setBorder(BorderFactory.createLineBorder(new Color(200, 220, 255), 1));
        add(new JScrollPane(statusArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        JButton refreshBtn = new JButton("Refresh Status");
        refreshBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        refreshBtn.setBackground(new Color(51, 102, 255));
        refreshBtn.setForeground(Color.WHITE);
        refreshBtn.setFocusPainted(false);
        refreshBtn.setBorder(BorderFactory.createEmptyBorder(8, 24, 8, 24));
        refreshBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backBtn = new JButton("Back to Main Menu");
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backBtn.setBackground(new Color(108, 117, 125));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusPainted(false);
        backBtn.setBorder(BorderFactory.createEmptyBorder(6, 18, 6, 18));
        backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        backBtn.addActionListener(e -> {
            frame.setContentPane(ZohaibProposalApp.createMainMenuPanel(frame));
            frame.revalidate();
        });

        bottomPanel.add(refreshBtn);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(backBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        refreshBtn.addActionListener(e -> {
            ProposalModel proposal = FakeDatabase.submittedProposal;
            if (proposal == null) {
                statusArea.setText("No proposal submitted yet.\nRedirecting to submission form...");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Title: ").append(proposal.getTitle()).append("\n");
                sb.append("Status: ").append(proposal.getStatus()).append("\n");
                if (proposal.getStatus().equals("Rejected")) {
                    sb.append("Feedback: ").append(proposal.getFeedback()).append("\n");
                } else if (proposal.getStatus().equals("Pending")) {
                    sb.append("Awaiting supervisor review.\n");
                }
                sb.append("Submitted On: ").append(proposal.getTimestamp());
                statusArea.setText(sb.toString());
            }
        });
    }
}