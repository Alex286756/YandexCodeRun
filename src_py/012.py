import sys

def main():
    n = int(input())
    matrix = [[0 for i in range(n)] for j in range(n)]
    for i in range(n):
        s1 = input().split()
        for j in range(n):
            matrix[i][j] = int(s1[j])
    s2 = input().split()
    a = int(s2[0])
    b = int(s2[1])

    puti = [-1 for i in range(n)]
    puti[a - 1] = 0
    temp = set(i for i in range(n) if matrix[a - 1][i] == 1)
    for i in temp:
        puti[i] = 1
    q = True
    while len(temp) > 0 and q:
        new_temp = set()
        for el in temp:
            for i in range(n):
                if matrix[el][i] == 1 and puti[i] == -1:
                    puti[i] = puti[el] + 1
                    new_temp.add(i)
                    if i == b - 1:
                        q = False


        temp = new_temp
    print(puti[b - 1])

if __name__ == '__main__':
    main()