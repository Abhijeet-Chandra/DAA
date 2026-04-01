import java.util.PriorityQueue;

class Node{
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

public class HuffmanEncoding {

    public static Node huffman(String str){
        int [] freq = new int[26]; //freq array to track frequency of each character

        //priority queue to pick minimum freq everytime
        PriorityQueue <Node> pq = new PriorityQueue<>(
            (a,b)-> a.freq - b.freq
        );

        //calculate freq of each character
        for(int i = 0; i<str.length(); i++){
            freq[str.charAt(i)-'A']++;
        }

        //initialize priority queue
        for(int i = 0; i<26; i++){
            if(freq[i]!=0){
                pq.add(new Node((char)(i+'A'), freq[i]));
            }
        }

        while(pq.size()>1){ 
            //pop out the nodes with lowest and second lowest freq
            Node n1 = pq.poll();
            Node n2 = pq.poll();

            Node root = new Node('$', n1.freq+n2.freq);
            root.left = n1;
            root.right = n2;

            pq.add(root);
        }

        return pq.peek();
    }

    public static void preorder(Node root, String code){
        if(root==null)return;
        
        if(root.left==null&&root.right==null){
            System.out.println("Character: "+root.ch+" ,code: "+code);
        }
        preorder(root.left,code+"0");
        preorder(root.right,code+"1");
    }
    public static void main(String[] args) {
        Node root = huffman("DSAPAGLU");
        System.out.println("Huffman Codes: ");
        preorder(root, "");
    }
}
