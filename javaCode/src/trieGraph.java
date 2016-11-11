/**
 * Created by hhy on 2016/11/10.
 */

class trieGraph {

    public trieGraph[] child;
    public int wordsNum;
    public boolean mark;
    public trieGraph trie;
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
            this.child[c-'a'].letter=c;
            this.child[c-'a'].father=this;
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
    public boolean lookup(String s){
        trieGraph now=this;
        for(int i=0;now!=null && i<s.length();i++){
            if(now.mark) return true;
            now=now.next[s.charAt(i)-'a'];
        }
        return false;
    }

    public void genNext(){
        if(this==null) return;
        if(this.father==this ){
            this.trie=this;
        }else if( this.father.father==this.father){
            this.trie=this.father;
        }
        else{
            this.trie=this.father.trie.next[this.letter-'a'];
        }
        for(int i=0;i<='z'-'a';i++){
            if(this.child[i]==null){
                if(this.father!=this){
                    this.next[i]=this.trie.next[i];
                }else {
                    this.next[i]=this;
                }
            }else{
                this.next[i]=this.child[i];
            }
        }
    }

}
