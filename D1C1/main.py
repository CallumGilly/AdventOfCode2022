# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

def main():
    most = 0
    with open("input.txt", "r") as input_file:
        arr = input_file.readlines()
    current = 0
    for line in arr:
        if line == "\n":
            if current > most:
                most = current
            current = 0
        else:
            current += int(line)
    print(most)
# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
