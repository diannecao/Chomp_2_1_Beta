/*
prepare xyz (board coordinates) and ab (moves) for losing boards, winning boards, and AB arraylists
 */
public class Boards {
    int x;
    int y;
    int z;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;

    int mycols;
    int myrow;

    Boards(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;

    }
    /*
    overload: so you can have a and b without always needing a and b
     */
    Boards(int x, int y, int z,int e, int f,int g,int h,int i,int j,int k,int a,int b){
        this.x=x;
        this.y=y;
        this.z=z;
        this.e=e;
        this.f=f;
        this.g=g;
        this.h=h;
        this.i=i;
        this.j=j;
        this.k=k;
        myrow=b;
        mycols=a;
    }
    /*
   prints out all the optimal moves of all possible boards
     */
    public void print(){
         System.out.println("MYBOARD ("+x+" , "+y+" , "+z+") "+ "("+mycols+" , "+myrow+")");
    }






}


