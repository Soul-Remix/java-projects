import java.util.HashMap;

public class Abbreviations {
    private final HashMap<String, String> abrrs;

    public Abbreviations() {
        abrrs = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        String text = sanitizeString(abbreviation);
        if (abrrs.containsKey(text)) {
            System.out.println("Abbreviations is already entered");
        } else {
            abrrs.put(text, explanation);
        }
    }

    public boolean hasAbbreviation(String abbreviation) {
        return abrrs.containsKey(sanitizeString(abbreviation));
    }

    public String findExplanationFor(String abbreviation) {
        String text = sanitizeString(abbreviation);
        if (abrrs.containsKey(text)) {
            return abrrs.get(text);
        } else {
            System.out.println("Abbreviations not found");
            return null;
        }
    }

    public String sanitizeString(String text) {
        if (text == null) {
            text = "";
        }
        return text.trim().toLowerCase();
    }
}
