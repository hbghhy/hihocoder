/**
 * Created by hhy on 2016/11/3.
 */
class trieTree{
    //trie tree(only for lowercase letter)
    public trieTree[] next;
    public int wordsNum;
    public trieTree(){
        wordsNum=0;
        next=new trieTree[26];
    }
    public trieTree insert(char c){
        this.wordsNum+=1;
        if(this.next[c-'a']==null){
            this.next[c-'a']=new trieTree();
        }
        return this.next[c-'a'];
    }
    public void insert(String s){
        trieTree now=this;
        for(int i=0;i<s.length();i++){
            now=now.insert(s.charAt(i));
        }
        now.wordsNum+=1;
    }
    public int lookup(String s){
        trieTree now=this;
        for(int i=0;now!=null && i<s.length();i++){
            now=now.next[s.charAt(i)-'a'];
        }
        if(now==null) return 0;
        return now.wordsNum;
    }

}