package 程序员代码面试指南.problem09_other;

import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @program: AlgorithmCoding
 * @description:
 * @author: nixuan
 * @create: 2019-05-14 10:33
 **/
public class Code01_并查集的实现 {

    public static class UnionFindSet<V>{
        public HashMap<V,V> fatherMap;
        public HashMap<V,Integer> rankMap;

        public UnionFindSet(List<V> list){

            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V element :list) {
                fatherMap.put(element,element);
                rankMap.put(element,1);
            }
        }

        private V findHead(V element){
            Stack<V> path = new Stack<>();
            while (fatherMap.get(element) != element){
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()){
                fatherMap.put(path.pop(),element);
            }
            return element;
        }

        public boolean isSameSet(V a,V b){
            V aHead = findHead(a);
            V bHead = findHead(b);
            return aHead == bHead;
        }

        public void union(V a,V b){
            V aHead = findHead(a);
            V bHead = findHead(b);
            if (aHead == bHead){
                return;
            }
            if (rankMap.get(aHead) >= rankMap.get(bHead)){
                fatherMap.put(bHead,aHead);
                rankMap.put(aHead,rankMap.get(aHead) + rankMap.get(bHead));
            }else{
                fatherMap.put(aHead,bHead);
                rankMap.put(bHead,rankMap.get(aHead) + rankMap.get(bHead));
            }
        }
    }
}
