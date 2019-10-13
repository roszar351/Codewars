def iq_test(numbers):
    nums = list(map(int, numbers.split()))
    lookingfor = nums[0] % 2
    if nums[1] % 2 != lookingfor and nums[2] % 2 != lookingfor:
        return 1

    for i in range(1, len(nums) - 1):
        if nums[i] % 2 != lookingfor:
            return i + 1

    return len(nums)
