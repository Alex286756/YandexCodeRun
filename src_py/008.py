import sys


def main():
    str1 = input().split()
    n = int(str1[0])
    m = int(str1[1])
    edges = dict()
    all_points = set(i + 1 for i in range(n))
    for i in range(m):
        str2 = input().split()
        a = int(str2[0])
        b = int(str2[1])
        if a != b:
            list_a = edges.get(a, set())
            list_a.add(b)
            edges[a] = list_a
            list_b = edges.get(b, set())
            list_b.add(a)
            edges[b] = list_b
    result = []

    while len(all_points) > 0:
        cluster = set()
        min_num = all_points.pop()
        cluster.add(min_num)
        temp = set()
        for el in edges.get(min_num, set()):
            cluster.add(el)
            all_points.remove(el)
            temp.add(el)
        while len(temp) > 0:
            new_temp = set()
            for el_a in temp:
                for el_b in edges.get(el_a, set()):
                    if el_b in all_points:
                        all_points.remove(el_b)
                        new_temp.add(el_b)
                        cluster.add(el_b)
            temp = new_temp
        result.append(cluster)
    print(len(result))
    for cl in result:
        print(len(cl))
        print(" ".join(map(str, sorted(cl))))


if __name__ == '__main__':
    main()