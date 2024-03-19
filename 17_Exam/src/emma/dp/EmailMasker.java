package emma.dp;

/**
 * this class is used to mask email addresses
 * split the email address into two parts at the '@' symbol
 * mask the first part at left following below rules:
 * - if the first part lenght is less than 3, mask all characters
 * - otherwise, the first letter and the last letter of the first part is visible, mask the rest of the characters
 */

public class EmailMasker {
    public static void main(String[] args) {
        String email = "";
        System.out.println(maskEmail(email));
    }

    public static String maskEmail(String email) {
        if (email == null || email.length() == 0) {
            return "";
        }
        String[] parts = email.split("@");
        String firstPart = parts[0];
        String secondPart = parts[1];
        if (firstPart.length() <= 3) {
            return "***" + "@" + secondPart;
        } else {
            // return firstPart.charAt(0) + "***" + firstPart.charAt(firstPart.length() - 1) + "@" + secondPart;
            // the first character and the last character of the first part is visible
            // the rest characters of the first part is "*"
            return firstPart.charAt(0) + new String(new char[firstPart.length() - 2]).replace("\0", "*") + firstPart.charAt(firstPart.length() - 1) + "@" + secondPart;
        }
    }
}

