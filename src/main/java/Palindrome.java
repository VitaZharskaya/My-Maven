public class Palindrome {
    public static void main(String[] args) {
          String palindrome = "шалаШ";
//        StringBuilder str = new StringBuilder();
//        str.append(palindrome.toLowerCase());
//        str.reverse();
//        System.out.println(str.toString().equals(palindrome.toLowerCase()));
        
//          Вариант 2

        boolean isPali = false;
        for (int i = 0; i < palindrome.length(); i++) {

            if (palindrome.charAt(i) == palindrome.charAt(palindrome.length()-1-i)) {
                isPali = true;
            }
        }
        System.out.println(isPali);
    }
}
