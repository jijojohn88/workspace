class node:
    def __init__(self,d,left=None,right=None):
        self.data=d
        self.left=left
        self.right=right

def partition(ar):
    if(ar == None or len(ar) <1) :
        return None;
    root = node(ar[len(ar)//2])
    root.left = partition(ar[:len(ar)//2])
    root.right= partition(ar[len(ar)//2+1:])
    return root

def preOrderTraversal(root):
    if(root == None):
        return;
    print(root.data,end=',')
    preOrderTraversal(root.left)
    preOrderTraversal(root.right)
    
def postOrderTraversal(root):
    if(root == None):
        return;
    postOrderTraversal(root.left)
    postOrderTraversal(root.right)
    print(root.data,end=',')

def inOrderTraversal(root):
    if(root == None):
        return;
    inOrderTraversal(root.left)
    print(root.data,end=',')
    inOrderTraversal(root.right)
    
def levelOrder(rootNode):
    thislevel=[rootNode];
    while thislevel : 
        nextLevel = list();
        for node in thislevel:
            print (node.data,end=',')
            if node.left: nextLevel.append(node.left);
            if node.right: nextLevel.append(node.right);
        print
        thislevel=nextLevel

def levelOrderTraversal(root):
    thisLevel=[root]
    while thisLevel :
        newLevel = list()
        for n in thisLevel:
            print (n.data,end=',')
            if n.left : newLevel.append(n.left)
            if n.right: newLevel.append(n.right)
        print()
        thisLevel=newLevel

ar=[3,2,1,4,6,5,8,7,9]
ar.sort();
print("ArrayAfter Sort = ",ar)
root=partition(ar)

print("\nInorder Traversal")
inOrderTraversal(root)
print("\nLevelOrder Traversal")
levelOrderTraversal(root)
print("\nPostOrder Traversal")
postOrderTraversal(root)
print("\nPreOrder Traversal")
preOrderTraversal(root)

