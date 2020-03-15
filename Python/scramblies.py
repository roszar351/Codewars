def scramble(s1, s2):
    for ch in set(s2):
        if s1.count(ch) < s2.count(ch):
            return False
            
    return True

print(scramble('katas', 'steak'))
print(scramble('cedewaraaossoqqyt', 'codewarst'))
