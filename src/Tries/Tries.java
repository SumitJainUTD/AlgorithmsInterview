package Tries;
import java.util.ArrayList;

public class Tries {
	t_Node root;
	int wordCount;
	ArrayList<String> al=  new ArrayList<String>();
	public Tries(){
		root = new t_Node();
		wordCount =0;
	}
	
	public void insert(String word){
		t_Node current = root;
		char [] charWords = word.toCharArray();
		for(int i=0;i<charWords.length;i++){
			int index =  charWords[i]-'a'+1;
			if(current.children[index]==null){
				t_Node newNode = new t_Node();
				current.children[index] = newNode;
			}
			current = current.children[index];
		}
		//Enter the leaf length only when the complete word is filled.
		current.leafLen = ++wordCount;
		current.word = word;
	}
	public boolean find(String word){
		t_Node current = root;
		char [] charWords = word.toCharArray();
		for(int i=0;i<charWords.length;i++){
			int index =  charWords[i]-'a'+1;
			//if any of the character is not found, return null
			if(current.children[index]==null){
				return false;
			}
			//go to next level to check next character
			current = current.children[index];
		}
		if(current.leafLen>0){
			return true;
		}
		return false;
	}
	public ArrayList<String> suggestions(String word){
		// Clear the array List
		al.clear();
		t_Node current = root;
		//get the characters for suggestion
		char [] charWords = word.toCharArray();
//		if(charWords.length<3){
//			al.add("Please Enter atleast 3 characters");
//			return al;			
//		}
		for(int i=0;i<charWords.length;i++){
			int index =  charWords[i]-'a'+1;
			if(current.children[index]==null){
				al.add("No Suggestions");
				return al;
			}
			current = current.children[index];
		}
		//if the word given for suggestion itself is a word, add it to the array list
		if(current.leafLen>0){
			al.add(current.word);
		}
		//get the word suggestions
		getSuggest(current);
		return al;
	}
	public void getSuggest(t_Node node){
		for(int i=0;i<27;i++){
			//travel all the indexes which has characters in it.
			if(node.children[i]!=null){
				//..leafLen >0 means we have found the word
				if(node.children[i].leafLen>0){
					if(!al.contains(node.children[i].word)){
						al.add(node.children[i].word);//add the word to the List
					}										
				}				
				//make a recursive call to next level node.
				getSuggest(node.children[i]);
			}
		}
	}
	
	public static void main(String args[]){
		Tries t = new Tries();
		t.insert("sumit");
		t.insert("car");
		t.insert("carriage");
		t.insert("caravan");
		t.insert("tree");
		t.insert("treet");
		t.insert("treat");
		t.insert("sum");
		t.insert("sumi");
		t.insert("summ");
		t.insert("carz");
		t.insert("country");
		//t.insert("carrot");
		System.out.println(" word 'sumit' exists : "+ t.find("sumit"));
		System.out.println(" word 'tree' exists : "+ t.find("tree"));
		System.out.println(" word 'treet' exists : "+ t.find("treet"));
		System.out.println(" word 'sumi' exists : "+ t.find("sumi"));
		System.out.println(" word 'sum' exists : "+ t.find("sum"));
		String s = "car";
		System.out.println("Suggestions for word '" + s + "': " + t.suggestions(s));
//		System.out.println("Suggestions : " + t.suggestions("sum"));
	}
}

class t_Node{
	int leafLen;
	String word;
	t_Node [] children;
	public t_Node(){
		children = new t_Node[27];
		for(int i=0;i<27;i++){
			children[i] = null;
		}
	}
}
