package lesson1;

public class Treadmill extends Course {
    int limit;

    public Treadmill(int limit) {
        this.limit = limit;
    }

//    public boolean doIt() {
//        return false;
//    }

    public boolean doIt (int limit){
        if (limit >= this.limit) return true;
        else return false;
    }

}
