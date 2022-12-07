import sys
file_sys = {}
curr = []
tot = []

def add_to_fldr(inp, val):
    fldr = file_sys
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

def find_lowest(fldr, to_free):
    for fl in fldr:
        if fl == "size":
            if fldr[fl] >= to_free:
                tot.append(fldr[fl])
        elif type(fldr[fl]) == dict:
            find_lowest(fldr[fl], to_free)
    
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
    sum = size_sum(file_sys["/"])
    to_free = 30000000-(70000000-sum)
    (find_lowest(file_sys["/"], to_free))
    print(min(tot))