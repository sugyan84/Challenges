/* IMPORTANT: Multiple classes and nested static classes are supported */


/* uncomment this if you want to read input.*/
//imports for BufferedReader

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

//import for Scanner and other utility classes

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input */

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String name = br.readLine();                // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        /*Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/

        // Write your code here
        int noOfNodes = Integer.parseInt(br.readLine());
        //char[] power = new char[noOfNodes];
        LinkedList<Integer>[] linkedNodes = new LinkedList[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            linkedNodes[i] = new LinkedList();
        }

        String[] powersStr = br.readLine().split(" ");
        for (int i = 0; i < noOfNodes - 1; i++) {
            String[] line = br.readLine().split(" ");
            int startNode = Integer.parseInt(line[0]) - 1;
            int endNode = Integer.parseInt(line[1]) - 1;
            addNode(linkedNodes, startNode, endNode);
        }

        int noOfQueries = Integer.parseInt(br.readLine());
        for (int i = 0; i < noOfQueries; i++) {
            String[] line = br.readLine().split(" ");
            int startNode = Integer.parseInt(line[0]) - 1;
            int endNode = Integer.parseInt(line[1]) - 1;
            System.out.println(answerQuery(powersStr, linkedNodes, startNode, endNode));
        }
    }

    private static void addNode(LinkedList<Integer>[] linkedNodes, int startNode, int endNode) {
        linkedNodes[startNode].add(endNode);
        linkedNodes[endNode].add(startNode);
    }

    private static String answerQuery(String[] powersStr, LinkedList<Integer>[] linkedNodes, int startNode,
            int endNode) {
        TreeMap<String, Integer> map = new TreeMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int currElement = queue.poll();

            if (!visited.contains(currElement)) {
                visited.add(currElement);

                LinkedList<Integer> others = linkedNodes[startNode];
                if (others.contains(endNode)) {
                    queue.offer(endNode);
                } else {
                    Iterator<Integer> itr = others.iterator();
                    while (itr.hasNext()) {
                        int elem = itr.next();
                        queue.offer(elem);
                    }
                }

                if (map.containsKey(powersStr[currElement])) {
                    int oldVal = map.get(powersStr[currElement]);
                    map.put(powersStr[currElement], oldVal + 1);
                } else {
                    map.put(powersStr[currElement], 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> collect = map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());
        return collect.get(0).getKey();
    }
}
