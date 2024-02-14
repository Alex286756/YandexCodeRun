def main():
    n, m = map(int, input().split())
    path = [[0 for _ in range(m)] for __ in range(n)]
    path[0][0] = 1
    if m > 2 and n > 1:
        path[1][2] = 1
    if m > 1 and n > 2:
        path[2][1] = 1
    for i in range(2, n):
        for j in range(2, m):
            path[i][j] = path[i - 2][j - 1] + path[i - 1][j - 2]
    print(path[n-1][m-1])


if __name__ == '__main__':
    main()
