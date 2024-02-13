import sys


def main():
    words = dict()
    res = list()
    f = open('input.txt','r')
    lines = f.readlines()
    for line in lines:
        s = line.split()
        for el in s:
            temp = words.get(el, 0)
            res.append(temp)
            words[el] = temp + 1
    print(' '.join([str(el) for el in res]))


if __name__ == '__main__':
    main()