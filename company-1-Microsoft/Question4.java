/*
 * 661. Image Smoother
An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by 
rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine 
cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do 
not consider it in the average (i.e., the average of the four cells in the red smoother).
 */
public class Question4 {
    public static int[][] imageSmoother(int[][] img) {
        int rows=img.length;
        int cols=img[0].length;
        int res[][]=new int[rows][cols];
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                res[r][c]=calculateAverage(img,r,c,rows,cols);
            }
        }
        return res;
    }

private static int calculateAverage(int[][] img,int r,int c,int rows,int cols){
  int total=0;
  int count=0;
  int top=Math.max(0,r-1);
  int bottom=Math.min(rows,r+2);
  int left=Math.max(0,c-1);
  int right=Math.min(cols,c+2);

  for(int row=top;row<bottom;row++){
    for(int col=left;col<right;col++){
        total+=img[row][col];
        count+=1;
    }
  }
  return total/count;
}
    public static void main(String[] args) {
        int[][] img={{1,1,1},{1,0,1},{1,1,1}};
        System.out.println();
        int[][] res=imageSmoother(img);
    }
}
