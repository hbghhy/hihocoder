import java.util.Scanner;

/**
 * Created by hhy on 2016/11/3.
 */
public class h1014 {
    public static void main(String[] args) {
        //trieTree

        //Solve
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        trieTree root=new trieTree();
        while(n-->0){
            String s=scanner.next();
            root.insert(s);
        }
        int m=scanner.nextInt();
        while(m-->0){
            String s=scanner.next();
            System.out.println(root.lookup(s));
        }



    }
}
