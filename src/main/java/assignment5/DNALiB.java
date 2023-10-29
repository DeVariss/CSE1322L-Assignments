package assignment5;

public final class DNALiB {
    private DNALiB() {}

    public static boolean validator(String dna) {
        if (dna.length() == 3)
            return isDna(dna);
        if (!dna.isEmpty() && dna.length() % 3 == 0)
            return isDna(dna.substring(0, 3)) && validator(dna.substring(3));
        return false;
    }

    public static String reverser(String dna) {
        if (dna.isEmpty())
            return "";
        return reverser(dna.substring(1)) + dna.charAt(0);
    }

    public static String inverser(String dna) {
        if (dna.isEmpty())
            return "";
        return inverse(dna.substring(0, 1)) + inverser(dna.substring(1));
    }

    public static String translator(String dna) {
        if (dna.isEmpty())
            return "";
        return translate(dna.substring(0, 3)) + translator(dna.substring(3));
    }

    private static String translate(String sub) {
        switch (sub) {
            case "AAA", "AAG" ->
                    sub = "K";
            case "AAC", "AAT" ->
                    sub = "N";
            case "ACA", "ACC", "ACG", "ACT" ->
                    sub = "T";
            case "AGA", "AGG", "CGA", "CGC", "CGG", "CGT" ->
                    sub = "R";
            case "AGC", "AGT", "TCA", "TCC", "TCG", "TCT" ->
                    sub = "S";
            case "ATA", "ATC", "ATT" ->
                    sub = "I";
            case "ATG" ->
                    sub = "M";
            case "CAA", "CAG" ->
                    sub = "Q";
            case "CAC", "CAT" ->
                    sub = "H";
            case "CCA", "CCC", "CCG", "CCT" ->
                    sub = "P";
            case "CTA", "CTC", "CTG", "CTT", "TTA" ->
                    sub = "L";
            case "GAA", "GAG" ->
                    sub = "E";
            case "GAC", "GAT" ->
                    sub = "D";
            case "GCA", "GCC", "GCG", "GCT" ->
                    sub = "A";
            case "GGA", "GGC", "GGG", "GGT" ->
                    sub = "G";
            case "GTA", "GTC", "GTG", "GTT" ->
                    sub = "V";
            case "TAA", "TAG", "TGA" ->
                    sub = "-";
            case "TAC", "TAT" ->
                    sub = "Y";
            case "TGC", "TGT" ->
                    sub = "C";
            case "TGG" ->
                    sub = "W";
            case "TTC", "TTT" ->
                    sub = "F";
        }
        return sub;
    }

    private static boolean isDna(String dna) {
        char a = dna.charAt(0);
        char b = dna.charAt(1);
        char c = dna.charAt(2);
        boolean aIsDna = (a == 'A' || a == 'C' || a == 'G' || a == 'T');
        boolean bIsDna = (b == 'A' || b == 'C' || b == 'G' || b == 'T');
        boolean cIsDna = (c == 'A' || c == 'C' || c == 'G' || c == 'T');
        return (aIsDna && bIsDna && cIsDna);
    }

    private static String inverse(String sub) {
        switch (sub) {
            case "A" ->
                    sub = "T";
            case "C" ->
                    sub = "G";
            case "G" ->
                    sub = "C";
            case "T" ->
                    sub = "A";
        }
        return sub;
    }
}