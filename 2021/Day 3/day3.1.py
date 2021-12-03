gamma = ""
epsilon = ""
f = open("day3.txt","r").readlines()
for i in range(len(f[1])-1):
    o, z = 0, 0
    for j in f:
        if j[i] == "0":
            z += 1
        else:
            o += 1
    if z > o:
        gamma += "0"
        epsilon += "1"
    else:
        gamma += "1"
        epsilon += "0"
print("Res:", int(gamma, 2)*int(epsilon, 2))
