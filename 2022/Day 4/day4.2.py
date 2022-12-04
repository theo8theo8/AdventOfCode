no_pairs = 0
with open('day4.txt') as f:
    input = f.read().splitlines()
    for row in input:
        c_1, c_2 = row.split(",")
        da_1, da_2 = c_1.split("-")
        db_1, db_2 = c_2.split("-")
        s_1 = set(range(int(da_1), int(da_2)+1))
        s_2 = set(range(int(db_1), int(db_2)+1))
        if not s_1.isdisjoint(s_2): no_pairs += 1
print(no_pairs)