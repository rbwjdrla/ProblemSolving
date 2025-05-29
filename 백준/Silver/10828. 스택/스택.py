import sys

class stck:
    def __init__(self):
        self.array = []

    def isEmpty(self):
        return len(self.array) == 0

    def push(self, item):
        self.array.append(item)

    def pop(self):
        if not self.isEmpty():
            return self.array.pop()
        else:
            return -1

    def top(self):
        if not self.isEmpty():
            return self.array[-1]
        else:
            return -1

    def size(self):
        return len(self.array)

    def empty(self):
        return 1 if self.isEmpty() else 0

s = stck()
n = int(sys.stdin.readline())

for _ in range(n):
    command = sys.stdin.readline().strip()
    
    if command.startswith("push"):
        _, num = command.split()
        s.push(int(num))
    elif command == "pop":
        print(s.pop())
    elif command == "top":
        print(s.top())
    elif command == "size":
        print(s.size())
    elif command == "empty":
        print(s.empty())
