def tickets(people):
    clerksmoney = [0, 0, 0]

    for i in people:
        if i == 25:
            clerksmoney[0] += 1
        elif i == 50:
            if clerksmoney[0] > 0:
                clerksmoney[0] -= 1
                clerksmoney[1] += 1
            else:
                return "NO"
        else:
            if clerksmoney[1] > 0:
                if clerksmoney[0] > 0:
                    clerksmoney[0] -= 1
                    clerksmoney[1] -= 1
                    clerksmoney[2] += 1
                else:
                    return "NO"

            elif clerksmoney[0] > 2:
                clerksmoney[0] -= 3
                clerksmoney[2] += 1
            else:
                return "NO"


    return "YES"
    