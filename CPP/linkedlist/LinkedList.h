//
// Created by jiayongqiang on 19-8-10.
//

#ifndef CPP_LINKEDLIST_H
#define CPP_LINKEDLIST_H

#include <iostream>

// 节点
template <class T>
struct Node{
    T data;
    Node* next;
};

template <class T>
class LinkedList{
private:
    Node<T> * head;
    // 创建节点元素
    inline Node<T> * createNode() {
        Node<T> * node = new Node<T>;
        return node;
    }
    void deleteList();
    Node<T> lastNode();
public:
    // 在获取LiankedList的时候，就可以获取一个头指针
    inline LinkedList<T>() { head = new Node<T>; }
    ~LinkedList();
    // 寻找Node节点
    Node<T> * find(T t);
    // 寻找对应节点的前驱节点
    Node<T> * findPrevious(T t);
    // 判断是否是最后一个元素
    bool isLast(Node<T>* node);
    // 追加到链表尾部
    bool append(T t);
    // 根据索引返回指定位置Node
    Node<T> * getNodeByIndex(int index);
    // 插入到链表头部
    void addIntoHead(T t);
    // 插入到指定位置,这个方法暂不实现了
    // bool insertNode(T t, int index);
    // 删除元素，删除算法一般要求返回删除元素前驱节点的位置
    Node<T>* deleteNode(T t);
    // 遍历链表
    void forEach();
};

// 析勾函数则用来释放整个表中节点的空间
template <class T>
LinkedList<T>::~LinkedList() {
    std::cout << "~LinkedList()"<< std::endl;
    deleteList();// 该函数private访问权限，外部无法使用
}

template<class T>
void LinkedList<T>::deleteList() {
    Node<T> *position, *temp;
    position = head;
    while (position != NULL) {
        temp = position->next;
        delete position;
        position = temp;
    }
}
// 返回nullptr或者该数对应的节点
template <class T>
Node<T> * LinkedList<T>::find(T t) {
    // 因为涉及到node->data操作，为了避免head指针也进行这个操作，这里从第一个节点开始遍历
    Node<T> * node = head->next;
    while(node != nullptr && node->data != t) {
        node = node->next;
    }
    return node;
}

// 相比find，该方法需要返回数对应节点的前驱节点，没有则nullptr，第一个元素则返回head
// 这个方法主要是用来对delete方法进行辅助
template <class T>
Node<T> * LinkedList<T>::findPrevious(T t) {
    Node<T> * node = head;
    while(node->next != nullptr && node->next->data != t) {
        node = node->next;
    }
    return node;
}

// 判断是否是最后一个元素，最后一个肯定是nullptr.
template <class T>
bool LinkedList<T>::isLast(Node<T> *node) {
    return node -> next == nullptr;
}
// 新元素追加到链表尾部
template <class T>
bool LinkedList<T>::append(T t) {

    // 1.创建一个节点
    Node<T> *node = createNode();
    node->data = t;
    node->next = nullptr;
    // 2.获取尾节点
    Node<T> *last = lastNode();
    last->next = node;
    return true;
}

// 获取尾节点
template <class T>
Node<T> LinkedList<T>::lastNode() {
    Node<T>* p = head;
    // 得到最后一个节点
    while(p->next != nullptr) {
        p = p->next;
    }
    return p;
}

template <class T>
Node<T> * LinkedList<T>::getNodeByIndex(int index) {
    Node<T> * node = head->next;
    int i = 0;
    while(node != nullptr && i < index) {
        node = node->next;
        i++;
    }
    return node;
}

// 插入到链表头部
template <class T>
void LinkedList<T>::addIntoHead(T t) {
    // 创建一个节点
    Node<T>* node = createNode();
    node->data = t;
    // 将新节点放在head指针后
    node->next = head->next;
    head->next = node;
}

// 先找到前驱节点，然后用前驱节点操作就OK，删除时需要注意是否该元素是最后一个元素，如果是，需要进行判断
template <class T>
Node<T>* LinkedList<T>::deleteNode(T t) {
    // 1.寻找t的前驱节点
    Node<T> * currentNode;
    Node<T> * previousNode = findPrevious(t);
    // 2.需要判断是否可以找到，相当于if(previousNode-> != nullptr);
    if (!isLast(previousNode)) {
        // 3.当前元素的节点
        currentNode = previousNode->next;
        previousNode->next = currentNode->next;
        delete currentNode;
    }
    return previousNode;
}

template<class T>
void LinkedList<T>::forEach() {
    Node<T> * position = head->next;
    std::cout << "[";
    while (position != nullptr) {
        std::cout << position->data << ", ";
        position = position->next;
    }
    std::cout << "]" << std::endl;
}
#endif CPP_LINKEDLIST_H