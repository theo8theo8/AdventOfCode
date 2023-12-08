with open('day8.txt') as f:
    input = f.read().split('\n\n')
    dirs = input[0]
    fols = {}
    for line in input[1].splitlines(): fols.update({line.split()[0]: line.split(')')[0].split('(')[1].split(', ')} )
    curr = [k for k in fols.keys() if k.endswith("A")]
    times = 0
    while not all(e.endswith("Z") for e in curr):
        for char in dirs:
            times += 1
            if char == 'L':
                curr = [fols[c][0] for c in curr]
            elif char == 'R':
                curr = [fols[c][1] for c in curr]
    print(times)