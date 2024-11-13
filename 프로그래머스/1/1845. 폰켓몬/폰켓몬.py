def solution(nums):
    size = len(nums) >> 1
    s = set(nums)
    return len(s) if len(s) < size else size
