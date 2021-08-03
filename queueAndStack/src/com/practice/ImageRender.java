package com.practice;

/**
 * @projectName: AlgorithmFundamentals
 * @className: ImageRender
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/31 19:36
 * @version: 1.0
 */

public class ImageRender {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image[sr][sc] != newColor){
            dfsRender(image[sr][sc],newColor,image,sr,sc);
        }

        return image;
    }

    public void dfsRender(int oldColor,int newColor,int[][] image, int sr, int sc){

        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length){
            return;
        }else if(image[sr][sc] == oldColor){
            image[sr][sc] = newColor;

            dfsRender(oldColor,newColor,image,sr-1,sc);
            dfsRender(oldColor,newColor,image,sr+1,sc);
            dfsRender(oldColor,newColor,image,sr,sc-1);
            dfsRender(oldColor,newColor,image,sr,sc+1);

        }

    }
}
