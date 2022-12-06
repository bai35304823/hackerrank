package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nums = {2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
//        //结果集合
//        List<List<Integer>> list = new ArrayList();
//        //回溯方法
//        backtrack(list,new ArrayList<>(),nums);
//        return list;
        //一个全局变量，用于保存所有集合
        List<List<Integer>> list = new ArrayList<>();
        //传入三个参数，没有附加参数
        backtrack(list, new ArrayList<>(), nums);
        return list;

    }

    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        //终结条件
        if (tempList.size() == nums.length) {
            //全局变量添加一个满足条件的集合
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                //如果tempList没有包含nums[i]才添加
                tempList.add(nums[i]);
                //递归调用，此时的tempList一直在变化，直到终结条件才结束
                System.out.println("start call backtrack()..");
                backtrack(list,tempList, nums);
                System.out.println("tempList的内容:"+tempList+"-------"+"i的值:"+i);
                //移除掉最后一个元素的作用就是返回到上一次调用时的数据，也就是希望返回之前的节点再去重新搜索满足条件，这样才能实现回溯
                tempList.remove(tempList.size()-1);
            }
        }
    }



}
