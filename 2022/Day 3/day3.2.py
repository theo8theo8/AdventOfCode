sum = 0
with open('day3.txt') as f:
    input = f.read().splitlines()
    for i in range(0,len(input),3):
        char = set(input[i]).intersection(set(input[i+1])).intersection(set(input[i+2])).pop()
        if char.islower():
            sum += ord(char)-96
        else:
            sum += ord(char)-64+26
print(sum)