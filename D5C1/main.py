# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

stack = []


def main():
    with open("input.txt", "r") as file:
        input = file.readlines()
    for col in range(1, 34, 4):
        rowarr = []
        for row in range(0, 8):
            if input[row][col] != " ":
                rowarr.append(input[row][col])
        rowarr.reverse()
        stack.append(rowarr)
    flag = 0
    for line in input:
        if flag == 0:
            if line == "\n":
                flag = 1
        else:
            line_arr = line.split(" ")
            move(int(line_arr[3]) - 1, int(line_arr[5]) - 1, int(line_arr[1]))
    out = ""
    for col in stack:
        out += col.pop()
    print(out)


def move(col1, col2, count):
    for x in range(0, count):
        stack[col2].append(stack[col1].pop())


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
