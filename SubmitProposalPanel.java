import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class SubmitProposalPanel extends JPanel {
    public SubmitProposalPanel(JFrame frame) {
        setLayout(new BorderLayout(20, 20));
         
        setBackground(new Color(245, 248, 255));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel heading = new JLabel("Submit Proposal", SwingConstants.CENTER);
       
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(new Color(33, 37, 41));
        add(heading, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
         
        form.setOpaque(false);
        form.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 220, 255), 2),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
          gbc.gridx = 0;
        gbc.gridy = 0;
        form.add(new JLabel("Project Title:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
      
        JTextField titleField = new JTextField();
        styleTextField(titleField);
        form.add(titleField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        form.add(new JLabel("Objective:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JTextField objField = new JTextField();
      
        styleTextField(objField);
        form.add(objField, gbc);
          gbc.gridx = 0;
        gbc.gridy++;
          form.add(new JLabel("Problem Statement:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JTextField probField = new JTextField();
        styleTextField(probField);
        form.add(probField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
          form.add(new JLabel("Tools/Technologies:"), gbc);
        gbc.gridx = 1;
         gbc.weightx = 1.0;
        JTextField toolField = new JTextField();
        styleTextField(toolField);
        form.add(toolField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        form.add(new JLabel("Team Members:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JTextField teamField = new JTextField();
        styleTextField(teamField);
        form.add(teamField, gbc);

        JButton submitBtn = new JButton("Submit Proposal");
          
        submitBtn.setBackground(new Color(51, 102, 255));
        submitBtn.setForeground(Color.WHITE);
          submitBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        submitBtn.setFocusPainted(false);
        submitBtn.setBorder(BorderFactory.createEmptyBorder(8, 24, 8, 24));

        JLabel msgLabel = new JLabel("", SwingConstants.CENTER);
        msgLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        msgLabel.setForeground(new Color(220, 53, 69));
        msgLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JButton backBtn = new JButton("Back to Main Menu");
        backBtn.setVisible(false);
        backBtn.setBackground(new Color(108, 117, 125));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backBtn.setFocusPainted(false);
        backBtn.setBorder(BorderFactory.createEmptyBorder(6, 18, 6, 18));
        backBtn.addActionListener(e -> {
            frame.setContentPane(ZohaibProposalApp.createMainMenuPanel(frame));
            frame.revalidate();
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(submitBtn);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(msgLabel);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(backBtn);

        add(form, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        submitBtn.addActionListener(e -> {
            if (titleField.getText().isEmpty() || objField.getText().isEmpty() ||
                    probField.getText().isEmpty() || toolField.getText().isEmpty() || teamField.getText().isEmpty()) {
                msgLabel.setText("Please fill all required fields.");
                msgLabel.setForeground(new Color(220, 53, 69));
            } else {
                ProposalModel proposal = new ProposalModel(
                        titleField.getText(),
                        objField.getText(),
                        probField.getText(),
                        toolField.getText(),
                        teamField.getText(),
                        LocalDateTime.now().toString());
                FakeDatabase.submittedProposal = proposal;
                msgLabel.setText("Proposal submitted successfully!");
                msgLabel.setForeground(new Color(40, 167, 69));
                submitBtn.setVisible(false);
                form.setVisible(false);
                backBtn.setVisible(true);
                System.out.println("Supervisor notified via email (simulation).");
            }
        });
    }

    private void styleTextField(JTextField field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setPreferredSize(new Dimension(220, 36)); // Minimum width 220px, height 36px
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 200, 230), 2, true), // rounded border
                BorderFactory.createEmptyBorder(6, 12, 6, 12) // padding
        ));
        field.setBackground(new Color(255, 255, 255));
        field.setForeground(new Color(33, 37, 41));
    }
}