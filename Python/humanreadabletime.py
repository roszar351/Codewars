def make_readable(seconds):
    return "{:02d}:{:02d}:{:02d}".format(int(seconds / 60 / 60 % 100), int(seconds / 60 % 60), seconds % 60)

print(make_readable(5))
