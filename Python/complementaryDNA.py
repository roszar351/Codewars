def DNA_strand(dna):
    ans = ""
    for i in dna:
        if i == "A":
            ans = ans + "T"
        elif i == "T":
            ans = ans + "A"
        elif i == "G":
            ans = ans + "C"  
        else:
            ans = ans + "G"

    return ans
