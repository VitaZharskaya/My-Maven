public class guri {

    public static void main(String[] args) {
        String str = "aaaabbcdddddaeeeee";
        int count = 0;
        for (int i = 0; i < str.length() ; i++) {
           if (str.charAt(i) == str.charAt(i+1)){
               count++;
           }
        }
        System.out.println(count);
    }
}
