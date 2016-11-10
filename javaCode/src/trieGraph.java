/**
 * Created by hhy on 2016/11/10.
 */

public class trieGraph {

    public trieGraph[] child;
    public int wordsNum;
    public boolean mark;
    public trieGraph father;
    public trieGraph[] next;
    public char letter;

    public trieGraph(){
        wordsNum=0;
        child=new trieGraph[26];
        next=new trieGraph[26];
        this.mark=false;
        father=this;
        letter='#';
    }
    public trieGraph insert(char c){
        this.wordsNum+=1;
        if(this.child[c-'a']==null){
            this.child[c-'a']=new trieGraph();
            this.child[c-'a'].father=this;
            this.child[c-'a'].letter=c;
        }
        return this.child[c-'a'];
    }
    public void insert(String s){
        trieGraph now=this;
        for(int i=0;i<s.length();i++){
            now=now.insert(s.charAt(i));
        }
        now.wordsNum+=1;
        now.mark=true;
    }
    public int lookup(String s){
        trieGraph now=this;
        for(int i=0;now!=null && i<s.length();i++){
            now=now.child[s.charAt(i)-'a'];
        }
        if(now==null) return 0;
        return now.wordsNum;
    }

    public void genNext(){
        for(int i=0;i<='z'-'a';i++){
            if(this.child[i]==null){
                if(this.father!=this){
                    this.next[i]=this.father.next[this.letter-'a'].next[i];
                }else {
                    this.next[i]=this;
                }
            }else{
                this.next[i]=this.child[i];
            }
        }
    }

}
