def get_sum(a,b):
    if a == b:
        return a

    if a > b:
        s = b
        b = a
        a = s
    s = 0
    for i in range(a, b+1):
        s += i

    return s

print(get_sum(1, 2) == 3)
print(get_sum(1, 0) == 1)
print(get_sum(0, 1) == 1)
print(get_sum(1, 1) == 1)
print(get_sum(-1, 0) == -1)
print(get_sum(-1, 2) == 2)
