package personal.walker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static void printListNode(ListNode node){
        while (true){
            System.out.print(node.val +  ",");
            node = node.next;
            if (node == null){
                break;
            }
        }
        System.out.println();
    }

    public static  int[][] convertTwoDimensionToIntegerArray(String data){
        //[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]


        return new Gson().fromJson(data,int[][].class );
    }

    public static   List<List<Integer>> convertTwoDimensionToIntegerList(String data){
        //[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]
        Type listType = new TypeToken<ArrayList<ArrayList<Integer>>>(){}.getType();
        List<List<Integer>> yourClassList = new Gson().fromJson(data, listType);
        return yourClassList;
    }
    public static   List<List<String>> convertTwoDimensionToStringList(String data){
        //[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]
        Type listType = new TypeToken<ArrayList<ArrayList<String>>>(){}.getType();
        List<List<String>> yourClassList = new Gson().fromJson(data, listType);
        return yourClassList;
    }
    public static   List<String> convertStringList(String data){
        //[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]
        Type listType = new TypeToken<ArrayList<ArrayList<String>>>(){}.getType();
        List<String> yourClassList = new Gson().fromJson(data, listType);
        return yourClassList;
    }
    public static   List<Integer> convertIntegerList(String data){
        //[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]
        Type listType = new TypeToken<ArrayList<ArrayList<Integer>>>(){}.getType();
        List<Integer> yourClassList = new Gson().fromJson(data, listType);
        return yourClassList;
    }

    public static void printResult(Object object){
        Gson gson = new Gson();
        System.out.println(gson.toJson(object));;
    }
}
