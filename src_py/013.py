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

    puti = [list() for i in range(n)]
    puti[a - 1].append(a)
    q = True
    temp = set()
    temp.add(a - 1)

    while len(temp) > 0 and q:
        new_temp = set()
        for el in temp:
            for i in range(n):
                if matrix[el][i] == 1:
                    if len(puti[i]) == 0 or len(puti[i]) > len(puti[el]) + 1:
                        puti[i].clear
                        for j in puti[el]:
                            puti[i].append(j)
                        puti[i].append(i + 1)
                        new_temp.add(i)
                    
                    if i == b - 1:
                        q = False
        temp = new_temp

    if len(puti[b - 1]) == 0:
        print(-1)
    else:
        print(len(puti[b - 1]) - 1)
        str_out = ''
        for el in puti[b - 1]:
            str_out += str(el) + ' '
        print(str_out.strip())

if __name__ == '__main__':
    main()