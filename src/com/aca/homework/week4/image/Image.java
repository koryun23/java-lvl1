package com.aca.homework.week4.image;

public class Image {
    private int rows;
    private int columns;
    private char[][] image;
    public Image(int columns, int rows){
        this.rows = rows;
        this.columns = columns;
        this.image = new char[this.rows][this.columns];
        this.fillImage();
    }

    public void fillImage(){
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                this.image[i][j] = '-';
            }
        }
    }
    public void show(){
        for(int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.columns; j++){
                System.out.print(this.image[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void draw(int i, int j){
        this.image[i][j] = '*';
    }


}
