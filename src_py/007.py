import sys


def main():
    """
    Для чтения входных данных необходимо получить их
    из стандартного потока ввода (sys.stdin).
    Данные во входном потоке соответствуют описанному
    в условии формату. Обычно входные данные состоят
    из нескольких строк.
    Можно использовать несколько методов:
    * input() -- читает одну строку из потока без символа
    перевода строки;
    * sys.stdin.readline() -- читает одну строку из потока,
    сохраняя символ перевода строки в конце;
    * sys.stdin.readlines() -- вернет список (list) строк,
    сохраняя символ перевода строки в конце каждой из них.
    Чтобы прочитать из строки стандартного потока:
    * число -- int(input()) # в строке должно быть одно число
    * строку -- input()
    * массив чисел -- map(int, input().split())
    * последовательность слов -- input().split()
    Чтобы вывести результат в стандартный поток вывода (sys.stdout),
    можно использовать функцию print() или sys.stdout.write().
    Возможное решение задачи "Вычислите сумму чисел в строке":
    print(sum(map(int, input().split())))
    """
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
    cluster = set()
    cluster.add(1)
    all_points.remove(1)
    temp = set()
    for el in edges.get(1, set()):
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
    print(len(cluster))
    print(" ".join(map(str, sorted(cluster))))


if __name__ == '__main__':
    main()