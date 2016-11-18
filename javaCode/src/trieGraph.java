/**
 * Created by hhy on 2016/11/10.
 */

class trieGraph {
    public trieGraph[] child;
    public trieGraph[] next;
    public int wordsNum;
    public trieGraph trie;
    public trieGraph father;
    public boolean mark;
    public char path;

    public trieGraph() {
        wordsNum = 0;
        trie = null;
        next = new trieGraph[26];
        child = new trieGraph[26];
        father=null;
        mark=false;
        path='#';
    }

    public trieGraph insert(char c) {
        this.wordsNum += 1;
        if (this.child[c - 'a'] == null) {
            this.child[c - 'a'] = new trieGraph();
            this.child[c - 'a'].father=this;
            this.child[c - 'a'].path=c;
        }
        return this.child[c - 'a'];
    }

    public void insert(String s) {
        trieGraph now = this;
        for (int i = 0; i < s.length(); i++) {
            now = now.insert(s.charAt(i));
        }
        now.wordsNum += 1;
        now.mark=true;
    }

    public String lookup(String s) {
        trieGraph now = this;
        for (int i = 0; now != null && i < s.length(); i++) {
            now = now.next[s.charAt(i) - 'a'];
            if(now.mark) return "YES";
        }
        return "NO";
    }

    public void genNext(){
        if(this.father==null){
            this.trie=this;
            for(int i=0;i<26;i++){
                if(this.child[i]==null){
                    this.next[i]=this;
                }else{
                    this.next[i]=this.child[i];
                }
            }
            return;
        }
        if(this.father.father==null){
            this.trie=this.father;
        }else{
            this.trie=this.father.trie.next[this.path-'a'];
        }
        if(this.trie.mark){
            this.mark=true;
        }
        for(int i=0;i<26;i++){
            if(this.child[i]==null){
                this.next[i]=this.trie.next[i];
            }else{
                this.next[i]=this.child[i];
            }
        }
    }
}
