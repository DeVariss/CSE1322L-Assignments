package assignment6;

import java.util.Scanner;
import java.io.*;

public class Driver
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("File name:");
        String fileName = userInput.nextLine() + ".txt";
        System.out.println("Absolute path:");
        String absolutePath = userInput.nextLine();
        userInput.close();
        File file = new File(absolutePath, fileName);

        if (!file.exists())
        {
            System.out.println("File could not be found.");
            return;
        }

        try
        {
            Scanner fileInput = new Scanner(file);
            FileWriter writeToRemanded = new FileWriter(new File(absolutePath, "remanded.txt"));
            FileWriter writeToAccepted = new FileWriter(new File(absolutePath, "accepted.txt"));

            while (fileInput.hasNextLine())
            {
                Complaint complaint = makeComplaint(fileInput.nextLine().split(","));
                try
                {
                    processComplaint(complaint);
                    writeToAccepted.write(formatComplaint(complaint, null));
                }
                catch (StateComplaintException sCE)
                {
                    writeToRemanded.write(formatComplaint(complaint, sCE.getMessage()));
                }
            }

            writeToRemanded.flush();
            writeToRemanded.close();
            writeToAccepted.flush();
            writeToAccepted.close();
        }
        catch (IOException iE)
        {
            iE.printStackTrace();
        }
        finally
        {
            System.out.println("Program finished.");
        }
    }

    private static String formatComplaint(Complaint complaint, String errorMsg)
    {
        String formatted =
                  "\nCase ID: %d"
                + "\nCause of action: %s"
                + "\nAmount in Controversy: $%.2f"
                + "\nPlaintiff's Citizenship: %s"
                + "\nDefendants Citizenship: %s"
                + "\nOriginally filed in: %s"
                + (errorMsg != null ? "\n\nReason for remand: " + errorMsg : "")
                + "\n==============================";
        return String.format(
                formatted,
                complaint.getId(),
                complaint.getCauseOfAction(),
                complaint.getAmountInControversy(),
                complaint.getPlaintiffCitizenship(),
                complaint.getDefendandCitizenship(),
                complaint.getOriginalStateOfFiling());
    }

    private static Complaint makeComplaint(String[] complaintDetails)
    {
        return new Complaint(
                complaintDetails[0],
                complaintDetails[2],
                complaintDetails[3],
                complaintDetails[4],
                Double.parseDouble(complaintDetails[1]));
    }

    private static void processComplaint(Complaint complaint)
            throws StateComplaintException
    {
        String causeOfAction = complaint.getCauseOfAction();
        boolean isValidCause =
                           causeOfAction.equals("Equal Protection Challenge")
                        || causeOfAction.equals("Title IX Workplace Discrimination")
                        || causeOfAction.equals("Prisoner Civil Rights Claim")
                        || causeOfAction.equals("Fair Labor Standard Act Claim");
        if (isValidCause)
            return;

        String plaintiffCitizenship = complaint.getPlaintiffCitizenship();
        String defendantCitizenship = complaint.getDefendandCitizenship();
        boolean isNotDiverse = plaintiffCitizenship.equals(defendantCitizenship);
        if (isNotDiverse)
            throw new StateComplaintException("Lack of Diversity");

        double amountInControversy = complaint.getAmountInControversy();
        boolean amountIsLow = amountInControversy <= 75000d;
        if (amountIsLow)
            throw new StateComplaintException("Amount in controversy less than or equal to $75000");

        String stateOfFiling = complaint.getOriginalStateOfFiling();
        boolean matchesStateFiling = defendantCitizenship.equals(stateOfFiling);
        if (matchesStateFiling)
            throw new StateComplaintException("No prejudice through diversity");
    }
}