package lesson3;

import java.util.*;

public class TestCol {


    public static void main(String[] args) {
//        System.out.println("Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).");
//        List<String> arrList = new ArrayList<String>();
//        arrList.add("Word01");
//        arrList.add("Word02");
//        arrList.add("Word03");
//        arrList.add("Word04");
//        arrList.add("Word05");
//        arrList.add("Word06");
//        arrList.add("Word07");
//        arrList.add("Word08");
//        arrList.add("Word09");
//        arrList.add("Word10");
//        arrList.add("Word11");
//        arrList.add("Word11");
//        arrList.add("Word12");
//        arrList.add("Word12");
//        arrList.add("Word12");
//        arrList.add("Word12");
//        arrList.add("Word13");
//        arrList.add("Word14");
//        arrList.add("Word15");
//        arrList.add("Word16");
//        System.out.println(arrList);
//        System.out.println("\n\n Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).");
//
//        Set<String> setList = new TreeSet<String>();
//        for (String s: arrList
//             ) {
//            setList.add(s);
//        }
//        System.out.println(setList);


//        System.out.println("\n\n Посчитать, сколько раз встречается каждое слово.");
//        Map <String, Integer> hashMap = new HashMap<String, Integer>();
////        int col = 0;
//        for (String s: arrList
//             ) {
//            if (hashMap.containsKey(s)){
//                int col = 0;
//                col = hashMap.get(s);
//                hashMap.put(s, col+1);
//            }
//            else hashMap.put(s, 1);
//        }
//        for (Map.Entry<String, Integer> o : hashMap.entrySet()) {
//            System.out.println(o.getKey() + ": " + o.getValue());
//        }

        PhoneBook pb1 = new PhoneBook();
        pb1.addPb("Name0", "89030000001");
        pb1.addPb("Name0", "89030000011");
        pb1.addPb("Name1", "89030000002");
        pb1.addPb("Name2", "89030000003");


        for (Integer i = 0; i < pb1.getSize(); i++) {

            String searchName = "Name"+ i.toString();
            System.out.println(searchName + ": "+ pb1.getPb(searchName));
        }
    }
}
