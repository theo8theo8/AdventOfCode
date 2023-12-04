with open('day3.txt') as f:
    input = ["." + row + "." for row in f.read().splitlines()]
    input.insert(0, "."*len(input[0]))
    input.append("."*len(input[0]))

    def checkAllAround(i,j):
        return (input[i-1][j-1] != "." and not input[i-1][j-1].isdigit()) or (input[i-1][j] != "." and not input[i-1][j].isdigit()) or (input[i-1][j+1] != "." and not input[i-1][j+1].isdigit()) or (input[i][j-1] != "." and not input[i][j-1].isdigit()) or (input[i][j+1] != "." and not input[i][j+1].isdigit()) or (input[i+1][j-1] != "." and not input[i+1][j-1].isdigit()) or (input[i+1][j] != "." and not input[i+1][j].isdigit()) or (input[i+1][j+1] != "." and not input[i+1][j+1].isdigit())
        
    sum = 0
    for i in range(len(input)):
        useNum = False
        wholeNum = ""
        for j in range(len(input[i])):
            k = input[i][j]
            if k.isdigit():
                wholeNum += k
                if checkAllAround(i,j): useNum = True
            else:
                if useNum: sum+=(int(wholeNum))
                useNum = False
                wholeNum = ""
print(sum)