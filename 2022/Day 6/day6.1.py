with open('day6.txt') as f:
    input = f.read()
    for i in range(len(input)):
        mult = False
        for j in range(4):
            if input[i:i+4].count(input[j+i]) > 1:
                mult = True
        if mult == False:
            print(i+4)
            break