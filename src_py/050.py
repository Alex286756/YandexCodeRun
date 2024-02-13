import sys


def main():
    words = dict()
    m = 0
    for line in sys.stdin.readlines():
        s = line.split()
        for el in s:
            temp = words.get(el, 0) + 1
            words[el] = temp
            if temp > m:
                m = temp
    res = list(w for w in words.keys() if words.get(w) == m)
    result = sorted(res)[0]
    print(result)


if __name__ == '__main__':
    main()