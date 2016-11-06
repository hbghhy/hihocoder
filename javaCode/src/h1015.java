import java.util.Scanner;

/**
 * Created by hhy on 2016/11/6.
 */
public class h1015 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        while(n-->0){
            String pattern=scanner.next();
            String origin=scanner.next();
            int[] next=new int[pattern.length()];
            generateNext(pattern,next);
            System.out.println(kmp(origin,pattern,next));
        }
    }
    public static void generateNext(String pattern,int[] next){
        next[0]=-1;
        for(int i=1;i<next.length;i++){
            int j=next[i-1];
            while(j!=-1){
                if(pattern.charAt(i)==pattern.charAt(j+1)){
                    next[i]=j+1;
                    break;
                }else{
                    j=next[j];
                }
            }
            if(j==-1){
                next[i]=(pattern.charAt(i)==pattern.charAt(0))?0:-1;
            }
        }
    }
    public static int kmp(String origin,String pattern,int[] next){
        int i=0,j=0,ans=0;
        while(i<origin.length()){
            if(origin.charAt(i)==pattern.charAt(j)){
                i++;j++;
                if(j==pattern.length()){
                    ans++;j=next[j-1]+1;
                }
            }else if(j>0){
                j=next[j-1]+1;
            }else{
                i++;
            }
        }
        return ans;
    }
}
