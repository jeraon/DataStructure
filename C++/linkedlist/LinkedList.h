//
// Created by jiayongqiang on 19-5-18.
//

#ifndef LINKEDLIST_LINKEDLIST_H
#define LINKEDLIST_LINKEDLIST_H

#include <iostream>

template<class T>
class Node {
public:
    T data;
    Node *next;
};

template<class T>
class LinkedList {
private:
    Node<T> *head;
public:
    inline LinkedList() {
        head = new Node<T>;
        //head-data??
        head->next = nullptr;
    }

    inline ~LinkedList() {
        Node<T> *node = head;
        Node<T> *temp;
        while (node->next != nullptr){
            temp = node->next;
            delete node;
            node = temp;
        }
        delete head;
    }

    bool isEmpty();

    int append(T t); //插到链表后面
    void insert(T t); //插到链头部
    bool update(T t, int index); //修改元素
    bool remove(T t);

    bool get(int index);

    bool contain(T t);

    void forEach();

    void clear();
};

template <class T>
bool LinkedList<T>::update(T t, int index) {
    Node<T> *temp = head->next;
    int i = 0;
    while(temp != nullptr && index > i) {
        i++;
        temp = temp->next;
    }
    if (i == index){
        temp->data = t;
        return true;
    }
    return false;
}
// Only for test.
template <class T>
void LinkedList<T>::forEach() {
    Node<T> *node = head->next;
    while(node != nullptr){
        std::cout << node->data << ", ";
        node = node->next;
    }
    std::cout << std::endl;
}

template <class T>
void LinkedList<T>::insert(T t){
    Node<T> *node = new Node<T>;
    node->data = t;
    node->next = head->next;
    head->next = node;
}

template<class T>
bool LinkedList<T>::isEmpty() {
    return head->next == nullptr;
}

template<class T>
int LinkedList<T>::append(T t) {
    Node<T> *node = new Node<T>;
    node->data = t;
    node->next = nullptr;
    Node<T> *p = head;
    int index = 0;
    while (p->next != nullptr) {
        p = p->next;
        index++;
    }
    p->next = node;
    return index;
}

#endif LINKEDLIST_LINKEDLIST_H
