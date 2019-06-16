#include <iostream>
#include "linkedlist/LinkedList.h"
#include <string>
#include <stdexcept>

using namespace std;

int main() {
    int index = 0;
    LinkedList<int> listInt;
    LinkedList<string> listStr;
    listInt.append(1);
    listInt.append(2);
    listStr.append("xiaowang");
    listStr.append("zhangsan");
    listStr.append("xiaowang");
    index = listStr.append("zhangsan");
    listInt.insert(0);
    cout << "index: " << index << endl;
    cout << "is empty? " << boolalpha << listInt.isEmpty() << endl;
    cout << "is empty? " << boolalpha << listStr.isEmpty() << endl;
    listInt.update(10,5);
    listInt.forEach();
    listStr.forEach();
    listStr.remove(2);
    listStr.forEach();
    int i;
    try {
        i = listInt.get(20);
    } catch (logic_error & e) {
        cout << e.what() << endl;
    }

    listStr.clear();
    listStr.forEach();
    return 0;
}