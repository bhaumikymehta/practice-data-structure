package easy;

// https://leetcode.com/problems/flood-fill/description/


public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // create similar matrix for output size
        int[][] result = image;
        int[] cornerRows = {-1,1,0,0};
        int[] cornerCols = {0,0,1,-1};
        dfsFloodFill(image,sr,sc,color,image[sr][sc],result, cornerRows,cornerCols);
        return result;
    }
    public static void dfsFloodFill(
        int[][] image, int sr, int sc, int newColor,int initColor,
        int[][] ans,
        int[] cornerRows,int[] cornerCols) {
            ans[sr][sc] = newColor;

            for(int i=0 ; i<4;i++){
                int nextRow = sr + cornerRows[i];
                int nextCol = sc + cornerCols[i];
                //if condition to avoid Array index out of bound
                if(nextRow>= 0 && nextRow<image.length &&
                    nextCol >=0 && nextCol < image[0].length &&
                    image[nextRow][nextCol] == initColor &&
                    ans[nextRow][nextCol] != newColor 

                ){
                dfsFloodFill(
                    image,nextRow,nextCol,newColor,initColor,ans,cornerRows,cornerCols
                    );
                }
            }

    }
}