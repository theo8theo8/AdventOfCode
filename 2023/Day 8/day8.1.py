with open('day8.txt') as f:
    input = f.read().split('\n\n')
    dirs = input[0]
    fols = {}
    for line in input[1].splitlines(): fols.update({line.split()[0]: line.split(')')[0].split('(')[1].split(', ')} )
    curr = "AAA"
    times = 0
    while not curr == 'ZZZ':
        for char in dirs:
            times += 1
            if char == 'L':
                curr = fols[curr][0]
            elif char == 'R':
                curr = fols[curr][1]
    print(times)