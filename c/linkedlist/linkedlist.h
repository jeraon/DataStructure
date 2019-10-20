//
// Created by jiayongqiang on 19-8-26.
//

#ifndef C_LINKEDLIST_H
#define C_LINKEDLIST_H

#include <stdio.h>

typedef struct linkedlist* Position;
typedef struct linkedlist* Node;
// 表示头节点
typedef struct linkedlist* List;

struct linkedlist {
    struct linkedlist* next;
    int data;
};


// 创建头节点
List create_head();
// 创建节点
Node create_node();
// 查找元素对应的节点
Position find(int data, List list);
// 查找元素的前驱节点
Position find_previous(int data, List list);
// 追加元素
void append(int data, List list);
// 插入为第一个元素
void insert(int data, List list);
// 删除元素
Position delete(int data, List list);
// 遍历元素
void for_each(List list);
// 查找最后一个节点
Node last_node(List list);
// 判断表是否为空
int is_empty(List list);
// 判断是否是最后一个节点
int is_last(Node node);
// 删除链表上的所有节点
void delete_list(List list);

#endif //C_LINKEDLIST_H
