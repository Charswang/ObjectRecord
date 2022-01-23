package leetcode.competition;

public class P21_11_14_2_Robot {
    private int[][] temp;
    private String[] duration;
    private int fangxiang=0;
    private int x=0;
    private int y=0;
    public P21_11_14_2_Robot(int width, int height) {
        temp = new int[width][height];
        duration = new String[4];
        duration[0]="East";
        duration[1]="North";
        duration[2]="West";
        duration[3]="South";
    }

    public void move(int num) {
        int width = temp.length-1;
        int height = temp[0].length-1;

        int geshu=(width+1)*2+(height-2+1)*2;
        num=num%geshu;
        /*
        如果num取余之后==0，并且x和y在四个顶点处，则需要改变原来的方向
        比如原来x=0&y=0，方向指的是East，但是绕过一圈之后(也就是num取余后==0),再回到x=0&y=0这个点的时候，方向是要保持原来的South的；
        因为这个原因，一直卡在140/142这个用例上。。。
         */
        if (num==0){
            if (x==0 && y==0){
                fangxiang = 3;
            }
            if (x==width && y==0){
                fangxiang=0;
            }
            if (x==width&&y==height){
                fangxiang=1;
            }
            if (x==0 && y==height){
                fangxiang=2;
            }
        }
        while(num>0){
            if (fangxiang==0){
                if (x<width){
                    x++;
                }else{
                    fangxiang++;
                    y++;
                }
                num--;
                continue;
            }
            if (fangxiang==1){
                if (y<height){
                    y++;
                }else {
                    fangxiang++;
                    x--;
                }
                num--;
                continue;
            }
            if (fangxiang==2){
                if (x>0){
                    x--;
                }else{
                    fangxiang++;
                    y--;
                }
                num--;
                continue;
            }
            if (fangxiang==3){
                if (y>0){
                    y--;
                }else {
                    fangxiang=0;
                    x++;
                }
                num--;
                continue;
            }
        }
    }

    public int[] getPos() {
        int[] res = new int[2];
        res[0]=x;
        res[1]=y;
        return res;
    }

    public String getDir() {
        return duration[fangxiang];
    }
}
