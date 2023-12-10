with open('day10.txt') as f:
    input = f.read().splitlines()
    tiles = [[*char] for char in [line for line in input]]
    for i in range(len(tiles)):
        tiles[i] = ['.'] + tiles[i] + ['.']
    tiles.insert(0, ['.'] * len(tiles[0]))
    tiles.append(['.'] * len(tiles[0]))

    index = (0,0)
    for i in range(len(tiles)):
        if 'S' in tiles[i]:
            index = (i, tiles[i].index('S'))
    
   
    steps = 0
    N = ['|', '7', 'F']
    E = ['-', 'J', '7']
    S = ['|', 'L', 'J']
    W = ['-', 'L', 'F']

    def find_paths(indexOne, indexTwo):
        global steps
        if indexOne[1] == indexTwo[1]: 
            print(steps)
            return
        steps += 1
        newOne = [indexOne[1], (0,0)]
        newTwo = [indexTwo[1], (0,0)]
        if (tiles[indexOne[1][0]-1][indexOne[1][1]]) in N and (indexOne[1][0]-1, indexOne[1][1]) != indexOne[0]: newOne[1] = (indexOne[1][0]-1, indexOne[1][1])
        elif (tiles[indexOne[1][0]][indexOne[1][1]+1]) in E and (indexOne[1][0], indexOne[1][1]+1) != indexOne[0]: newOne[1] = (indexOne[1][0], indexOne[1][1]+1)
        elif (tiles[indexOne[1][0]+1][indexOne[1][1]]) in S and (indexOne[1][0]+1, indexOne[1][1]) != indexOne[0]: newOne[1] = (indexOne[1][0]+1, indexOne[1][1])
        elif (tiles[indexOne[1][0]][indexOne[1][1]-1]) in W and (indexOne[1][0], indexOne[1][1]-1) != indexOne[0]: newOne[1] = (indexOne[1][0], indexOne[1][1]-1)
        if (tiles[indexTwo[1][0]-1][indexTwo[1][1]]) in N and (indexTwo[1][0]-1, indexTwo[1][1]) != indexTwo[0]: newTwo[1] = (indexTwo[1][0]-1, indexTwo[1][1])
        elif (tiles[indexTwo[1][0]][indexTwo[1][1]+1]) in E and (indexTwo[1][0], indexTwo[1][1]+1) != indexTwo[0]: newTwo[1] = (indexTwo[1][0], indexTwo[1][1]+1)
        elif (tiles[indexTwo[1][0]+1][indexTwo[1][1]]) in S and (indexTwo[1][0]+1, indexTwo[1][1]) != indexTwo[0]: newTwo[1] = (indexTwo[1][0]+1, indexTwo[1][1])
        elif (tiles[indexTwo[1][0]][indexTwo[1][1]-1]) in W and (indexTwo[1][0], indexTwo[1][1]-1) != indexTwo[0]: newTwo[1] = (indexTwo[1][0], indexTwo[1][1]-1)
        find_paths(newOne, newTwo)   

    paths = []
    if (tiles[index[0]-1][index[1]]) in N: paths.append((index[0]-1, index[1]))
    if (tiles[index[0]][index[1]+1]) in E: paths.append((index[0], index[1]+1))
    if (tiles[index[0]+1][index[1]]) in S: paths.append((index[0]+1, index[1]))
    if (tiles[index[0]][index[1]-1]) in W: paths.append((index[0], index[1]-1))
    
    find_paths([index, paths[0]], [index,paths[1]])