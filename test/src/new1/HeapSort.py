def swap(i, j):                    
    heapArray[i], heapArray[j] = heapArray[j], heapArray[i] 

def heapify(N,currentNode):   
    leftChild=2 * currentNode  
    rightChild=leftChild+1 
    maxNode=currentNode   
    if leftChild < N and heapArray[currentNode] < heapArray[leftChild]:   
        maxNode = leftChild   
    if rightChild < N and heapArray[maxNode] < heapArray[rightChild]:   
        maxNode = rightChild   
    if maxNode != currentNode:   
        swap(currentNode, maxNode)   
        heapify(N, maxNode)   

def heap_sort():     
    N = len(heapArray)   
    start = N//2-1
    print ("start = " , start)
    for i in range(start, -1, -1):   
        #print "value of i = ",i
        heapify(N, i)   
    for i in range(N-1, 0, -1): 
       #print "value of new - i = ",i
        swap(i, 0)   
        heapify(i, 0)   

heapArray = [2, 7,2,2, 1, -2, 56, 5, 3]
heap_sort()
print(heapArray) 