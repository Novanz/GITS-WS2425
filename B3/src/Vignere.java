import java.util.Arrays;
import java.util.HashSet;

public class Vignere {
    static String[] keywords = {"die", "der", "und", "in", "zu", "den", "das", "nicht", "von", "sie", "ist", "des",
            "sich", "mit", "dem", "dass", "er", "es", "ein", "ich", "auf", "so", "eine", "auch", "als", "an", "nach",
            "wie", "im", "für", "fuer", "fur", "man", "aber", "aus", "durch", "wenn", "nur", "noch", "wird", "bei",
            "hat", "wir", "was", "wird", "sein", "einen", "welche", "sind", "oder", "zur", "um", "haben", "einer",
            "mir", "über", "ihm", "diese", "einem", "ihr", "uns", "da", "zum", "kann", "doch", "vor", "dieser",
            "mich", "ihn", "du", "hatte", "seine", "mehr", "am", "denn", "nun", "unter", "sehr", "selbst", "schon",
            "hier", "bis", "habe", "ihre", "dann", "ihnen", "seiner", "alle", "wieder", "meine", "zeit", "gegen",
            "vom", "ganz", "einzelnen", "wo", "muss", "ohne", "eines", "können", "sei", "ja", "wohl", "dieses", "it",
    "endlich", "text"};
    static HashSet<String> germanKeywordsSet = new HashSet<>();
    static double threshold = 0.1; // Prozentsatz der Wörter, die erkannt werden müssen


    public static void main(String[] args) {
        String s0 = "ASFEX TDM PTG RFMSC MOR"; // HEUTE IST EIN GUTER TAG Schlüssel: TOLL
        String s1 = "AEOTH OQXFH FMWAMYGQXVHVWI"; // fail
        String s2 = "BH DBQSPKVPTM TDM OPK MPLHP LHFOBSYRTBR"; // IT SICHERHEIT IST DER BESTE STUDIENGANG Schlüssel: TOLL
        String s3 = "ZEZXW METES OIW WISIF NXKIHLWRMIATXOMRX"; // HEUTE HABEN WIR EINEN ITSICHERHEITSKURS Schlüssel: SAFE
        String s4 = "KFL VXYDHFWJ FR FEVWUDPNBF"; // fail
        String s5 = "LOXFXZ TLH PBB EHZWPK VPKZ FGR TVV LNQS"; // SAMUEL IST EIN TOLLER KERL UND ICH AUCH Schlüssel: TOLL
        String s6 = "GELL MQR ILBVMAF AMARILCXHC"; // WANN IST ENDLICH WOCHENENDE Schlüssel: KEYY
        String s7 = "FJF DPJ HDI IDRW"; // fail
        String s8 = "TEIJ EWK AME PIJJ"; // Entschlüsselung erfolgreich: DIES IST EIN TEST Schlüssel: QWER
        String s9 = "WEP BWQ XMK MIUM"; // fail => DAS IST EIN TEXM Schlüssel: TEXA
        String s10 = "AQS FIT BYN QUSF"; // fail => DAS IST EIN TESF Schlüssel: XQAA
        String s11 = "MYG ADH FTQDLD WFOSNWD AAYUAXLZHWY"; // fail => UNS IST NICHTS ANDERES EINGEFALLEN Schlüssel: SLOW
        decryptor(s11);
        encryptor("uns ist nichts anderes eingefallen", "SLOW");
    }

    public static void decryptor(String s) {
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (char c1 : letters) {
            for (char c2 : letters) {
                for (char c3 : letters) {
                    for (char c4 : letters) {
                        String key = "" + c1 + c2 + c3 + c4;
                        //System.out.println("Testen der Verschlüsselung mit: " + s + " und Schlüssel: " + key);
                        String decrypted = decrypt(s, key);
                        if (isProbablyReadable(decrypted)) {
                            System.out.println("Testen der Verschlüsselung mit: " + s);
                            System.out.println("Entschlüsselung erfolgreich: " + decrypted);
                            System.out.println("Schlüssel: " + key);
                            break;
                        }
                    }
                }
            }
        }
    }

public static void encryptor(String s, String key) {
    String encrypted = encrypt(s, key);
    System.out.println(s + " verschlüsselt mit Schlüssel " + key);
    System.out.println(encrypted + " (verschlüsselt)");
}
    /**
     * String s verschlüsseln
     *
     * @param text             Nachricht im Klartext
     * @param keyForEncryption Schlüssel
     * @return Verschlüsselte Nachricht
     */
    public static String encrypt(String text, String keyForEncryption) {
        text = text.toUpperCase(); // alles Grossbuchstaben
        char[] chars = text.toCharArray();
        char[] key = keyForEncryption.toUpperCase().toCharArray();
        int keyLength = key.length;
        for (int i = 0; i < chars.length; i++) {
            char charToShift = key[i % keyLength];
            chars[i] = shift(chars[i], charToShift); // Sonderzeichen ignorieren. Schlüsselindex weiterzählen
        }
        return String.valueOf(chars); // wieder in String wandeln
    }

    /**
     * String s entschlüsseln
     *
     * @param text             Nachricht als Chiffrat
     * @param keyForDecryption Schlüssel
     * @return Entschlüsselte Nachricht
     */
    public static String decrypt(String text, String keyForDecryption) {
        text = text.toUpperCase(); // alles Grossbuchstaben
        char[] chars = text.toCharArray();
        char[] key = keyForDecryption.toUpperCase().toCharArray();
        int keyLength = key.length;
        for (int i = 0; i < text.length(); i++) {
            char charToShift = key[i % keyLength];
            chars[i] = deShift(chars[i], charToShift);
        }
// wieder in String wandeln
        return String.valueOf(chars);
    }

    private static char shift(char ch, char k) {
        if (ch >= 'A' && ch <= 'Z') { // Sonderzeichen nicht behandeln
            return (char) (((ch - 'A') + (k - 'A')) % 26 + 'A');
        } else {
            return ch;
        }
    }

    private static char deShift(char ch, char k) {
        if (ch >= 'A' && ch <= 'Z') { // Sonderzeichen nicht behandeln
            return (char) (((ch - 'A') - (k - 'A') + 26) % 26 + 'A');
        } else {
            return ch;
        }
    }

    /**
     * Wie häufig kommt einer der in keyword definierten Wörter im Text vor?
     *
     * @param s Der Text
     * @return Anzahl der Übereinstimmungen
     */
    protected static int occurencesOfKeywords(String s) {
        if (germanKeywordsSet.isEmpty()) // Array in Set überführen
            germanKeywordsSet.addAll(Arrays.asList(keywords)); // sofern nicht bereits geschehen
        String[] words = s.toLowerCase().replaceAll("\\.", "").split(" ");
        int hits = 0;
        for (String word : words) {
            if (germanKeywordsSet.contains(word))
                hits++;
        }
        return hits;
    }

    /**
     * Ist der Text lesbar?
     *
     * @param s Der Text zum Testen
     * @return wahr, wenn der Text vermutlich lesbar ist
     */
    public static boolean isProbablyReadable(String s) {
        int hits = occurencesOfKeywords(s);
        int word = s.toLowerCase().replaceAll("\\.", "").split(" ").length;
        double percentage = ((double) hits) / word;
        return percentage >= threshold;
    }
}
