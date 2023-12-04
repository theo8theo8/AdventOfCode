with open('day1.txt') as f:
    input = f.read().splitlines()
    sum = 0
    for row in input:
        digFirst = True
        firstDig = 0
        lastDig = 0
        row = row + '                              '
        for i in range (len(row)):
            if row[i].isdigit():
                lastDig = row[i]
                if digFirst:
                    firstDig = row[i]
                    digFirst = False
                i+=1
            elif row[i] == 'o' and row[i+1] == 'n' and row[i+2] == 'e':
                lastDig = 1
                if digFirst:
                    firstDig = 1
                    digFirst = False
                i+=3
            elif row[i] == 't' and row[i+1] == 'w' and row[i+2] == 'o':
                lastDig = 2
                if digFirst:
                    firstDig = 2
                    digFirst = False
                i+=3
            elif row[i] == 't' and row[i+1] == 'h' and row[i+2] == 'r' and row[i+3] == 'e' and row[i+4] == 'e':
                lastDig = 3
                if digFirst:
                    firstDig = 3
                    digFirst = False
                i+=5
            elif row[i] == 'f' and row[i+1] == 'o' and row[i+2] == 'u' and row[i+3] == 'r':
                lastDig = 4
                if digFirst:
                    firstDig = 4
                    digFirst = False
                i+=4
            elif row[i] == 'f' and row[i+1] == 'i' and row[i+2] == 'v' and row[i+3] == 'e':
                lastDig = 5
                if digFirst:
                    firstDig = 5
                    digFirst = False
                i+=4
            elif row[i] == 's' and row[i+1] == 'i' and row[i+2] == 'x':
                lastDig = 6
                if digFirst:
                    firstDig = 6
                    digFirst = False
                i+=3
            elif row[i] == 's' and row[i+1] == 'e' and row[i+2] == 'v' and row[i+3] == 'e' and row[i+4] == 'n':
                lastDig = 7
                if digFirst:
                    firstDig = 7
                    digFirst = False
                i+=5
            elif row[i] == 'e' and row[i+1] == 'i' and row[i+2] == 'g' and row[i+3] == 'h' and row[i+4] == 't':
                lastDig = 8
                if digFirst:
                    firstDig = 8
                    digFirst = False
                i+=5
            elif row[i] == 'n' and row[i+1] == 'i' and row[i+2] == 'n' and row[i+3] == 'e':
                lastDig = 9
                if digFirst:
                    firstDig = 9
                    digFirst = False
                i+=4
        sum += (int(str(firstDig) + str(lastDig)))
print(sum)