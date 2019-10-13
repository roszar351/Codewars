def xo(s):
    noOfX = 0
    noOfO = 0

    for c in s:
        if c == 'X' or c == 'x':
            noOfX += 1
        elif c == 'O' or c == 'o':
            noOfO += 1

    return (noOfO == noOfX)

print(xo("xxoo"))
print(xo("ooxx"))
print(xo("xooxx"))
print(xo("zpzpzpp"))
print(xo("ooxXm"))
print(xo("zzoo"))
