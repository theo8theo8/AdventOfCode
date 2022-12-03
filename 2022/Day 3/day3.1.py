sum = 0
with open('day3.txt') as f:
    input = f.read().splitlines()
    for row in input:
        comp_1, comp_2 = row[:len(row)//2], row[len(row)//2:]
        char = set(comp_1).intersection(set(comp_2)).pop()
        if char.islower():
            sum += ord(char)-96
        else:
            sum += ord(char)-64+26
print(sum)