import java.util.Scanner;
import java.io.FileWriter;  
import java.io.IOException; 
public class main{
    
public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    try{
        FileWriter file = new FileWriter("misses.txt");

    int n = sc.nextInt();
    int k = sc.nextInt();
    for(int x=2;x<k;x++){
        for(int y=2;y<k;y++){
            int xPOWn =(int) Math.pow(x, n);
            int yPOWn =(int) Math.pow(y, n);
            //findZ();
            if(thisIsANearMiss(findZ(n,xPOWn,yPOWn),xPOWn,yPOWn,n)){
                printNearMiss(findZ(n,xPOWn,yPOWn),xPOWn,yPOWn,n,file);
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

static int findZ(int n,int xPOWn,int yPOWn){
    int z,diff1=0,diff2=0;
    for(z=2;Math.pow(z,n)<(xPOWn + yPOWn);z++){
        if(Math.pow(z+1,n)>(xPOWn + yPOWn)){
            diff1 =(xPOWn+yPOWn) - (int) Math.pow(z,n);
            diff2 = (int) Math.pow(z+1,n)-(xPOWn+yPOWn);
            if(diff1<diff2)return z;
            if(diff1>diff2)return z+1;
        }
    }
    return z;
}

static boolean thisIsANearMiss(int z, int x,int y, int n){//this needs fixed 
    if(z == 2)return false;
        
    return true;
}

static void printNearMiss(int z, int x,int y,int n,FileWriter file){
    //System.out.println("X: "+(int)Math.pow(x, 1.0 / n)+ " Y: "+(int)Math.pow(y, 1.0 / n)+" Z: "+z);
    try{
    file.write("\nX: "+(int)Math.pow(x, 1.0 / n)+ " Y: "+(int)Math.pow(y, 1.0 / n)+" Z: "+z);
    }catch(IOException e){
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
        
    //catch
}

}//class