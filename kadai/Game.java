package kadai;

import java.util.Scanner;

public class Game {
    private final int SHIP_NUM = 3;
    private final int MAP_SIZE = 5;
    private Ship[] ships = new Ship[SHIP_NUM];
    private Map map = new Map();

    //コンストラクタ
    public Game(){
        for(int i = 0; i < SHIP_NUM; i++){
            ships[i] = new Ship();
        }
    }

    //初期化
    public void init(){
        map.init(MAP_SIZE);
        for(int i = 0; i < SHIP_NUM; i++){
            do{
                ships[i].init(MAP_SIZE);
            }while(!map.deployShip(ships[i]));
        }
    }
    
    //
    public void execute(){
        int attackX;
        int attackY;

        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        
        title();
        while(!isAllsink()){
            System.out.println("---------[ターン"+turn+"]----------");
            displaysituation();
            System.out.println("爆弾のx座標を決めてください(1-"+MAP_SIZE+")");
            attackX = scanner.nextInt();
            System.out.println("爆弾のy座標を決めてください(1-"+MAP_SIZE+")");
            attackY = scanner.nextInt();

            for(int i=0;i<SHIP_NUM;i++){
                int result = ships[i].check(attackX-1,attackY-1);
                //
                doByResult(ships[i],i+1,result);
            }
            turn++;
        }
        System.out.println("全て撃沈！おめでとう！");

        scanner.close();
    }
    private void title(){
        System.out.println("------------------");
        System.out.println("    戦艦ゲーム！！　　");
        System.out.println("------------------");   
    }
    private boolean isAllsink(){
        boolean allsink = true;//全て撃沈
        for(int i=0; i<SHIP_NUM; i++){
            if(ships[i].isAlive() ){
                allsink = false;
                break;
            }
        }

        return allsink;
    }
    private void displaysituation(){
        for(int i=0;i<SHIP_NUM;i++){
            if(ships[i].isAlive()){
                System.out.println("船"+(i+1)+":生きてる");
            }else{
                System.out.println("船"+(i+1)+":撃沈済み");
            }
        }
    }

    private void doByResult(Ship ship,int no,int reslut){
        if(reslut==Ship.NO_HIT){
            System.out.println("船"+no+":はずれ！");
        }else if(reslut==Ship.NEAR){
            System.out.println("船"+no+":波高し！");
        }else if(reslut==Ship.HIT){
            System.out.println("船"+no+":爆弾があたった！しかしまだ船は沈まない！船は移動します");
            moveship(ship);
        }else{
            System.out.println("船"+no+"爆弾があたった！！撃沈しました！");
            map.clear(ship.getPosX(),ship.getPosY());
        }
    }
    private void moveship(Ship ship) {
            
        //一旦今の場所をクリアする
        map.clear(ship.getPosX(),ship.getPosY());
        do{
            ship.move(MAP_SIZE);
        }while(!map.deployShip(ship));
    }
}
