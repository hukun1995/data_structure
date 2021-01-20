package data_structure;

import java.util.HashMap;
import java.util.Map;

public class tmp {
    private static int levelId;

    public static void init(int v){
        levelId = v;
    }

    public static int createLevelId(){
        return ++levelId;
    }

    public static int getLevelId(){
        return levelId;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>();
        m.get(1);
        System.out.println(tmp.getLevelId());
        tmp.init(5);
        System.out.println(tmp.getLevelId());
        System.out.println(tmp.createLevelId());

    }
}
