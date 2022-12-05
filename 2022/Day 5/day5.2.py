import re
def get_start_stacks(input):
    start_stacks = []
    for row in input:
        start_stacks.append(re.findall("[A-Z]|\s\s\s\s", row))
    return start_stacks[:-1]

def get_moves(input):
    moves = []
    for row in input:
        moves.append(re.findall("\d+", row))
    return moves

with open('day5.txt') as f:
    input = [x.splitlines() for x in f.read().split("\n\n")]
    stacks = list(map(list, zip(*get_start_stacks(input[0]))))
    stacks = [list(filter(lambda x: x.isalpha(), stack)) for stack in stacks]
    moves = get_moves(input[1])
    for move in moves:
        for i in range(int(move[0])):
            stacks[int(move[2])-1].insert(i, stacks[int(move[1])-1].pop(0))
    res = ""
    for stack in stacks:
        res += stack.pop(0)
    print(res)