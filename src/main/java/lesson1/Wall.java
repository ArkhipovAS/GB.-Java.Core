package lesson1;

public class Wall extends Course{

    int limit;

    public Wall(int limit) {
        this.limit = limit;
    }

    public boolean doIt() {
        return false;
    }

    public boolean doIt (int limit){
        if (limit >= this.limit) return true;
        else return false;
    }


}
