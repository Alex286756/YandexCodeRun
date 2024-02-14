def main():
    n, m = map(int, input().split())
    matrix = []
    for i in range(n):
        line = input().split()
        numbers = [int(x) for x in line]
        matrix.append(numbers)
    path = [[0 for _ in range(m)] for __ in range(n)]
    path[0][0] = matrix[0][0]
    for i in range(1, m):
        path[0][i] = path[0][i - 1] + matrix[0][i]
    for i in range(1, n):
        path[i][0] = path[i - 1][0] + matrix[i][0]
    for i in range(1, n):
        for j in range(1, m):
            path[i][j] = min(path[i-1][j], path[i][j-1]) + matrix[i][j]
    print(path[n-1][m-1])


if __name__ == '__main__':
    main()
