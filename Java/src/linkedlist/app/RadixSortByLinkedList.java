package app;

/**
 * 链表实现的基数排序 
 *  
 * 1.创建10个链表作为基数桶；
 * 2.创建一个初始链表读入原始数据，作为遍历对象；
 * 3.创建一个临时链表，在每次外循环结束后整合桶内数据的容器；
 * 4.每次外循环后，将临时链表赋值给初始链表；并置空临时链表；
 * 5.每次大循环基数*10来依次从次位获取数，如1、10、100...
 */
public class RadixSortByLinkedList {
    
    
    /**
     * 基于链表实现基数排序
     * @param arr   原始数组
     * @param maxIndex  原始数组内最大数的位数，作为外循环的控制条件
     * @param r     基数，一般为10
     */
    public void radixSortByLinkedList(int[] arr, int maxIndex, int r) {

        // 控制外循环次数
        int radix = 1;
        // 创建10个链表作为桶，并将它们放置到数组中
        LinkedList<Integer>[] lists = new LinkedList[r];
        for (int a = 0; a < r; a++) {
            LinkedList<Integer> list = new LinkedList<>();
            lists[a] = list;
        }
        // 创建一个初始链表，并将数组中的数读入链表
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.append(arr[i]);
        }

        // 开始遍历
        for (int j = 0; j < maxIndex; j++) {
            // 每趟遍历，创建临时链表存放
            LinkedList<Integer> tempList = new LinkedList<>();
            // 开始遍历初始链表，并根据次位数放置到对应的桶中

            // TODO: 可以进一步封装，不暴露Node
            LinkedList.Node<Integer> node = list.HEAD;
            while (node.next != null) {
                node = node.next;
                int index = (node.data / radix) % 10;
                lists[index].append(node.data);
            }

            // 将桶链表合并到tempList上
            for(int k = 0; k < lists.length; k++) {
                LinkedList<Integer> linkedList = lists[k];
                LinkedList.Node<Integer> p = linkedList.HEAD;
                while(p.next != null) {
                    p = p.next;
                    tempList.append(p.data);
                }
            }

            // 将tempList交换给初始链表, 并清空tempList
            list.clear();
            list.copyOf(tempList);
            // LinkedList.Node<Integer> tNode = tempList.HEAD;
            // LinkedList.Node<Integer> lNode = list.HEAD;
            // while(tNode.next != null) {
            //     lNode.next = tNode.next;
            //     tNode = tNode.next;
            //     lNode = lNode.next;
            // } 
            tempList.clear();

            // 清空桶链表中的数据，下次重新填充
            for (int n = 0; n < lists.length; n++) {
                lists[n].clear();
            }
            // 每次循环乘以基数
            radix *= r;
            System.out.println("第" + (j+1) + "次排序：");
            printList(list);
        }
    }

    /**
     * 打印输出链表
     * @param list
     */
    private void printList(LinkedList<Integer> list) {

        LinkedList.Node<Integer> node = list.HEAD.next;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    
    /**
     * 单链表
     */
    static class LinkedList<T> {
        private Node<T> HEAD;
        private int size;

        LinkedList() {
            HEAD = new Node<T>();
            size = 0;
        }

        /**
         * 追加节点
         * @param t
         */
        public void append(T t) {
            Node<T> node = new Node<T>();
            node.data = t;
            Node<T> tailNode = findLastNode();
            tailNode.next = node;
            size++;
        }

        /**
         *  追加节点
         */
        public void append(Node<T> node) {
            Node<T> tailNode = findLastNode();
            tailNode.next = node;
            size++;
        }

        /**
         * 插入到给定位置
         * @param t
         * @param position
         * @return
         */
        public boolean insert(T t, int position) {
            Node<T> node = findPreviousNode(position);
            if (node != null) {
                Node<T> newNode = new Node<>();
                newNode.data = t;
                newNode.next = node.next;
                node.next = newNode;
                size++;
                return true;
            }
            return false;
        }

        /**
         * 拷贝链表
         */
        public void copyOf(LinkedList<T> origin) {
            clear();
            Node<T> node = origin.HEAD.next;
            while (node != null) {
                append(node.data);
                node = node.next;
            }
        }

        /**
         * 寻找给定索引的上一个节点
         * @param position
         * @return
         */
        public Node<T> findPreviousNode(int position) {

            Node<T> node = HEAD;
            if (position >= size) {
                return null;
            }
            int i = 0;
            while (node.next != null && i++ != position) {
                node = node.next;
            }
            return node;
        }

        /**
         * 寻找最后一个节点
         * @return
         */
        public Node<T> findLastNode() {
            Node<T> p = HEAD;
            while (p.next != null) {
                p = p.next;
            }
            return p;
        }

        /**
         * 清空链表
         */
        public void clear() {
            Node<T> node = HEAD.next;
            while(node != null && node.next != null) {
                Node<T> temp = node;
                HEAD.next = node.next;
                node = node.next;
                temp = null;
            }
            HEAD.next = null;
            size = 0;
        }

        // 节点
        static class Node<T> {
            public Node() {
                next = null;
            }

            Node<T> next;
            T data;
        }
    }
}
