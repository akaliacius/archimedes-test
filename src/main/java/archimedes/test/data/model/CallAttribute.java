package archimedes.test.data.model;

public class CallAttribute {
    private String date;
    private double riskScore;
    private String number;
    private boolean greenList;
    private boolean redList;

    public void setDate(String date) {
        this.date = date;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setGreenList(boolean greenList) {
        this.greenList = greenList;
    }

    public void setRedList(boolean redList) {
        this.redList = redList;
    }
}
