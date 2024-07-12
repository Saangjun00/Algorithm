import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

result = []

def backtracking():
    if len(result) == M:
        print(*result)
        return
    
    for i in range(N):
        if arr[i] not in result:
            result.append(arr[i])
            backtracking()
            result.pop()

backtracking()
