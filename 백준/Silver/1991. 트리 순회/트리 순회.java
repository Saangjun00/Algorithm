import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static Node[] tree;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent);
            }

            if (leftChild != '.') {
                tree[parent - 'A'].left = new Node(leftChild);
                tree[leftChild - 'A'] = tree[parent - 'A'].left;
            }

            if (rightChild != '.') {
                tree[parent - 'A'].right = new Node(rightChild);
                tree[rightChild - 'A'] = tree[parent - 'A'].right;
            }
        }

        preorder(tree[0]);
        sb.append("\n");

        inorder(tree[0]);
        sb.append("\n");

        postorder(tree[0]);

        System.out.println(sb);
    }

    private static class Node {
        char value;
        Node left;
        Node right;
    
        public Node(char value) {
            this.value = value;
        }
    }

    // 전위 순회
    private static void preorder(Node node) {
        if (node == null) {
            return;
        }

        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    private static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    // 후위 순회
    private static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }
}


