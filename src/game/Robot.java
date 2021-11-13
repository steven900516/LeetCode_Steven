package game;

/**
 * @author Steven0516
 * @create 2021-11-13
 */
class Robot {
    int x;
    int y;
    int width;
    int height;
    String direction;
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        direction = "East";
    }

    public void move(int num) {
        while(num > 0){
            switch (direction){
                case "East":
                    if(++x > width - 1){
                        this.direction = "North";
                        --x;
                    }else{
                        num--;
                    }
                    break;
                case "North":
                    if(++y > height - 1){
                        this.direction = "West";
                        --y;
                    }else{
                        num--;
                    }
                    break;
                case "West":
                    if(--x < 0){
                        this.direction = "South";
                        ++x;
                    }else{
                        num--;
                    }
                    break;
                case "South":
                    if(--y < 0){
                        this.direction = "East";
                        y++;
                    }else{
                        num--;
                    }
                    break;
            }
        }
    }

    public int[] getPos(){
        return new int[]{x,y};
    }

    public String getDir() {
        return direction;
    }
}
