hor, aim, dep = 0, 0, 0
for i in open("day2.txt","r").readlines():
    b = i.split(" ")
    b[1] = b[1].replace("\n","")
    if b[0] == "up":
        aim -= int(b[1])
    elif b[0] == "down":
        aim += int(b[1])
    else:
        hor += int(b[1])
        dep += aim*int(b[1])
print(hor*dep)
