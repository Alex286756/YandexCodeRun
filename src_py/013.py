def main():
    n = int(input())
    matrix = [[0 for _ in range(n)] for __ in range(n)]
    for i in range(n):
        s1 = input().split()
        for j in range(n):
            matrix[i][j] = int(s1[j])
    s2 = input().split()
    a = int(s2[0])
    b = int(s2[1])
    if a == b:
        print("0")
        return

    paths = [list() for _ in range(n)]
    paths[a - 1].append(a)
    q = True
    temp = set()
    temp.add(a - 1)

    while len(temp) > 0 and q:
        new_temp = set()
        for el in temp:
            for i in range(n):
                if matrix[el][i] == 1:
                    if len(paths[i]) == 0 or len(paths[i]) > len(paths[el]) + 1:
                        paths[i].clear()
                        for j in paths[el]:
                            paths[i].append(j)
                        paths[i].append(i + 1)
                        new_temp.add(i)
                    
                    if i == b - 1:
                        q = False
        temp = new_temp

    if len(paths[b - 1]) == 0:
        print(-1)
    else:
        print(len(paths[b - 1]) - 1)
        str_out = ''
        for el in paths[b - 1]:
            str_out += str(el) + ' '
        print(str_out.strip())


if __name__ == '__main__':
    main()
