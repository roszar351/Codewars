def maxSequence(arr):
    maxsum = 0
    cursum = 0
    for i in arr:
        cursum += i
        if cursum > maxsum:
            maxsum = cursum
        if cursum < 0:
            cursum = 0

    return maxsum
