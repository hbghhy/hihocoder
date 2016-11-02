import java.util.Scanner;

/**
 * Created by hanyuhuang on 2016/11/2.
 */
public class h1032 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        while(n-->0){
            String s=addSpecialChar(scanner.next(),'#');
            int[] p=new int[s.length()];
            p[0]=1;
            int maxId=1,maxCenter=0;
            int ans=0;
            for(int i=1;i<p.length;i++){
                if(i>=maxId){
                    int j;
                    for(j=1;i+j<p.length && i-j>=0 && s.charAt(i+j)==s.charAt(i-j) ;j++){

                    }
                    p[i]=j;
                }else{
                    int left=2*maxCenter-i;
                    if(left>=0 &&  p[left]<maxId-i){
                        p[i]=p[left];
                    }else{
                        int j;
                        for(j=maxId-i;i+j<p.length && i-j>=0 && s.charAt(i+j)==s.charAt(i-j) ;j++){

                        }
                        p[i]=j;
                    }
                }
                if(p[i]+i>=maxId){
                    maxCenter=i;
                    maxId=p[i]+i;
                }
                if(p[i]-1>ans) {
                    ans=p[i]-1;
                }
            }
            System.out.println(ans);
        }
    }
    public static String addSpecialChar(String s, char c){
        StringBuilder sb=new StringBuilder();
        sb.append(c);
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i)).append(c);
        }
        return sb.toString();
    }
}
