
a,b=0,1
for n in range(1,21):
    print("%d" %(a), end='')
    a,b=b,a+b
    if(n < 20):
        print(",", end='')
        
