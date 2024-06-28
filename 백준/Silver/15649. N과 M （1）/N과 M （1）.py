import sys

input = sys.stdin.readline

N, M = map(int, input().split())
result = []

# backtracking: 해를 구하는 도중 해가 아니여서, 이전으로 돌아가 해를 찾는 기법
def backtracking():
    if len(result) == M:
        print(' '.join(map(str, result)))
        return
    
    for i in range(1, N + 1):
        if i not in result:
            result.append(i)
            backtracking()
            result.pop()

backtracking()