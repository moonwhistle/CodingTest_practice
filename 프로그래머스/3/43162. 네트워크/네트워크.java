import java.util.*;

class Solution {
    
    static int[] node;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        node = new int[n];
        
        for(int i = 0 ; i < node.length; i++) {
            node[i] = i;
        }
        
        for(int i = 0 ; i < computers.length; i++) {
            for(int j = 0 ; j < computers[i].length; j++) {
                if(i == j) {
                    continue;
                } else if(computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < node.length; i++) {
            set.add(find(node[i]));
        }
        
        return set.size();
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) {
            return;
        }
        
        node[rootB] = rootA;
    }
    
    private int find(int i) {
        if(node[i] == i) {
            return i;
        }
        
        return node[i] = find(node[i]);
    }
}