package assignment6;

public class Complaint {
    private static int nextId = 1;

    private String causeOfAction;
    private String plaintiffCitizenship;
    private String defendandCitizenship;
    private String originalStateOfFiling;
    private double amountInControversy;
    private int id;

    public Complaint(String causeOfAction,
                     String plaintiffCitizenship,
                     String defendandCitizenship,
                     String originalStateOfFiling,
                     double amountInControversy) {
        this.causeOfAction = causeOfAction;
        this.plaintiffCitizenship = plaintiffCitizenship;
        this.defendandCitizenship = defendandCitizenship;
        this.originalStateOfFiling = originalStateOfFiling;
        this.amountInControversy = amountInControversy;
        id = nextId;
        nextId++;
    }

    public String getCauseOfAction() { return causeOfAction; }

    public String getPlaintiffCitizenship() { return plaintiffCitizenship; }

    public String getDefendandCitizenship() { return defendandCitizenship; }

    public String getOriginalStateOfFiling() { return originalStateOfFiling; }

    public double getAmountInControversy() { return amountInControversy; }

    public int getId() { return id; }
}