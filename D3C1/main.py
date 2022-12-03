# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def main():
    with open("../D3C2/input.txt", "r") as file:
        input_data = file.readlines()
    sum = 0
    for rucksack in input_data:
        sum += calcPriority(rucksack)
    print(sum)

def calcPriority(rucksack):
    divider = int((len(rucksack) - 1) /2)

    for item in rucksack[0:divider]:
        if item in rucksack[divider:]:
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
