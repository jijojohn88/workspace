
def sort(ar,lowerIndex,higherIndex):
    if(ar == None or len(ar)<1):
        return;
    i=lowerIndex
    j=higherIndex
    pivotIndex=lowerIndex+(higherIndex-lowerIndex)//2
    pivot = ar[pivotIndex]
    
    while i <= j:
        while i < higherIndex and pivot > ar[i]:
            i+=1
        while j > lowerIndex and pivot < ar[j]:
            j-=1
        
        if i<=j :
            ar[i],ar[j] = ar[j],ar[i]
            i+=1
            j-=1
    
    if i <= higherIndex:
        sort(ar,i,higherIndex)
    if j >= lowerIndex:
        sort(ar,lowerIndex,j)

ar = [3,4,2,1,5,8,7,6,9,12,11,10]
print("Array Before Sort = ",ar)
sort(ar,0,len(ar)-1)
print("Array after sort ", ar)