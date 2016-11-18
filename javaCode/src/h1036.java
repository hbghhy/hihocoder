
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by hhy on 2016/11/10.
 */
public class h1036 {

    public static void main(String[] args) {
        //trieTree

        //Solve
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        trieGraph root=new trieGraph();
        while(n-->0){
            String s=scanner.next();
            root.insert(s);
        }
        LinkedList<trieGraph> que=new LinkedList<trieGraph>();
        que.add(root);
        while (que.size()>0){
            trieGraph now=que.pollFirst();
            now.genNext();
            for(int i=0;i<26;i++){
                if(now.child[i]!=null){
                    que.add(now.child[i]);
                }
            }
        }
        String s=scanner.next();
        System.out.println(root.lookup(s));


    }
}
