#include <stdio.h>
#include "linkedlist/linkedlist.h"


/*
 * 关键点： 声明一个头节点，并注意头节点参与运算时的逻辑。
 */
int main() {
    printf("===test create_head()===\n");
    // 创建一个链表(即得到一个头节点)
    List list = create_head();

    printf("===test insert(int data, list)===\n");
    insert(1,list);
    insert(2,list);
    for_each(list);
    insert(10,list);

    printf("===test append(int data, list)===\n");
    append(3,list);
    append(9,list);
    for_each(list);

    printf("===test find(int data, List list)===\n");
    Node node = find(9,list);
    if (node != NULL)
        node->data = 9*9;
    else
        printf("Not found.\n");
    for_each(list);

    printf("===test delete(int data, List list)===\n");
    delete(10,list);
    delete(15,list);
    delete(3,list);
    for_each(list);

    printf("===test delete_list(List list)===\n");
    delete_list(list);
    return 0;
}