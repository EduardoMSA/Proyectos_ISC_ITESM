
# coding: utf-8

# In[13]:


def Password(s):
    for i in range(len(s)-1,0,-1):
        if (s[i-1] != s[len(s)-1]) or (s[0]!=s[len(s)-i]):
            continue
        prefix = s[0:i]
        suffix = s[len(s)-i:len(s)]
        if prefix!=suffix:
            continue
        obelix = prefix in s[1:len(s)-1]
        if not obelix:
            continue
        return prefix
    return "Just a legend"
            
s = input()
print(Password(s))

