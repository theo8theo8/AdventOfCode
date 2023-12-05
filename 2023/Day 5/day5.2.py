with open('day5.txt') as f:
    input = f.read().split('\n\n')
    seed_inp = [int(a) for a in input[0].split()[1:]]
    data = [line.splitlines()[1:] for line in input[1:]]

    final_min = float('inf')
    for i in range(0, len(seed_inp), 2):
        for seed in range(seed_inp[i], seed_inp[i]+seed_inp[i+1]):
            mapped = seed
            for j in range(len(data)):
                for d in data[j]:
                    dst_start, src_start, length = [int(a) for a in d.split()]
                    if src_start <= mapped < src_start + length:
                        mapped = dst_start + ( mapped - src_start)
                        break
            final_min = min(final_min, mapped)
    print(final_min)