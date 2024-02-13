def main():
    n = int(input())
    ddd = dict()
    for i in range(n):
        s = input().split()
        s1 = s[0]
        s2 = s[1]
        ddd[s1] = s2
        ddd[s2] = s1
    ch = input()
    print(ddd.get(ch))


if __name__ == '__main__':
    main()
