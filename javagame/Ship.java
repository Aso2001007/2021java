import java.util.Random;

public class Ship {
    
    Random rnd = new Random();

    //船の場所と体力の設定
    private int vx;
    private int vy;
    private int hp;
    
    public move(){
            Random rnd = new Random();
            int vx = rnd.nextInt(5);
            int vy = rnd.nextInt(5); 
    }

    public void action(int x,int y){
        if(kaizu[x][y]==1){
            System.out.println("命中した！");
        }else if(kaizu[x][y-1]==1){
            System.out.println("波高し");
        }else if(kaizu[x-1][y]==1){
            System.out.println("波高し");
        }else if(kaizu[x+1][y]==1){
            System.out.println("波高し");
        }else if(kaizu[x][y+1]==1){
            System.out.println("波高し");
        }else{
            System.out.println("命中なし！");
        }

    }
}
