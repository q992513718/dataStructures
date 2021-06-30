package com.tzy.sprasearray;

public class SpraseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0:表示没有棋子，1表示黑子，2表示白子
        int [][]chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        System.out.println("原始的二维数组");
        // 记录二维数组有效值的个数
        int sum = 0;
        for (int [] array : chessArray) {
            for (int i : array) {
                System.out.printf("%d\t", i);
                if(i != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.printf("二维数组有效值的个数:%d\n", sum);
        // 构造稀疏数组 第一行存储二维数组基本信息：行数，列数，有效值个数
        int [][]spraseArray = new int[sum + 1][3];
        spraseArray[0][0] = 11; // 二维数组行数
        spraseArray[0][1] = 11; // 二维数组列数
        spraseArray[0][2] = 2; // 有效值个数

        // 遍历二维数组取出有效值存入稀疏数组
        int index = 1; // 稀疏数组开始存储有效值的位置
        out:for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if(chessArray[i][j] > 0) {
                    // 有效值存入稀疏数组
                    spraseArray[index][0] = i; // 行
                    spraseArray[index][1] = j; // 列
                    spraseArray[index][2] = chessArray[i][j]; //值
                    index ++;
                    if(index > sum) {
                        break out; // 跳出最外层循环
                    }
                }
            }
        }
        // 打印稀疏数组
        System.out.println("得到的稀疏数组");
        for (int[] array : spraseArray) {
            for (int i : array) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        // 将稀疏转为二维数组
        int row = spraseArray[0][0]; // 取出行数
        int column = spraseArray[0][1]; // 取出列数
        // 构造新的二维数组
        int [][] newChessArray = new int[row][column];
        for (int i = 1; i < spraseArray.length; i++) {
            newChessArray[spraseArray[i][0]][spraseArray[i][1]] = spraseArray[i][2];
        }

        for (int [] array : newChessArray) {
            for (int i : array) {
                System.out.printf("%d\t", i);
                if(i != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
    }
}
