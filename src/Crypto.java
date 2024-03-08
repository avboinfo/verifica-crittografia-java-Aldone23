public class Crypto{

    public static String cesarCrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) ((((ch - base + shift) % 26 + 26) % 26) + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String cesarDecrypt(String text, int shift) {
        return cesarCrypt(text, 26 - shift);
    }       
}    