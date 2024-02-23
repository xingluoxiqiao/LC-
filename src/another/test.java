package another;

public class test {
    public static int compareVersion(String version1, String version2) {
    String[] v1=version1.split("\\.");
    String[] v2=version2.split("\\.");
    int v1Len=v1.length,v2Len=v2.length;
    int min=Math.min(v1Len,v2Len);
    for(int i=0;i<min;i++){
        String a=v1[i];
        String b=v2[i];
        int res=compare(a,b);
        if(res!=0) return res;
    }
    if(v1Len==v2Len) return 0;
    return v1Len>v2Len?1:-1;

}
    private static int compare(String a,String b){
        int a1=Integer.valueOf(a);
        int b1=Integer.valueOf(b);
        if(a1==b1){
            return 0;
        }else if(a1>b1){
            return 1;
        }else if(a1<b1){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1="0.1";
        String v2="1.1";
        System.out.println(compareVersion(v1,v2));
    }
}
