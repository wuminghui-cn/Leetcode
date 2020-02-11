package utils;

import java.util.*;

public class _list {

    public static void main(String[] args) {

        List<List<Integer>> c = new ArrayList<>();
        c.add(Arrays.asList(2,1,5));
        c.add(Arrays.asList(1,2,5));
        c.add(Arrays.asList(3,1,-1));
        c.add(Arrays.asList(3,0,2));

        List<List<Integer>> c1 =killDuplicateList(c);

    }

    public static void findExist_NoExist(List<String> _first, List<String> _second)
    {
        Collection exists = new ArrayList<String>(_second);
        Collection notexists = new ArrayList<String>(_second);

        exists.removeAll(_first);
        System.out.println("_second中不存在于_set中的：" + exists);
        notexists.removeAll(exists);
        System.out.println("_second中存在于_set中的：" + notexists);
    }

    public static List<Integer> killDuplicateNumber(List<Integer> list)
    {
        List<Integer> newList = new ArrayList<>();
        newList = new ArrayList<>(new HashSet<>(list));

        return newList;
    }

    public static List<List<Integer>> killDuplicateList(List<List<Integer>> list)
    {
        List<List<Integer>> newlist = new ArrayList<>();

        Iterator<List<Integer>> it = list.iterator();

        while (it.hasNext())
        {
            List<Integer> l1 = it.next();
            Collections.sort(l1);

            if (newlist.size() == 0)
            {
                newlist.add(l1);
            }
            else
            {
                // 判断是否在目标中存在重复
                Iterator<List<Integer>> it1 = newlist.iterator();
                int i = 0;

                while (it1.hasNext())
                {
                    i++;

                    List<Integer> l2 = it1.next();
                    Collections.sort(l2);

                    if (l1.equals(l2))
                    {
                        break;
                    }
                    else if (i == newlist.size())
                    {
                        // 遍历完成未找到
                        newlist.add(l1);
                        break;
                    }
                }

            }
        }

        return newlist;
    }
}
