def mergeSort(alist):
    if len(alist)>1:
        print("Splitting ",alist)
        mid = len(alist)//2
        lefthalf = alist[:mid]
        righthalf = alist[mid:]

        mergeSort(lefthalf)
        mergeSort(righthalf)

        i=0
        j=0
        k=0
        print("Left = ", lefthalf)
        print("right = ",righthalf)
        while i < len(lefthalf) and j < len(righthalf):
            if lefthalf[i] < righthalf[j]:
                alist[k]=lefthalf[i]
                i=i+1
            else:
                alist[k]=righthalf[j]
                j=j+1
            k=k+1
        print("array now = ",alist)

        while i < len(lefthalf):
            alist[k]=lefthalf[i]
            i=i+1
            k=k+1

        while j < len(righthalf):
            alist[k]=righthalf[j]
            j=j+1
            k=k+1
        print("Merged ",alist)
    else:
        print("Cannot split further", alist)

alist = [54,26,93,17,77,31,44,55,20]
mergeSort(alist)
print(alist)
