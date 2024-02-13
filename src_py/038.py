import sys

def left(m: list, x: int, y: int) -> bool:
    if y <= 0:
        return False
    if m[x][y - 1] == '*' or m[x][y - 1] == '0':
        return False
    m[x][y - 1] = '0'
    return True

def right(m: list, x: int, y: int) -> bool:
    if y >= len(m[0]) - 1:
        return False
    if m[x][y + 1] == '*' or m[x][y + 1] == '0':
        return False
    m[x][y + 1] = '0'
    return True

def up(m: list, x: int, y: int) -> bool:
    if x <= 0:
        return False
    if m[x - 1][y] == '*' or m[x - 1][y] == '0':
        return False
    m[x - 1][y] = '0'
    return True

def down(m: list, x: int, y: int) -> bool:
    if x >= len(m) - 1:
        return False
    if m[x + 1][y] == '*' or m[x + 1][y] == '0':
        return False
    m[x + 1][y] = '0'
    return True

def check(m: list, x: int, y: int, sum: int):
    if left(m, x, y):
        check(m, x, y - 1, sum)
    if right(m, x, y):
        check(m, x, y + 1, sum) 
    if up(m, x, y):
        check(m, x - 1, y, sum) 
    if down(m, x, y):
        check(m, x + 1, y, sum) 


def main():
    n = int(input())
    matrix = []
    for i in range(n):
        s1 = input()
        line = []
        for j in range(n):
            line.append(s1[j])
        matrix.append(line)
    s2 = input().split()
    x = int(s2[0])
    y = int(s2[1])

    matrix[x - 1][y - 1] = '0'
    check(matrix, x - 1, y - 1, sum)
    res = 0
    for i in range(n):
        l1 = [1 for el in matrix[i] if el == '0']
        res += sum(l1)

    print(res)

if __name__ == '__main__':
    main()