package lesson3;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    public HashMap <String, HashSet<String>> pb = new HashMap<String, HashSet<String>>();


    public HashSet<String> getPb(String name) {
        return pb.get(name);
    }

    public void addPb(String name, String pNumber) {
        HashSet <String> pN = new HashSet<String>();
        pN.add(pNumber);
        if(!this.pb.containsKey(name)){
            this.pb.put(name, pN );
        }
        else {
            this.pb.get(name).add(pNumber);
        }
    }

    public int getSize (){
        return this.pb.size();
    }


}
