sys = {}
curr = []

def add_to_fldr(inp, val):
    fldr = sys
    for char in curr:
        fldr = fldr[char]
    fldr[inp] = val

def size_sum(fldr):
    size = 0
    for fl in fldr:
        if type(fldr[fl]) == dict:
            size += size_sum(fldr[fl])
        elif fl == "size":
            size += int(fldr[fl])
        else:
            size += int(fldr[fl])
    fldr["size"] = size
    return size

def find_all_under_100k(fldr):
    tot = 0
    for fl in fldr:
        if fl == "size":
            if fldr[fl] <= 100000:
                tot += fldr[fl]
        elif type(fldr[fl]) == dict:
            tot += find_all_under_100k(fldr[fl])
    return tot


with open('day7.txt') as f:
    for line in f.read().splitlines():
        if line[0] == '$':          # if command
            if line [2] == 'c':     # if cd
                if line[5:7] == "..":
                    curr = curr[:-1]
                else:
                    add_to_fldr(line[5:], {})
                    curr.append(line[5:])
        else:
            ls = line.split()
            if ls[0] == "dir":
                add_to_fldr(ls[1], {})
            else:
                add_to_fldr(ls[1], ls[0])
    size_sum(sys["/"])
    print(find_all_under_100k(sys["/"]))