#include <iostream>
#include "linkedlist/LinkedList.h"
#include <string>

using namespace std;

int main() {
    std::cout << "Hello, World!" << std::endl;

    int index;
    LinkedList<int> listInt;
    LinkedList<string> listStr;
    index = listInt.append(1);
    index = listInt.append(2);
    index = listStr.append("xiaowang");
    index = listStr.append("zhangsan");
    index = listStr.append("xiaowang");
    index = listStr.append("zhangsan");
    listInt.insert(0);
    cout << "index: " << index << endl;
    cout << "is empty? " << boolalpha << listInt.isEmpty() << endl;
    cout << "is empty? " << boolalpha << listStr.isEmpty() << endl;
    bool isOK = listInt.update(10,5);
    listInt.forEach();
    listStr.forEach();
    return 0;
}