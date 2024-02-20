
def main():
    n, m = map(int, input().split())
    start_points = dict()
    finish_points = dict()
    points = {i + 1 for i in range(n)}
    for _ in range(m):
        start, finish = map(int, input().split())
        if start_points.get(start) is None:
            start_points[start] = set()
        start_points[start].add(finish)
        if finish_points.get(finish) is None:
            finish_points[finish] = set()
        finish_points[finish].add(start)
        points.discard(start)

    rename = [-1 for _ in range(n)]
    cur = n
    while len(points) > 0:
        el = points.pop()
        rename[el - 1] = cur - 1
        cur -= 1
        for i in finish_points.get(el, set()):
            temp = start_points.get(i, set())
            temp.remove(el)
            if len(temp) == 0:
                points.add(i)

    if rename[0] == -1:
        print('-1')
        return
    for i in range(n):
        print(rename[i]+1, end=' ')
    print()


if __name__ == '__main__':
    main()
