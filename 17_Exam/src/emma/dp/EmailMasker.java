package emma.dp;

public class EmailMasker {
  public static void main(String[] args) {
    String email = "";
    try {
      System.out.println(maskEmail(email));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public static String maskEmail(String email) {
    if (email == null || email.isEmpty()) {
      throw new IllegalArgumentException("Email cannot be null or empty");
    }
    String[] parts = email.split("@");
    if (parts.length != 2) {
      throw new IllegalArgumentException("Invalid email format");
    }
    String firstPart = parts[0];
    String secondPart = parts[1];
    StringBuilder maskedEmail = new StringBuilder();
    if (firstPart.length() <= 3) {
      maskedEmail.append("***");
    } else {
      maskedEmail.append(firstPart.charAt(0));
      int length = Math.max(0, firstPart.length() - 2);
      for (int i = 0; i < length; i++) {
        maskedEmail.append("*");
      }
      maskedEmail.append(firstPart.charAt(firstPart.length() - 1));
    }
    maskedEmail.append("@").append(secondPart);
    return maskedEmail.toString();
  }

  public static String maskEmail2(String email) {
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