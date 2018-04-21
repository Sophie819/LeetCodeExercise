package name.sophy.easy;
import java.util.HashSet;

/** 
* @author	Fei Shao Email:fshao@smail.nju.edu.cn
* @version	2018年3月15日 下午9:37:21 
* Introduction of the class:	考察trie(单词查找树、字典树)+DFS
*/
public class EX_720 {
	
	public String longestWord(String[] words) {
        return "";
    }
}

class Node{
	char nodeChar;
	HashSet<Node> childNode = new HashSet<Node>();
	boolean isLeaf;
	
	public Node(char c){
		this.nodeChar = c;
	}
}
class Trie{
	Node root;	//根节点
	
	public Trie() {
		root = new Node('0');
	}
	
	public void constructTrie(String word){	//插入一个字符串，构建新的trie
		Node temp = this.root;
		for(char c : word.toCharArray()){
			
		}
	}
	
	public String DFS(){	//在trie上进行深度优先搜索，找到那个最长字符串，可能有多个，需要返回字典序较小的那一个即可
		return "";
	}
}
 