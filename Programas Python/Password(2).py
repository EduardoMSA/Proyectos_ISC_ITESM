
# coding: utf-8

# In[ ]:


def Suffix(t,s):
    if t==s[:len(t)]:
        return True
    return False
def Preffix(t,s):
    if t==s[-len(t):]:
        return True
    return False
def Obelix(t,s):
    obel=s[1:-1]
    if t in obel:
        return True
    return False
def Password(s):
    for i in range(len(s)-1,0,-1):
        t = s[:i]
        if Suffix(t,s) and Preffix(t,s) and Obelix(t,s):
            return t
    return "Just a legend"

s = input()
print(Password(s))

