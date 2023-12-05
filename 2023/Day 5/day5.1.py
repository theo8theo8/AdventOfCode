with open('day5.txt') as f:
    input = f.read().split('\n\n')
    seeds = [int(a) for a in input[0].split()[1:]]
    data = [line.splitlines()[1:] for line in input[1:]]
    
    final = []
    for seed in seeds:
        mapped = seed
        for i in range(len(data)):
            for d in data[i]:
                dst_start, src_start, length = [int(a) for a in d.split()]
                if src_start <= mapped < src_start + length:
                    mapped = dst_start + ( mapped - src_start)
                    break
        final.append(mapped)
    print(min(final))