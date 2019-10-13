def solution(nums):
    ans = [nums[0], nums[0]]

    for i in nums:
        if i < ans[0]:
            ans[0] = i
        elif i > ans[1]:
            ans[1] = i

    return ans
