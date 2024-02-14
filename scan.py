import os

FILE_NAME_OUT = 'README.md'
N_TASKS = 367


def scan_python() -> list:
    files_list = os.listdir('./src_py')
    return [x.strip('.py') for x in files_list]


def scan_java() -> list:
    files_list = os.listdir('./src_java')
    return [x.strip('.java') for x in files_list]


def scan_kotlin() -> list:
    files_list = os.listdir('./src_kt')
    return [x.strip('.kt') for x in files_list]


def scan_javascript() -> list:
    files_list = os.listdir('./src_jscr')
    return [x.strip('.js') for x in files_list]


if __name__ == '__main__':
    files = [scan_python(), scan_kotlin(), scan_java(), scan_javascript()]
    with open(FILE_NAME_OUT, 'w+', encoding='UTF-8') as file_out:
        file_out.write('''
<h1 align="center">Hi there, I'm Alex! </h1>
<h3 align="center">Here I am write code (on different langs) which can see how resolve tasks on Yandex CodeRun</h3>

<table>
<tr><th align="center">Task number</th><th align="center">Python</th><th align="center">Kotlin</th><th align="center">Java</th><th>JavaScript</th></tr> 
        ''')
        for i in range(1, N_TASKS + 1):
            if i in map(int, files[0]):
                py_cell = f'<a href = "https://github.com/Alex286756/YandexCodeRun/blob/main/src_py/{i:3}.py">+</a>'
            else:
                py_cell = 'пока нет'
            if i in map(int, files[1]):
                kt_cell = f'<a href = "https://github.com/Alex286756/YandexCodeRun/blob/main/src_kt/{i:3}.kt">+</a>'
            else:
                kt_cell = 'пока нет'
            if i in map(int, files[2]):
                java_cell = f'<a href = "https://github.com/Alex286756/YandexCodeRun/blob/main/src_java/{i:3}.java">+</a>'
            else:
                java_cell = 'пока нет'
            if i in map(int, files[3]):
                js_cell = f'<a href = "https://github.com/Alex286756/YandexCodeRun/blob/main/src_jscr/{i:3}.js">+</a>'
            else:
                js_cell = 'пока нет'
            file_out.write(f'''
<tr> <td align = "center"> {i:3} </td>
<td align = "center"> {py_cell} </td>
<td align = "center"> {kt_cell} </td>
<td align = "center"> {java_cell} </td>
<td align = "center"> {js_cell} </td> </tr>
            ''')
        file_out.write('''
</table>
            ''')
