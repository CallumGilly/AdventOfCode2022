# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

def main():
    most = [0, 0, 0]
    with open("input.txt", "r") as input_file:
        arr = input_file.readlines()
    current = 0
    for line in arr:
        if line == "\n":
            if current > most[2]:
                if current > most[1]:
                    if current > most[0]:
                        most[2] = most[1]
                        most[1] = most[0]
                        most[0] = current
                    else:
                        most[2] = most[1]
                        most[1] = current
                else:
                    most[2] = current
            current = 0
        else:
            current += int(line)
    print(most[0] + most[1] + most[2])


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
