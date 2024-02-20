def check_line(matrix, rename, line):
    for j in range(len(matrix)):
        if j not in rename:
            if matrix[line][j] == 1:
                return False
    return True


def main():
    n, m = map(int, input().split())
    matrix = [[0 for _ in range(n)] for __ in range(n)]
    for _ in range(m):
        start, finish = map(int, input().split())
        matrix[start - 1][finish - 1] = 1
    rename = [-1 for _ in range(n)]
    cur = n
    q = True
    while cur > 0 and q:
        q = False
        for i in range(n):
            if i not in rename:
                if check_line(matrix, rename, i):
                    rename[cur - 1] = i
                    cur -= 1
                    q = True
    if rename[0] == -1:
        print('-1')
        return
    for i in range(n):
        print(rename[i]+1, end=' ')
    print()


if __name__ == '__main__':
    main()
