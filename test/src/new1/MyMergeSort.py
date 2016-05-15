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
    i = startIndex
    j = middle+1
    k = startIndex
    helperArray = arrayList[0:endIndex+1]
    #print helperArray
    while(i <= middle and j <= endIndex) :
        if(helperArray[i] <= helperArray[j]):
            arrayList[k]=helperArray[i]
            i+=1
        else:
            arrayList[k]=helperArray[j]
            j+=1
        k+=1
    while(i<= middle):
        arrayList[k]=helperArray[i]
        i+=1
        k+=1


ar=[3,4,2,5,6,1,9,8,7]
mergeSort(ar);
print "sorted list = " 
print ar