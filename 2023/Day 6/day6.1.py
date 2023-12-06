with open('day6.txt') as f:
    input = f.read().splitlines()
    races = list(zip([int(a) for a in input[0].split()[1:]], [int(a) for a in input[1].split()[1:]]))
    sum = 1
    for race in races:
        times = 0
        for i in range(race[0]):
            if i*(race[0]-i) > race[1]: times += 1
        sum *= times
    print(sum)