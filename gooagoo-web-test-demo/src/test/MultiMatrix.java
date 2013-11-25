package com.gooagoo.test;

public class MultiMatrix
{
    int[][] multiplyMatrix;

    public static void main(String args[])
    {
        int[][] a = { { 1, 0, 3, -1 }, { 2, 1, 0, 2 } };
        int[][] b = { { 4, 1, 0 }, { -1, 1, 3 }, { 2, 0, 1 }, { 1, 3, 4 } };
        MultiMatrix mm = new MultiMatrix();
        mm.mMatrix(a, b);
        mm.display();

    }

    public void mMatrix(int[][] a, int[][] b)
    {
        this.multiplyMatrix = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
        {//rows of a
            for (int j = 0; j < b[0].length; j++)
            {//columns of b
                for (int k = 0; k < a[0].length; k++)
                {//columns of a = rows of b
                    this.multiplyMatrix[i][j] = this.multiplyMatrix[i][j] + a[i][k] * b[k][j];
                }
            }
        }
    }

    public void display()
    {
        for (int i = 0; i < this.multiplyMatrix.length; i++)
        {
            for (int j = 0; j < this.multiplyMatrix[0].length; j++)
            {
                System.out.print(this.multiplyMatrix[i][j] + " ");

            }
            System.out.println("");
        }
    }
}
