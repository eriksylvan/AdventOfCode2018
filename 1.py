import fileinput

# create a list of lines (strings) from the input file
lines = list(fileinput.input())

def part1():
    # int(...) ignores whitespace and properly handles + and - signs
    # map(int, lines) applies int(...) to each line
    # sum(...) adds up all of the resulting integers
    return sum(map(int, lines))

def part2():
    # starting frequency is zero
    f = 0

    # create a new set to track frequencies that have been seen
    # initialize with the current frequency (zero)
    seen = {f}

    # repeatedly loop over the lines in the file
    # a repeat is not guaranteed to occur on the first pass
    while True:
        for line in lines:
            # update the current frequency
            f += int(line)
            # check if this is a repeat
            if f in seen:
                return f

            # remember the current frequency
            seen.add(f)

print(part1())
print(part2())