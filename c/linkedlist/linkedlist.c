//
// Created by jiayongqiang on 19-8-26.
//
#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"

// 创建头节点
List create_head()
{
    List list = (List) malloc(sizeof(List));
    if (list == NULL)
        exit(0);
    list->next = NULL;
    return list;
}

// 创建普通节点
Node create_node()
{
    Node node = (Node) malloc(sizeof(Node));
    if (node == NULL)
        exit(0);
    return node;
}

// 查找元素对应的节点
Position find(int data, List list)
{
    Node node = list->next;
    while (node != NULL && node->data != data) {
        node = node->next;
    }
    return node;
}

// 查找元素的前驱节点
Position find_previous(int data, List list)
{
    Node node = list;
    while (node->next != NULL && node->next->data != data) {
        node = node->next;
    }
    // 用来规避data不存在的情况
    if (is_last(node)) {
        node = NULL;
    }
    return node;
}
// 追加元素
void append(int data, List list)
{
    // 1.创建节点，存放数据
    Node node = create_node();
    node->data = data;
    node->next = NULL;
    // 2.寻找尾节点
    Node list_tail = last_node(list);
    list_tail->next = node;
}

// 插入为第一个元素
void insert(int data, List list)
{
    // 1.创建一个节点
    Node node = create_node();
    // 2.保存数据
    node->data = data;
    // 3.将新节点直接插入到head指针后面
    node->next = list->next;
    list->next = node;
}

Position delete(int data, List list)
{
    Position previous_node = find_previous(data,list);
    if (previous_node != NULL)
    {
        Node current_node = previous_node->next;
        previous_node->next = current_node->next;
        free(current_node);
    }
    return previous_node;
}

// 查找最后一个节点
Node last_node(List list)
{
    // node = list->next无法处理空链表时的情况，node = list,则会在空链表时返回头节点list
    Node node = list;
    while(node->next != NULL)
    {
        node = node->next;
    }
    return node;
}

int is_empty(List list)
{
    Node node = list;
    return node->next == NULL;
}

int is_last(Node node)
{
    return node->next == NULL;
}

void delete_list(List list)
{
    Node node,temp;
    node = list;
    while (node != NULL){
        temp = node->next;
        free(node);
        node = temp;
    }
}
// 遍历链表
void for_each(List list)
{
    Node node = list->next;
    printf("[");
    while (node != NULL){
        printf("%d,",node->data);
        node = node->next;
    }
    printf("]\n");
}


