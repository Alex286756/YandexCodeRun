def main():
    n, m = map(int, input().split())
    matrix = []
    for i in range(n):
        numbers = [int(x) for x in input().split()]
        matrix.append(numbers)
    cost = [[0 for _ in range(m)] for __ in range(n)]
    path = [['' for _ in range(m)] for __ in range(n)]
    cost[0][0] = matrix[0][0]
    for i in range(1, m):
        cost[0][i] = cost[0][i - 1] + matrix[0][i]
        path[0][i] = path[0][i - 1] + 'R'
    for i in range(1, n):
        cost[i][0] = cost[i - 1][0] + matrix[i][0]
        path[i][0] = path[i - 1][0] + 'D'
    for i in range(1, n):
        for j in range(1, m):
            if cost[i - 1][j] > cost[i][j - 1]:
                cost[i][j] = cost[i - 1][j] + matrix[i][j]
                path[i][j] = path[i - 1][j] + 'D'
            else:
                cost[i][j] = cost[i][j - 1] + matrix[i][j]
                path[i][j] = path[i][j - 1] + 'R'
    print(cost[n - 1][m - 1])
    print(*path[n - 1][m - 1])


if __name__ == '__main__':
    main()
