package 每日一题;

public class day8_2129_capitalizeTitle {
    public static String capitalizeTitle(String title) {
        StringBuilder sb=new StringBuilder(title);
        int n=title.length();
        int l=0,r=0;
        while(r<n){
            while(r<n&&title.charAt(r)!=' '){
                ++r;
            }
            if(r-l>2){
                sb.setCharAt(l,Character.toUpperCase(sb.charAt(l)));
                ++l;
            }
            while(l<r){
                sb.setCharAt(l,Character.toLowerCase(sb.charAt(l)));
                ++l;
            }
            l=r+1;
            ++r;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new String("capiTalIze tHe titLe");
        System.out.println(capitalizeTitle(s));
    }
}
