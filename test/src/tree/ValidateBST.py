class TreeNode:
    def __init__(self, value):
        self.key = value
        self.left = None
        self.right = None
        
        
def minHeight(root):
    if root == None:
        return 0
    left = minHeight(root.left)
    right = minHeight(root.right)
    print("[MIN]left = ",left ," right = ", right," Node = ", root.key)
    return min(left,right)+1

def maxHeight(root):
    if root == None:
        return 0
    left = maxHeight(root.left)
    right = maxHeight(root.right)
    print("[MAX]left = ",left ," right = ", right," Node = ", root.key)
    return max(left,right)+1
def checkBalanced(root):
    
    if(root == None):
        return True
    
    min = minHeight(root)
    max = maxHeight(root)
    if abs(min-max) <= 1 :# and checkBalanced(root.left) and checkBalanced(root.right) :
        return True
    else :
        return False


#Improved Height balance check for trees . as the complexity comes to o(N) - prior version has o(N2)

def height(root):
    if root == None :
        return 0
    left = height(root.left)
    right = height(root.right)
    
    print("Node = " , root.key , " left = ", left , " right =", right)
    
    if left == -1 or right == -1 : 
        return -1
    elif(abs(left-right) <=1) :
        return max(left,right)+1
    else:
        return -1
    
def validate(root):
    if height(root) == -1 : 
        return False
    else :
        return True
    


root = TreeNode(3)
root.left=TreeNode(1)
root.left.left=TreeNode(0)
root.left.right=TreeNode(2)

#root.right=TreeNode(5)
#root.right.left=TreeNode(4)
#root.right.left.right=TreeNode(6)
#root.right.right=TreeNode(3)

#print("Minimum height of the tree = " , minHeight(root))
#print("Maximum Height of the tree = " , maxHeight(root))
#print("Is the tree balanced in terms of depth - ",checkBalanced(root))
print("Is the tree balanced in terms of depth ( version -2) - ",validate(root))