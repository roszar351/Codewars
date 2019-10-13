def to_weird_case(string):
    i = 0
    ans = ""
    for ch in string:
        if ch != " ":
            if i % 2 == 0:
                ans += ch.upper()
            else:
                ans += ch.lower()
            i += 1
        else:
            ans += ch
            i = 0

    return ans

print(to_weird_case("This is a test"))
