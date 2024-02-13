import sys


def main():
    s_in = sys.stdin.readlines()
    ddd = dict()
    for s1 in s_in:
        s2 = s1.strip().split()
        name = s2[0]
        item = s2[1]
        price = int(s2[2])
        temp = ddd.get(name, dict())
        temp2 = temp.get(item, 0) + price
        temp[item] = temp2
        ddd[name] = temp
    for name in sorted(list(ddd.keys())):
        print(name + ":")
        temp = ddd.get(name)
        for item in sorted(list(temp.keys())):
            print(item, temp[item])


if __name__ == '__main__':
    main()
