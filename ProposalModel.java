public class ProposalModel {
    private String title;
    private String objective;
    private String problemStatement;
    private String tools;
    private String teamMembers;
    private String status = "Pending";
    private String feedback = "";
    private String timestamp;

    public ProposalModel(String title, String objective, String problemStatement, String tools, String teamMembers,
            String timestamp) {
        this.title = title;
        this.objective = objective;
        this.problemStatement = problemStatement;
        this.tools = tools;
        this.teamMembers = teamMembers;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getTitle() {
        return title;
    }

    public String getTimestamp() {
        return timestamp;
    }
}