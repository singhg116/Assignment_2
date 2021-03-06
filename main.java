//Looking for Fermat's Last Theorem Near Misses
//the name of the file that holds your program
//Main.java, Pair.java, Misses.txt
//After running Main.java, the results will be printed to the Misses.txt
//Guriqbal Singh, Raj Patel, Jared Konop
//Singhg@duq.edu, Patelr3@duq.edu, Konopj@duq.edu 
//COSC 445W
//3-5-2021
//This program searches for "near misses" for Fermat's last theorem 

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

          
public class main{

public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    try{
        FileWriter file = new FileWriter("misses.txt");

    System.out.println("Enter the the value for N: ");
    int n = sc.nextInt();
    while (n < 2 || n > 12) {
        System.out.print("Error: Enter a number greater than 2 and less than 12 for N: ");
        n = sc.nextInt();
      }

    System.out.println("Enter the value for K: ");
    int k = sc.nextInt();
    while (k<=10) {
        System.out.print("Error: Enter a number greater than 10 for K: ");
        k = sc.nextInt();
      }

    for(int x=2;x<k;x++){
        for(int y=2;y<k;y++){
            int xPOWn =(int) Math.pow(x, n);
            int yPOWn =(int) Math.pow(y, n);
            //findZ();
            Pair p = findZ(n, xPOWn, yPOWn);
            if(thisIsANearMiss(p.z,xPOWn,yPOWn,n)){
                printNearMiss(p.z,xPOWn,yPOWn,n,file,p.r);
            }

        }//for y
    }//for x
    file.close();
}catch(IOException e){
    System.out.println("An error occurred.");
    e.printStackTrace();
    }
    sc.close();
}//main

static Pair findZ(int n,int xPOWn,int yPOWn){
    Pair res;
    int z,diff1=0,diff2=0;
    for(z=2;Math.pow(z,n)<(xPOWn + yPOWn);z++){
        if(Math.pow(z+1,n)>(xPOWn + yPOWn)){
            diff1 =(xPOWn+yPOWn) - (int) Math.pow(z,n);
            diff2 = (int) Math.pow(z+1,n)-(xPOWn+yPOWn);
            if(diff1<=diff2)return res = new Pair(z, getRForZ(z,xPOWn, yPOWn,n));
            if(diff1>diff2)return res = new Pair(z+1, getRForZPlusOne(z,xPOWn, yPOWn,n));
        }
    }
    return new Pair(z, getRForZ(z,xPOWn, yPOWn,n));//debug 
}

static boolean thisIsANearMiss(int z, int x,int y, int n){//this needs fixed
    if(z == 2)return false;

    return true;
}

static void printNearMiss(int z, int x,int y,int n,FileWriter file,double r){
    //System.out.println("X: "+(int)Math.pow(x, 1.0 / n)+ " Y: "+(int)Math.pow(y, 1.0 / n)+" Z: "+z);
    try{
    file.write("\nX: "+(int)Math.pow(x, 1.0 / n)+ " Y: "+(int)Math.pow(y, 1.0 / n)+" Z: "+z+" RELATIVE MISS: "+ r);
    }catch(IOException e){
        System.out.println("An error occurred.");
        e.printStackTrace();
    }//catch
}

static Double getRForZ(int z,int xPOWn, int yPOWn,int n){
    return (xPOWn + yPOWn) -(Math.pow(z,n));

}

static Double getRForZPlusOne(int z,int xPOWn, int yPOWn,int n){
    return (Math.pow(z,n)) - (xPOWn + yPOWn);

}


}//class