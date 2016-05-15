def mergeSort(alist):
    size=len(alist)
    sort(alist, 0, size-1)
    return alist


def sort(arrayList,startIndex,endIndex):
    if(startIndex < endIndex) :
        middle=startIndex+(endIndex-startIndex)//2;
        sort(arrayList, startIndex, middle);
        sort(arrayList, middle+1, endIndex);
        merge(arrayList,startIndex,middle,endIndex);
    
def merge(arrayList,startIndex,middle,endIndex):
    leftArray = arrayList[:middle]
    rightArray = arrayList[middle:]
    
    #print helperArray
    k=startIndex
    leftIndex=0
    rightIndex=0
    while(leftIndex < len(leftArray) and rightIndex < len(rightArray)) :
        if(leftArray[leftIndex] <= rightArray[rightIndex]):
            arrayList[k]=leftArray[leftIndex]
            leftIndex+=1
        else:
            arrayList[k]=rightArray[rightIndex]
            rightIndex+=1
        k+=1
    while(leftIndex<  len(leftArray)):
        arrayList[k]=leftArray[leftIndex]
        leftIndex+=1
        k+=1
    while(rightIndex< len(rightArray)):
        arrayList[k]=rightArray[rightIndex]
        rightIndex+=1
        k+=1


ar=[3,4,2,5,6,1,9,8,7]
mergeSort(ar);
print "sorted list = " 
print ar