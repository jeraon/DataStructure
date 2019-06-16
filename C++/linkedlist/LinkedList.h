//
// Created by jiayongqiang on 19-5-18.
//

#ifndef LINKEDLIST_LINKEDLIST_H
#define LINKEDLIST_LINKEDLIST_H

#include <iostream>
#include <stdexcept>

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
        int i = 0;
        while (node->next != nullptr) {
            temp = node->next;
            delete node;
            node = temp;
            i++;
        }
        delete head;
    }

    bool isEmpty();

    int append(T t); //插到链表后面
    void insert(T t); //插到链头部
    bool update(T t, int index); //修改元素
    bool remove(int index); //删除元素
    void forEach();

    T &get(int index);

    // TODO: 对于复杂类型，比较时，需要重写operator=.
    bool contain(T t);

    void clear();
};

template<class T>
void LinkedList<T>::clear() {
    Node<T> *node = head->next;
    Node<T> *temp = node;
    while (node != nullptr) {
        temp = node;
        node = node->next;
        delete temp;
    }
}

template<class T>
T &LinkedList<T>::get(int index) {
    Node<T> *p = head;
    int i = 0;
    while (p->next != NULL && i < index) {
        i++;
        p = p->next;
    }
    if (i == index) {
        return p->data;
    } else {
        throw std::out_of_range("Out of range.");
    }
}

template<class T>
bool LinkedList<T>::remove(int index) {
    int i = 0;
    Node<T> *node = head->next;
    Node<T> *temp = head->next;
    // 找到index为i-1的节点
    while (node != nullptr && i < index) {
        temp = node;
        node = node->next;
        i++;
    }
    if (index != i) {
        return false;// TODO: throw.
    } else {
        temp->next = node->next;
        if (node != nullptr) delete node;
        return true;
    }
}

template<class T>
bool LinkedList<T>::update(T t, int index) {
    Node<T> *temp = head->next;
    int i = 0;
    while (temp != nullptr && index > i) {
        i++;
        temp = temp->next;
    }
    if (i == index) {
        temp->data = t;
        return true;
    }
    return false;
}

// Only for test.
template<class T>
void LinkedList<T>::forEach() {
    Node<T> *node = head->next;
    while (node != nullptr) {
        std::cout << node->data << ", ";
        node = node->next;
    }
    std::cout << std::endl;
}

template<class T>
void LinkedList<T>::insert(T t) {
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
