import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList<Boards> losingBoard = new ArrayList<Boards>();

    ArrayList<Boards> winningBoard = new ArrayList<Boards>();
    public ArrayList<Boards> AB = new ArrayList<Boards>();

    ArrayList<Boards> onBoard = new ArrayList<Boards>();

    public int currentcols=0;
    public int currentrow=0;


    public MyPlayer() {
        columns = new int[10];
        diannesCode();
    }

    //add your code to return the row and the column of the chip you want to take.
    //you'll be returning a data type called Point which consists of two integers.
    // import com.sun.tools.javac.Main;

//import java.util.ArrayList;

    // public class Chomp {


    /*
    in Chomp use nested for loops to generate all possible boards and call
    the organizer method eveytime it generates a new board, it also reads
    and records everything into the AB board array
     */
    public void diannesCode() {
        boolean gameOver = false;
        losingBoard.add(new Boards(1,0,0));

        int cnt = 0;
        for(int i=0; i<=3; i++){
            for(int j=0; j<=i; j++){
                for (int k = 0; k<=j; k++) {
                    if(i==0 && j==0 && k==0) {
                        continue;
                    }
                    cnt ++;
                    //System.out.println("Possible board Number " + cnt);
                   // System.out.println(i + " " + j + " " + k);
                    Organizer(i, j, k);
                    AB.add(new Boards(i, j, k, currentcols, currentrow));


                }
            }
        }
        System.out.println("allboards");
        for(int x=0;x<AB.size();x++){
            AB.get(x).print();
        }
    }
    /*
    reducer/organizer method does actions to the possible boards
    1) it organizes the boards into possibilities of the next step
    2) it finds the moves that you have to take to get to a next step board
    3) it runs through all the next step boards and assign their possible board as a losing/winning board
    4) after it finds a losing board it prints out the optimal move
     */
    public void Organizer(int i, int j, int k) {
        boolean hasLosingBoard=false;

        //System.out.println("Organized boards");

        for(int c=k-1; c>=0; c--){ // third column --
            for(int p=0; p< losingBoard.size(); p++) {
                if (i == losingBoard.get(p).x && j == losingBoard.get(p).y && c == losingBoard.get(p).z) {
                    currentcols=2;
                    currentrow=c;
                 //   System.out.println("THE MOVE: "+ "2"+ "-"+c);
                    hasLosingBoard = true;
                }
            }
            //System.out.println(i+" "+j+ " "+c);
            //System.out.println("1Pick "+ "2" + "-" +c);
        } // end of third column reduced boards


        for(int b=j-1; b>=0; b--){ // second column --
            if (b<k) {
                for(int p=0; p< losingBoard.size(); p++) {
                    if (i == losingBoard.get(p).x && b == losingBoard.get(p).y && b == losingBoard.get(p).z) {
                        currentcols=1;
                        currentrow=b;
                      //  System.out.println("THE MOVE: "+ "1"+ "-"+b);
                        hasLosingBoard = true;
                    }
                }
               // System.out.println(i+" "+b+" "+b);
                // System.out.println("2Pick "+ "1" + "-" +b);
            }
            else {
                for(int p=0; p< losingBoard.size(); p++) {
                    if (i == losingBoard.get(p).x && b == losingBoard.get(p).y && k == losingBoard.get(p).z) {
                        currentcols=1;
                        currentrow=b;
                    //    System.out.println("THE MOVE: "+ "1"+ "-"+b);
                        hasLosingBoard = true;
                    }
                }
               // System.out.println(i + " " + b + " " + k);
                // System.out.println("3Pick "+ "1" + "-" +b);
            }
        } // end of second column reduced boards


        for(int a=i-1; a>0; a--){// first column --
            if(a<j && a<k){
                for(int p=0; p< losingBoard.size(); p++) {
                    if (a == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z) {
                        currentcols=0;
                        currentrow=a;
                       // System.out.println("THE MOVE: "+ "0"+ "-"+a);
                        hasLosingBoard = true;
                    }
                }
             //   System.out.println(a+" "+a+" "+a);
                //   System.out.println("4Pick "+ "0" + "-" +a);

            }else if(a<j && a>k){
                for(int p=0; p< losingBoard.size(); p++) {
                    if (a == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z) {
                        currentcols=0;
                        currentrow=a;
                        //  System.out.println("THE MOVE: "+ "0"+ "-"+a);
                        hasLosingBoard = true;
                    }
                }
              //  System.out.println(a+" "+a+" "+k);
                // System.out.println("5Pick "+ (j-2) + "-" +a);

            }else if(a<j && a==k){
                // j=a;
                for(int p=0; p< losingBoard.size(); p++) {
                    if (a == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z) {
                        currentcols=0;
                        currentrow=a;
                      //  System.out.println("THE MOVE: "+ "0"+ "-"+a);
                        hasLosingBoard = true;
                    }
                }
               // System.out.println(a+" "+a+" "+k);
            }

            for(int p=0; p< losingBoard.size(); p++) {
                if (a == losingBoard.get(p).x && j == losingBoard.get(p).y && k == losingBoard.get(p).z) {
                    currentcols=0;
                    currentrow=a;
                  //  System.out.println("THE MOVE: "+ "0"+ "-"+a);
                    hasLosingBoard = true;
                }
            }

        } // end of first column reduced boards

        if(hasLosingBoard==false){
            for (Boards board : losingBoard) {
                if(i== board.x && j== board.y && k== board.z){
                    break;
                }
            }
            losingBoard.add(new Boards(i, j, k));
         //   System.out.println("This is a losing board!");
        } else {
            winningBoard.add(new Boards(i, j, k));
          //  System.out.println("This is a winning board!");
        }
//        for (int a=0; a <= i; a++) {

//            for (int b =0; b <= j; b++) {
//                    for (int c=0; c<=k; c++) {
//                        if(i==1 && j==0 && k==0){
//                         //   System.out.println("losing board");
//                        }
//
//                     //   System.out.println(i + " " + j + " " + k);
//                }

        //}
//        for(int p=0; p<losingBoard.size();p++ ) {
//            System.out.println("Losing "+ losingBoard.get(p).x+ " "+losingBoard.get(p).y+" "+losingBoard.get(p).z);
//        }

//        for (Boards board : losingBoard) {
//            System.out.println("Losing " + board.x + " " + board.y + " " + board.z);
//        }

    }
    //}

    public Point move(Chip[][] pBoard) {
        int count=0;

        columns = new int[10];

        for(int x=0; x<10; x++){
            for(int y=0; y<10;y++){
                if(pBoard[x][y].isAlive == true) {
                    columns[y]++;
                }
            }
        }
        for(int x=0;x<AB.size();x++) {
            System.out.println("I am working");
//            for(int c=0; c<10;c++) {
//                System.out.print(columns[c] + ",");
//            }
            if (AB.get(x).x == columns[0] && AB.get(x).y == columns[1] && AB.get(x).z == columns[2]) {
                System.out.println("Optimal move please"+AB.get(x).mycols + " , " + AB.get(x).myrow);
            }

        }
        for(int c=0; c<10;c++){
            System.out.print(columns[c]+",");
            columns[c]=0;
        }


        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        Point myMove = new Point(row, column);
        return myMove;
    }

}
