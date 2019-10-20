#include <iostream>
#include "linkedlist/LinkedList.h"

using namespace std;
int main() {

    cout << "===test LinkedList()====" << endl;
    LinkedList<int>* list = new LinkedList<int>;

    cout << "===test addIntoHead()====" << endl;
    list->addIntoHead(9);
    list->addIntoHead(10);
    list->forEach();

    cout << "===test append()====" << endl;
    list->append(190);
    list->append(200);
    list->forEach();

    cout << "===test deleteNode()====" << endl;

    list->deleteNode(9);
    list->deleteNode(1280);
    list->forEach();

    cout << "===test ~LinkedList()====" << endl;
    delete list;

    return 0;
}