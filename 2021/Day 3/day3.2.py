oxygen_list, co2_list, i = open("day3.txt","r").readlines(), open("day3.txt","r").readlines(), 0
while len(co2_list) > 1:
    o, z = 0, 0
    for k in co2_list:
        if k[i] == "0":
            z += 1
        else:
            o += 1
    remove_list = []
    if o >= z:
        for k in co2_list:
            if k[i] == "1":
                remove_list.append(k)
    else:
        for k in co2_list:
            if k[i] == "0":
                remove_list.append(k)
    for k in remove_list:
        co2_list.remove(k)
    i+=1
i = 0
while len(oxygen_list) > 1:
    o, z = 0, 0
    for k in oxygen_list:
        if k[i] == "0":
            z += 1
        else:
            o += 1
    remove_list = []
    if z > o:
        for k in oxygen_list:
            if k[i] == "1":
                remove_list.append(k)
    else:
        for k in oxygen_list:
            if k[i] == "0":
                remove_list.append(k)
    for k in remove_list:
        oxygen_list.remove(k)
    i+=1
print("Res:", int(co2_list[0], 2)*int(oxygen_list[0], 2))