def main():
    s1 = input().split()
    n_material = int(s1[0])
    m_one_zagotovki = int(s1[1])
    k_one_detal = int(s1[2])

    if n_material < m_one_zagotovki or m_one_zagotovki < k_one_detal:
        print("0")
        return

    count = 0
    count_zagotovok = n_material // m_one_zagotovki
    count_detalei_v_zagotovke = m_one_zagotovki // k_one_detal
    ostatok_one_zagotovki = m_one_zagotovki % k_one_detal

    while count_zagotovok > 0:
        n_ostatok = n_material % m_one_zagotovki
        count += count_detalei_v_zagotovke * count_zagotovok
        ostatok_material = count_zagotovok * ostatok_one_zagotovki
        n_material = n_ostatok + ostatok_material
        count_zagotovok = n_material // m_one_zagotovki
    print(count)


if __name__ == '__main__':
    main()
