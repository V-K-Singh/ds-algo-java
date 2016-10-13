package com.workshop.ds.island;

public class Island {
	int ROW;
	int COL;
	int[] rowNo = { -1, -1, -1, 0, 0, 1, 1, 1 };
	int[] colNo = { -1, 0, 1, -1, 1, -1, 0, 1 };
	int count;
	int maxIslandSize = 0;
	int size = 0;
	public int island(int[][] inputArray, int row, int col) {
		ROW = row;
		COL = col;
		boolean[][] visited = new boolean[ROW][COL];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (inputArray[i][j] == 1 && !visited[i][j]) {
					count++;
					makeSorrundingVisitedDFS(inputArray, visited, i, j);
					if(size > maxIslandSize){
						maxIslandSize = size;
						size=0;
					}	
				}
			}
		}
		return count;
	}

	private void makeSorrundingVisitedDFS(int[][] inputArray,
			boolean[][] visited, int i, int j) {

		visited[i][j] = true;
		size = size+1;
		for (int k = 0; k < 8; k++) {
			if (isSafe(inputArray, i + rowNo[k], j + colNo[k], visited)) {
				makeSorrundingVisitedDFS(inputArray,visited,i + rowNo[k], j + colNo[k]);
			}
		}
	}

	private boolean isSafe(int[][] inputArray, int row, int col,
			boolean[][] visited) {
		if (row >= 0 && col >= 0 && row < ROW && col < COL
				&& !visited[row][col] 
						&& inputArray[row][col] == 1)
			return true;
		return false;
	}
	public int getMaxIslandSize() {
		return maxIslandSize;
	}
}
