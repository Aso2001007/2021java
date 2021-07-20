import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        int[][] kaizu;
    
        for(int x=0;x<=4;x++){
            for(int y=0;y<=4;y++){
                kaizu[x][y] = 0;
            }
        }
        
        //題名
        System.out.println("-------------------");
        System.out.println("戦艦ゲーム");
        System.out.println("-------------------");

        //入力値を受け取る
        Scanner sc = new Scanner(System.in);
        
        //爆弾を落とす場所を決める
        System.out.println("X座標を決めてください");
        int x = sc.nextInt();
        System.out.println("Y座標を決めてください");
        int y = sc.nextInt();

        Ship ship1 = new Ship();
        ship1.move();
        ship1.action(x,y);

        Ship ship2 = new Ship();
        ship2.move();
        ship2.action(x,y);

        Ship ship3 = new Ship();
        ship3.move();
        ship3.action(x,y);



    }
}