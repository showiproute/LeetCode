import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TimeMap {

    /** Initialize your data structure here. */
    HashMap<String, ArrayList<KVObject>> hashMap;
    ArrayList<KVObject> kvObjects = new ArrayList<>();
    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public static class KVObject {
        String val;
        int timeStamp = 0;
        public KVObject(String val,int timeStamp) {
            this.val = val;
            this.timeStamp = timeStamp;
        }
    }

    public void set(String key, String value, int timestamp) {
        KVObject obj = new KVObject(value, timestamp);
        if(hashMap.containsKey(key)) {
            ArrayList<KVObject> kvObjects = hashMap.get(key);
            kvObjects.add(obj);
        }else{
            ArrayList<KVObject> kvObjects = new ArrayList<>();
            Collections.sort(kvObjects, new Comparator<KVObject>() {
                @Override
                public int compare(KVObject o1, KVObject o2) {
                    return o1.timeStamp - o2.timeStamp;
                }
            });
            kvObjects.add(obj);
            hashMap.put(key,kvObjects);
        }
    }

    public String get(String key, int timestamp) {
        if(!hashMap.containsKey(key)) {
            return "";
        }
        ArrayList<KVObject> kvObjects = hashMap.get(key);
        String rst = "";
        for(int i = kvObjects.size()-1;i>=0;i--){
            if(kvObjects.get(i).timeStamp <= timestamp){
                rst = kvObjects.get(i).val;
                break;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo","bar",1);


    }

}
