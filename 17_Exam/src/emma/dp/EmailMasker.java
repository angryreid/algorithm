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
      maskedEmail.append("*".repeat(Math.max(0, firstPart.length() - 2)));
      maskedEmail.append(firstPart.charAt(firstPart.length() - 1));
    }
    maskedEmail.append("@").append(secondPart);
    return maskedEmail.toString();
  }
}