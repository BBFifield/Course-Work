/**
 * By Brandon Fifield: March 27th, 2017  Student I.D.:201238730
 * A C++ program that is constucts linked lists and does various operations on it.
 */

#include "../std_lib_facilities.h"

//Question 2: (1)
//Node struct
struct Node {
	string element;
	Node *next;
	Node(const string& e, Node *n=nullptr) : element{e},next{n} {};
};

//Question 2: (2)
class SL_list {
	private:
		int size;
		Node *listFirst;  //linkFirst

	public:
		//Question 2: (3 a)
		//Default constructor
		SL_list() : size{0},listFirst{nullptr} {};
		//Question 2: (3 b)
		//Initialization constructor
		SL_list(int s, Node *p) : size{s}, listFirst{p} {};

		void print_all();
		int getSize() { return size; }

		//Question 2: (3 c)
		Node* add(Node *position, Node *newNode);
		Node* find(Node *position, const string& s);
		Node* erase(Node *position);
		Node* advance(Node *position, int n);
};

//The add function to be used on a linked list where postion is the position the node is to be added after.
Node* SL_list::add(Node *position, Node *newNode) {
	if(newNode==nullptr) return position;
	if(position==nullptr) return newNode;
	newNode->next = position->next;
	position->next = newNode;
	size++;
	return newNode;
}

//Finds the node witht the specificed element and returns it
Node* SL_list::find(Node *position, const string& s) {
	while(position) {
		if(position->element == s) return position;
		position = position->next;
	}
	return nullptr;
}

//Erases a node from the list and then returns the node after the one erased.
Node* SL_list::erase(Node *position) {
	if(position==nullptr) return nullptr;
	Node *current = listFirst;	//Create a new pointer so that listFirst does not get overwritten during the erase procedure.
	while(current->next) {
		if(current == position) {
			listFirst = listFirst->next;
		}
		else if(current->next == position) {
			current->next = position->next;
		}
		current = current->next;
	}
	size--;
	return position->next;
}

//Increments or decrements the position in the list by a specficied amount.
Node* SL_list::advance(Node *position, int n) {
	if(position==nullptr) return nullptr;
	if(n > 0) {
		while(n--) {
			if(position->next==nullptr) return nullptr;
			position = position->next;
		}
	}
	else if(n < 0) {
		Node *previous = listFirst;  //ATTENTION
		while(n++) {
			while(previous->next) {
				if(listFirst == position) {
					return nullptr;
				}
				if(previous->next == position) break;
				previous = previous->next;
			}
			position = previous;
			previous = listFirst; //ATTENTION
		}
	}
	return position;
}

//Prints all the elements in the list.
void SL_list::print_all() {
	Node *current = listFirst; 
	while(current) {
		cout << current->element << " ";
		current = current->next;
	}
	cout << "\n\n";
}

int main() {
	Node *listFirst = new Node{"Arachinids"};
	SL_list invertebrates{1,listFirst};
	invertebrates.add(listFirst, new Node{"Insects"});
	invertebrates.add(listFirst, new Node{"Crustaceans"});
	invertebrates.add(listFirst, new Node{"Fish"});
	
	Node *listFirstTwo = new Node{"Mammels"};
	SL_list vertebrates{1,listFirstTwo};
	vertebrates.add(listFirstTwo,new Node{"Bird"});
	vertebrates.add(listFirstTwo,new Node{"Reptiles"});

	cout << "Contents of invertebrates linked list is: " << endl;
	invertebrates.print_all();
	cout << "Contents of vertebrates linked list is: " << endl;
	vertebrates.print_all();

	Node *p = invertebrates.find(listFirst,"Fish");
	if(p) {
		if(p == listFirst) listFirst = p->next;
		invertebrates.erase(p);
		vertebrates.add(listFirstTwo,p);
	}

	cout << "Contents of invertebrates linked list after erasing \"fish\" is: " << endl;
	invertebrates.print_all();
	cout << "Contents of vertebrates linked list after taking \"fish\" from invertebrates and adding it to this list is: " << endl;
	vertebrates.print_all();
	return 0;
}









