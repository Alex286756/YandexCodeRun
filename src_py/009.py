import sys

def check_cluster(points: set, edges: dict, start_point: int) -> str:
    left = set()
    left.add(start_point)
    temp = edges.get(start_point, set())
    right = set(i for i in temp)
    odd = 1
    while len(temp) > 0:
        new_temp = set()
        for el_a in temp:
            for el_b in edges.get(el_a, set()):
                if odd == 0:
                    if el_b in left:
                        return 'NO'
                    elif el_b not in right:
                        right.add(el_b)
                        new_temp.add(el_b)
                else:
                    if el_b in right:
                        return 'NO'
                    elif el_b not in left:
                        left.add(el_b)
                        new_temp.add(el_b)

        odd = 1 - odd
        temp = new_temp
    
    return 'YES'

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
        if a == b:
            print('NO')
            return
        list_a = edges.get(a, set())
        list_a.add(b)
        edges[a] = list_a
        list_b = edges.get(b, set())
        list_b.add(a)
        edges[b] = list_b

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
        if check_cluster(cluster, edges, min_num) == 'NO':
            print('NO')
            return
        
    print('YES')    

if __name__ == '__main__':
    main()