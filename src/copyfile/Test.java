package copyfile;

public class Test {
    public static void main(String[] args) {
        System.out.println(reverse("test"));
    }

    public static String reverse(String orignStr){
        if (orignStr == null || orignStr.length() <= 1){
            return orignStr;
        }
        return reverse(orignStr.substring(1)) + orignStr.charAt(0);
    }
}
