package lesson1;

public class Cat implements User{
    String name;
    final String type = "Cat";
    final int lenghtruncat = 500;
    final int heightjumpcat = 2;
    Boolean status = true;


    public Cat(String name) {
        this.name = name;
    }

    public int run (){
        return lenghtruncat;
    }

    public int jump (){
        return heightjumpcat;
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
