package com.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    private final static int[] dx = {-1, 0, 0, 1};
    private final static int[] dy = {0, 1, -1, 0};
    public int Solution(int[][] matrix) {
    	int count=0;
    	//Base case when the matrix is null or when the matrix is empty.
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return 0;
        //Base case when the 1st positions is the destination.
        if (matrix[0][0] == 9)
            return 1;
        int m = matrix.length, n = matrix[0].length;
        
        //Create a queue which stores the current position of the BFS search.
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        matrix[0][0] = 1;
        //While the queue is not empty, poll the current position and then check the up down left right positions to see if they are valid.
        //If not skip check the next one in the queue
        //If it is then check if next positions are the destination if it is return, if not then enqueue the next position to search. 
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int[] next = {cur[0] + dx[i], cur[1] + dy[i]};
                if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n) {
                    if (matrix[next[0]][next[1]] == 9)
                            return 1;
                    else if (matrix[next[0]][next[1]] == 0) {
                    	count++;
                        queue.offer(next);
                        matrix[next[0]][next[1]] = 1;
                        System.out.println();
                        printMatrix(matrix);
                        System.out.println(count);
                    }
                }
            }
        }
        
        return 0;
    }
    
    private static void printMatrix(int[][] matrix){
    	for (int x=0; x<matrix.length; x++){
    		for(int y=0; y<matrix[x].length; y++){
    			System.out.print(matrix[x][y]);
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String [] ar){
    	int[][] maze = {
    			{0,0,0},
    			{0,0,0},
    			{0,0,9}
    	};
    	Maze z = new Maze();
    	System.out.println(z.Solution(maze));
    }
}