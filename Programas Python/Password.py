
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
    obel=s[len(t):-len(t)]
    if t in obel:
        return True
    return False
def Password(s):
    for i in range(len(s)//2):
        t = s[:i]
        if Suffix(t,s) and Preffix(t,s) and Obelix(t,s):
            return t
    return "Just a legend"

s = input()
print(Password(s))

    

