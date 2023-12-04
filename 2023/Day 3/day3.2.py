with open('day3.txt') as f:
    input = ["." + row + "." for row in f.read().splitlines()]
    input.insert(0, "."*len(input[0]))
    input.append("."*len(input[0]))
    gears = []

    def assignGear(coord, num):
        for k in range(len(gears)):
            if coord[0] == gears[k]["i"] and coord[1] == gears[k]["j"]:
                gears[k]["num"].append(num)
                return

    def addGear(i,j):
        for k in range(len(gears)):
            if i == gears[k]["i"] and j == gears[k]["j"]:return
        gears.append({"i":i,"j":j,"num":[]})

    def findStarAround(i,j):
        directions = [(-1, -1), (-1, 0), (-1, 1),
                      (0, -1),           (0, 1),
                      (1, -1),  (1, 0),  (1, 1)]

        for i1, j1 in directions:
            i2, j2 = i + i1, j + j1
            if input[i2][j2] == "*":
                addGear(i2, j2)
                return (i2, j2)

        return False
    
    def sumGears():
        sum = 0
        for i in range(len(gears)):
            if len(gears[i]["num"]) == 2:
                sum += gears[i]["num"][0] * gears[i]["num"][1]
        return sum

    for i in range(len(input)):
        useNum = False
        wholeNum = ""
        for j in range(len(input[i])):
            k = input[i][j]
            if k.isdigit():
                wholeNum += k
                a = findStarAround(i,j)
                if a: useNum = a
            else:
                if useNum: assignGear(useNum,int(wholeNum))
                useNum = False
                wholeNum = ""
        


print(sumGears())