#include <iostream>
#include <algorithm>

using namespace std;

typedef int KeyType;

struct Node {
	KeyType key;
	//이 노드의 우선순위
	int priority;
	//이 노드를 루트로 하는 서브트리의 크기
	int size;
	//두 자식 노드의 포인터
	Node *left, *right;
	//생성자에서 난수 우선순위를 생성하고 
	//size와 left/right를 초기화한다.
	Node(const KeyType& _key) : key(_key), priority(rand()), size(1), left(NULL), right(NULL) {}
	void setLeft(Node* newLeft) { left = newLeft; calcSize(); }
	void setRight(Node* newRight) { right = newRight; calcSize(); }
	//size멤버 갱신
	void calcSize() {
		size = 1;
		if (left) size += left->size;
		if (right) size += right->size;
	}
};

//root를 루트로하는 트립을 key미만의 값과 이상의 값을 갖는
//두개의 트립으로 분리한다.

typedef pair<Node*, Node*> NodePair;

NodePair split(Node* root, KeyType key) {
	if (root == NULL) return NodePair(NULL, NULL);
	//루트가 key 미만이면 오른쪽 서브트리를 쪼갠다
	if (root->key < key) {
		NodePair rs = split(root->right, key);
		root->setRight(rs.first);
		return NodePair(root, rs.second);
	}
	//루트가 key 이상이면 왼쪽 서브트리를 쪼갠다.
	NodePair ls = split(root->left, key);
	root->setLeft(ls.second);
	return NodePair(ls.first, root);
}

Node* insert(Node* root, Node* node) {
	if (root == NULL) return node;
	//node가 루트를 대체해야 한다. 해당 서브트리를 반으로 잘라 각각 자손으로 한다.
	if (root->priority < node->priority) {
		NodePair splitted = split(root, node->key);
		node->setLeft(splitted.first);
		node->setRight(splitted.second);
		return node;
	}
	else if (node->key < root->key)
		root->setLeft(insert(root->left, node));
	else
		root->setRight(insert(root->right, node));
	return root;
}

//a
Node* merge(Node* a, Node* b) {
	if (a == NULL) return b;
	if (b == NULL) return a;
	if (a->priority < b->priority) {
		b->setLeft(merge(a, b->left));
		return b;
	}
	a->setRight(merge(a->right, b));
	return a;
}

Node* erase(Node* root, KeyType key) {
	if (root == NULL) return root;
	//root를 지우고 양 서브트리를 합친 뒤 반환.
	if (root->key == key) {
		Node* ret = merge(root->left, root->right);
		delete root;
		return ret;
	}
	if (key < root->key)
		root->setLeft(erase(root->left, key));
	else
		root->setRight(erase(root->right, key));
	return root;
}

//들어오는 트리의 종류에는 독립적이지만 높이에 시간복잡도가 비례하기 때문에
//균형잡힌트리에서 효율적
Node* kth(Node* root, int k) {
	//왼쪽 서브트리의 크기를 우선 계산한다.
	int leftSize = 0;
	if (root->left != NULL) leftSize = root->left->size;
	if (k <= leftSize) return kth(root->left, k);
	if (k == leftSize + 1) return root;
	return kth(root->right, k - leftSize - 1);
}

//트립에서 X보다 작은 원소의 수를 찾는 알고리즘의 구현
int countLessThan(Node* root, KeyType key) {
	if (root == NULL)return 0;
	if (root->key >= key)
		return countLessThan(root->left, key);
	int ls = (root->left ? root->left->size : 0);
	return ls + 1 + countLessThan(root->right, key);
}

int n, shifted[50000];
int A[50000];

void solve() {
	Node* candidates = NULL;
	for (int i = 0; i < n; ++i)
		candidates = insert(candidates, new Node(i + 1));
	//뒤에서부터 A[]를 채워나간다.
	for (int i = n - 1; i >= 0; --i) {
		//후보 중 이 수보다 큰 수가 larger개 있따.
		int larger = shifted[i];
		Node* k = kth(candidates, i + 1 - larger);
		A[i] = k->key;
		candidates = erase(candidates, k->key);
	}
}
int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int t;
	cin >> t;
	while (t--) {
		cin >> n;
		for (int i = 0; i < n; ++i) {
			cin >> shifted[i];
		}
		solve();
		for (int i = 0; i < n; ++i) {
			cout << A[i] << ' ';
		}
		cout << '\n';
	}
}