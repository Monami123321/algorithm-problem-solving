import sys


def mergeSort(arr):
    tmp = [0] * len(arr)
    sort(arr, tmp, 0, len(arr) - 1)


def sort(arr, tmp, left, right):
    if left == right:
        return
    mid = left + right >> 1
    sort(arr, tmp, left, mid)
    sort(arr, tmp, mid + 1, right)
    merge(arr, tmp, left, mid, right)


def merge(arr, tmp, left, mid, right):
    l = left
    index = left
    r = mid + 1
    while l <= mid and r <= right:
        if arr[l] < arr[r]:
            tmp[index] = arr[l]
            l += 1
            index += 1
        else:
            tmp[index] = arr[r]
            r += 1
            index += 1

    while l <= mid:
        tmp[index] = arr[l]
        index += 1
        l += 1
    while r <= right:
        tmp[index] = arr[r]
        index += 1
        r += 1
    arr[left : right + 1] = tmp[left : right + 1]


n, *arr = map(int, sys.stdin.read().split())
mergeSort(arr)
sys.stdout.write("\n".join(map(str, arr)))
