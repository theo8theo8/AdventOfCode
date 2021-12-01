n, a = 0, open("day1.txt","r").readlines()
for i in range(len(a)):
    n +=  int(a[i-2])+int(a[i-1])+int(a[i]) > int(a[i-3])+int(a[i-2])+int(a[i-1])
print(n) 