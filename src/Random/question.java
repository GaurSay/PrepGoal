package Random;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class question {
    public static void main(String[] args) {
//        System.out.println("hello");

//        10 -> 1
//        10->2
//
//        fetch(10) = 1
//
//        20 ->1
//        fetch(10) = 2
        //inserting - value, index
        //fetching - value

//        map<value,treeSET>
//
//                10 [1,2]
//                20 [1]
//
//        1, 10

        Map<Integer, TreeSet<Integer>> valueVsIndexMap = new LinkedHashMap<>();
        Map<Integer,Integer> indexVsValue = new LinkedHashMap<>();
        insertion(10,1,valueVsIndexMap,indexVsValue);
        insertion(10,2,valueVsIndexMap,indexVsValue);
        System.out.println(fetch(10,valueVsIndexMap));
        insertion(20,1,valueVsIndexMap,indexVsValue);
        System.out.println(fetch(10,valueVsIndexMap));
    }

    private static void insertion(int value,int index, Map<Integer, TreeSet<Integer>> valueVsIndexMap, Map<Integer,Integer> indexVsValue){
        if(indexVsValue.containsKey(index)){
            int prevValue = indexVsValue.get(index);
            indexVsValue.put(index,value);

            TreeSet<Integer> ts = valueVsIndexMap.get(prevValue);
            ts.remove(index);
            valueVsIndexMap.put(prevValue,ts);
            if(valueVsIndexMap.containsKey(value)){
                TreeSet<Integer> ts1 = valueVsIndexMap.get(value);
                ts1.add(index);
                valueVsIndexMap.put(value,ts1);
            } else{
                TreeSet<Integer> tsne = new TreeSet<>();
                tsne.add(index);
                valueVsIndexMap.put(value,tsne);
            }

        } else{
            indexVsValue.put(index,value);
            if(valueVsIndexMap.containsKey(value)){
                TreeSet<Integer> ts = valueVsIndexMap.get(value);
                ts.add(index);
                valueVsIndexMap.put(value,ts);
            }else{
                TreeSet<Integer> tsnew = new TreeSet<>();
                tsnew.add(index);
                valueVsIndexMap.put(value,tsnew);
            }

        }
    }

    private static int fetch(int value, Map<Integer, TreeSet<Integer>> valueVsIndexMap){
        return valueVsIndexMap.get(value).first();
    }
}
