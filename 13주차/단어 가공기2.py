import requests
from bs4 import BeautifulSoup

for i in range(103,122+1):
    target = '''https://alldic.daum.net/search.do?q=''' +'%c'%i+'''
    %20%EB%A1%9C%20%EC%8B%9C%EC%9E%91%ED%95%98%EB%8A%94%20%EB%8B%A8%EC%96%B4'''
    req = requests.get(target)
    html = req.text
    soup = BeautifulSoup(html,"html.parser")
    titles = soup.find_all("div",{"class":"search_type kuek_type"})
    for title in titles:
        
        eng = title.find("a")
        kors = title.find_all("daum:word")

        eng = str(eng)
        eng = eng[eng.find(">")+1:]
        eng = eng[:eng.find("<")]

        kor = ""

        for tempkor in kors:
            tempkor = str(tempkor)
            tempkor = tempkor[tempkor.find(">")+1:]
            tempkor = tempkor[:tempkor.find("<")]
            kor += tempkor+"\\n"
        print("Data.add(new Word(\""+kor+"\",\""+eng+"\"));" )

