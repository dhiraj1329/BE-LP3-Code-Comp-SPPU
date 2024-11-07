import java.util.*;

class Node {
    char ch;
    int frequency;
    Node left, right;

    Node(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }
}

public class HuffmanEncoding {

    // Build Huffman Tree using PriorityQueue (Min-Heap)
    public static Node buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.frequency));

        for (var entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }
        return pq.poll();
    }

    // Generate Huffman Codes
    public static void generateCodes(Node root, String code, Map<Character, String> huffmanCode) {
        if (root == null) return;
        if (root.left == null && root.right == null) huffmanCode.put(root.ch, code);

        generateCodes(root.left, code + "0", huffmanCode);
        generateCodes(root.right, code + "1", huffmanCode);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to encode: ");
        String text = scanner.nextLine();

        // Frequency Map
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Build Huffman Tree and Generate Codes
        Node root = buildHuffmanTree(freqMap);
        Map<Character, String> huffmanCode = new HashMap<>();
        generateCodes(root, "", huffmanCode);

        // Encode Text
        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(huffmanCode.get(ch));
        }

        // Decode Text
        StringBuilder decodedText = new StringBuilder();
        Node current = root;
        for (char bit : encodedText.toString().toCharArray()) {
            current = (bit == '0') ? current.left : current.right;
            if (current.left == null && current.right == null) {
                decodedText.append(current.ch);
                current = root;
            }
        }

        // Output Results
        System.out.println("Huffman Codes: " + huffmanCode);
        System.out.println("Encoded Text: " + encodedText);
        System.out.println("Decoded Text: " + decodedText);
    }
}
