package lesson1;

public class Human implements User{

    String name;
    final String type = "Human";
    final int lenghtrunhuman = 1000;
    final int heightjumphuman = 1;
    Boolean status = true;

    public Human (String name){
        this.name = name;
    }

    public int run (){
        return lenghtrunhuman;
    }

    public int jump (){
        return heightjumphuman;
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


