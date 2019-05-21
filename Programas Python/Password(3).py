
# coding: utf-8

# In[8]:


def Password(s):
    respuesta = ""
    for i in range(1,len(s)):
        if (s[i-1] != s[len(s)-1]) or (s[0]!=s[len(s)-i]):
            continue
        prefix = s[0:i]
        suffix = s[len(s)-i:len(s)]
        if prefix!=suffix:
            continue
        obelix = prefix in s[1:len(s)-1]
        if not obelix:
            continue
        respuesta = prefix
    if len(respuesta)<1:
        return "Just a legend"
    return respuesta
            
s = input()
print(Password(s))

