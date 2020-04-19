package lesson1;

public class Robot implements User{
    String name;
    final String type = "Robot";
    final int lenghtrunrobot = 5000;
    final int heightjumprobot = 2;
    Boolean status = true;

    public Robot(String name) {
        this.name = name;
    }

    public int run (){
        return lenghtrunrobot;
    }

    public int jump (){
        return heightjumprobot;
    }

    public String getName() {
        return name;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status){
        this.status = status;
    }


}
