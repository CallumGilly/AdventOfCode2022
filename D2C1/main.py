# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def main():
    with open("input.txt", "r") as input_file:
        input_arr = input_file.readlines()
    score = 0
    for line in input_arr:
        score += calculateScore(line);
    print(score)

def calculateScore(line):
    if line[0] == "A":
        if line[-2] == "X":
            return 1 + 3
        elif line[-2] == "Y":
            return 2 + 6
        elif line[-2] == "Z":
            return 3
    elif line[0] == "B":
        if line[-2] == "X":
            return 1
        elif line[-2] == "Y":
            return 2 + 3
        elif line[-2] == "Z":
            return 3 + 6
    elif line[0] == "C":
        if line[-2] == "X":
            return 1 + 6
        elif line[-2] == "Y":
            return 2
        elif line[-2] == "Z":
            return 3 + 3
    print(line[1]+"VS"+line[-2])
    return -1111111111
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
