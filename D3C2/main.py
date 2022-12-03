# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def main():
    with open("input.txt", "r") as file:
        rucksacks = file.readlines()
    sum = 0
    for x in range(0, len(rucksacks), 3):
        for item in rucksacks[x]:
            if item in rucksacks[x + 1] and item in rucksacks[x + 2]:
                sum += calcPriority(item)
                break
    print(sum)

def calcPriority(item):
    if 64 < ord(item) < 91:
        print(item + "Becomes " + str(ord(item) - 38))
        return ord(item) - 38
    else:
        print(item + "Becomes " + str(ord(item) - 96))
        return ord(item) - 96

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
