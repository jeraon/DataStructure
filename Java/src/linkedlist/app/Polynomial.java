package app;

/**
 * 链表的应用；多项式求和
 * 
 * 1.原理：
 *  多项式的项作为一个节点，每一项中存储系数、指数以及指向下一个项的指针。
 * 2.前提：多项式中的项需求按照指数进行排列；
 * 3.按指数降序插入项到多项式：
 *  1.从多项式头结点开始遍历，如果：
 *      1.插入项指数 > 所在项的后继项指数，则将其插入到所在项的后继位置，原后继项作为插入项的后继;
 *      if (newItem.exp > item.next.exp ) { newItem.next = item.next; item.next = newItem}
 *      2.插入项指数 < 所在项的后继项指数，则所在项继续后移；
 *      if (nextItem.exp < item.next.exp) { item = item.next}
 *      3.插入项指数 = 所在项的后继项指数, 则系数直接相加:
 *      if (nextItem.exp == item.next.exp) { item.next.coeffient += newItem.coeffient }
 *  2.如果整个多项式遍历完成，且插入项的后继还是为空，那么说明没有对新项进行插入，此时直接追加到末尾即可；
 *      if (item.next == null && newItem.next == null) { item.next = newItem }
 * 这里一直使用的是item.next形式，主要是需要找到一个前驱节点。
 * 4.两个多项式相加：
 *  1.从两个多项式P1、P2的头结点的后继开始遍历项数，如果：
 *      1.p1的项的指数 > p2 的项的指数，则将p1的该项添加到新的多项式中，p1向后移动；
 *      if (n1.exp > n2.exp) { n3.next = copy(n1); n1 = n1.next; n3 = n3.next }
 *      2.p1的项的指数 < p2 的项的指数，则将p2的该项添加到新的多项式中，p2向后移动；
 *      if (n1.exp < n2.exp) { n3.next = copy(n2); n2 = n2.next; n3 = n3.next }
 *      3.p1的项的指数 = p2 的项的指数，则将p1、p2的该项系数求和，并添加到新的多项式中，并均向后移动；
 *      if (n1.exp== n2.exp) { n3.next = copy(n1); n3.coeff += n2.coef; n1 = n1.next; n2 = n2.next; n3 = n3.next }
 *  2.遍历完成后，如果存在多项式还有剩余，则追加到新的多项式；
 *  while (n1 != null || n2 != null) { n3.next = copy(n1); n1 = n1.next; n3 = n3.next }
 * 
 */
public class Polynomial {

    public final Item HEADER = new Item();
    public Polynomial() {
    }

    public Item findCorrectItem(Item it) {
        Item item = HEADER;
        while(item.next != null) {
            if (item.next.exponentiation == it.exponentiation) {

            }
            if (item.next.exponentiation < it.exponentiation) {
                break;
            } else if(item.next.exponentiation > it.exponentiation) {
                item = item.next;
            } else {

            }
        }
        return item;
    }
    // 多项式中插入一个项，传入系数和指数
    public void insertItem(int coeff, int exp) {
        if (coeff == 0)
            return;
        // 创建一个项
        Item newItem = new Item(coeff, exp);
        // 从头节点开始遍历
        Item item = HEADER;
        while (item.next != null) {
            // 如果遍历所在节点的后继节点指数大于当前节点，继续向后移动
            if (item.next.exponentiation > exp) {
                item = item.next;
                // 如果遍历所在节点的后继节点指数小于当前节点，则插入到遍历所在节点的后继位置上
            } else if (item.next.exponentiation < exp) {
                newItem.next = item.next;
                item.next = newItem;
                break;
                // 说明指数相同，直接系数相加即可
            } else {
                item.next.coefficient += coeff;
                break;
            }
        }
        
        // 这种说明newItem没有插入到多项式中，直接追加到多项式结尾即可
        if (item.next == null && newItem.next == null) {
            item.next = newItem;
        }
    }

    // 多项式加法
    public static Polynomial addPolynomials(Polynomial p1, Polynomial p2) {
        // 创建一个新的多项式
        Polynomial sumPolynomial = new Polynomial();

        // 从原始多项式的头结点开始遍历
        Item n1 = p1.HEADER.next;
        Item n2 = p2.HEADER.next;
        // 获取新建多项式的头结点
        Item n3 = sumPolynomial.HEADER;

        // 开始遍历p1和p2
        while (n1 != null && n2 != null) {
            // 如果n1的指数大于n2,直接将n1的添加并向后移动n1
            if(n1.exponentiation > n2.exponentiation) {
                // 创建一个节点(不要直接引用n1,避免多项式p1发生变化)
                Item temp = new Item(n1);
                n3.next = temp; // 将新建节点作为当前节点的后继节点
                n3 = n3.next;
                n1 = n1.next;
            } else if (n1.exponentiation < n2.exponentiation) {
                // 创建一个节点(不要直接引用n2,避免多项式p2发生变化)
                Item temp = new Item(n2);
                n3.next = temp;
                n3 = n3.next;
                n2 = n2.next;
            } else {
                Item temp = new Item(n1.coefficient + n2.coefficient, n1.exponentiation);
                n3.next = temp; 
                // 都向后移动一个节点
                n3 = n3.next;
                n1 = n1.next;
                n2 = n2.next;
            }
        }
        // 如果存在没有移动完成的节点，直接追加到后边
        while(n1 != null || n2 != null) {
            if (n1 != null) {  
                Item temp = new Item(n1);
                n3.next = temp;
                n1 = n1.next;
                n3 = n3.next;
            }
            if (n2 != null) {
                Item temp = new Item(n2);
                n3.next = temp;
                n2 = n2.next;
                n3 = n3.next;
            }
        }
        return sumPolynomial;
    }

    @Override
    public String toString() {
        Item item = HEADER.next;
        StringBuilder builder = new StringBuilder("p = ");
        while(item != null) {
            builder.append(item.coefficient +"x^" +item.exponentiation);
            builder.append(" + ");
            item = item.next;
        }
        builder.delete(builder.length()-3, builder.length()-1);
        return builder.toString();
    }

    private static class Item {
        int coefficient;
        int exponentiation;
        Item next;
        public Item() {
            this.next = null;
        }

        public Item(int coeff, int exp) {
            this.coefficient = coeff;
            this.exponentiation = exp;
            this.next = null;
        }

        public Item(Item item) {
            copyFrom(item);
        }

        private void copyFrom(Item item) {
            this.coefficient = item.coefficient;
            this.exponentiation = item.exponentiation;
            this.next = null;
        }
    }
}
