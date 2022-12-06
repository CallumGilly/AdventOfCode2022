# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
def main():
    with open("input.txt", "r") as file:
        input = file.readline()
    chars = [input[0],input[1],input[2],input[3],input[4],input[5],input[6],input[7],input[8],input[9],input[10],input[11],input[12],input[13]]
    for x in range(14, len(input)):
        chars.pop(0)
        chars.append(input[x])
        print(chars)
        if valid_start(chars):
            print(str(x + 1) + " / " + str(len(input)))
            break
def valid_start(chars):
    flag = True
    for x in range(0,14):
        for y in range(0,14):
            if x != y and chars[x] == chars[y]:
                print(chars[x] + "==" + chars[y])
                flag = False
    return flag

# Press the green button in the gutter to run the script.s
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
