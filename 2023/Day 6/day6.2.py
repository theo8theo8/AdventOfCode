with open('day6.txt') as f:
    input = f.read().splitlines()
    race = [int("".join(input[0].split()[1:])), int("".join(input[1].split()[1:]))]
    sum = 0
    for i in range(race[0]):
        if i*(race[0]-i) > race[1]: sum += 1
    print(sum)