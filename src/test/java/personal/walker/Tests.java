package personal.walker;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Tests {
    @Test
    public void testConvertArrayToListNode(){
        ListNode result = ListNode.convertArrayToListNode(new int[]{12,31,4,145,1,51,321});
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    @Test
    public void testConvertArrayToTreeNode(){
        TreeNode result = TreeNode.convertArrayToListNode(new Integer[]{12,31,null,4,145,1,51,321},0);
        TreeNode.print2D(result);
    }
    @Test
    public void testConvertTwoDimensionToIntegerList(){
        List<List<Integer>> result = new ArrayList<>();
        Gson gson = new Gson();

        Type listType = new TypeToken<ArrayList<ArrayList<Integer>>>(){}.getType();
        List<Integer> yourClassList = new Gson().fromJson("[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]", listType);

        System.out.println(gson.toJson(yourClassList));;
    }
    @Test
    public void testConvertTwoDimensionToIntegerArray(){
        System.out.println(new Gson().toJson(Util.convertTwoDimensionToIntegerArray("[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]")));;
    }
}
