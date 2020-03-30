package lesson1;

public class Competition {


    public static void main(String[] args) {
        User[] user = new User[3];
        Course[] carr = new Course[2];
        user[0] = new Human("Vasya");
        user[1] = new Robot("Verter");
        user[2] = new Cat("Barsik");
        carr[0] = new Treadmill(1000);
        carr[1] = new Wall(2);
        

        for (User u : user) {

                for (Course crs : carr){
                    if (u.getStatus() == true) {

                        if (crs.equals(carr[0])) {
                            if (crs.doIt(u.run()))
                                System.out.println(u.getName() + " забег: " + crs.doIt(u.run()));
                            else {

                                u.setStatus(false);
                                System.out.println("Участник " + u.getName() + " не смог пробежать");
                            }

                        } else {
                            if (crs.doIt(u.jump()))
                            System.out.println(u.getName() + " прыжки:" + crs.doIt(u.jump()));
                            else {
                                u.setStatus(false);
                                System.out.println("Участник " + u.getName() + " не смог перепрыгнуть");
                            }
                        }
                    }
                    else System.out.println("Участник " + u.getName() + " не может продолжать участие");
                }

        }

//        System.out.println(t1.doItRun(h1.run()));
//        System.out.println(w1.doItJump(h1.jump()));
    }
}
