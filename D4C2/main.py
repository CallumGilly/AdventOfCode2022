# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def main():
    dupsum = 0
    with open("input.txt", "r") as file:
        list = file.readlines()
    for split_pair in list:
        split_pair = split_pair.split(",")

        print(split_pair)
        if int(split_pair[0].split("-")[0]) <= int(split_pair[1].split("-")[0]) <= int(split_pair[0].split("-")[1]):
            dupsum += 1
        elif int(split_pair[0].split("-")[0]) <= int(split_pair[1].split("-")[1]) <= int(split_pair[0].split("-")[1]):
            dupsum += 1
        elif int(split_pair[1].split("-")[0]) <= int(split_pair[0].split("-")[1]) <= int(split_pair[1].split("-")[1]):
            dupsum += 1
        elif int(split_pair[1].split("-")[0]) <= int(split_pair[0].split("-")[1]) <= int(split_pair[1].split("-")[1]):
            dupsum += 1
    print(dupsum)

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
