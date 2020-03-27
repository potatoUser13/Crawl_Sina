import bs4
import requests
import re
import pymysql
import datetime as dt

from bs4 import BeautifulSoup

#获得当前页面
def getHtmlText(url):
    try:
        hd = {"user-agent":"Mozilla/5.0 "}
        r = requests.get(url,timeout=30,headers=hd)
        r.raise_for_status()
        r.encoding = r.apparent_encoding
        print("h")
        return r.text
    except:
        return "error requests"

def fillUnivList(ulist,hotlist,html):
    soup = BeautifulSoup(html, "html.parser")
    for tr in soup.find('tbody').children:
        Str_tr = ""
        Str_tr = str(tr)
        if isinstance(tr, bs4.element.Tag):
            name = tr.find_all('a')
            try:
                pattern = r'<span>.*</span>'
                hotspot = re.search(pattern,Str_tr).group()[6:-7]
                print(hotspot)
                hotlist.append(hotspot)
            except:
                print("null")
            ulist.append(name[0].string)



def main():

    start_url = "https://s.weibo.com/top/summary?Refer=top_hot&topnav=1&wvr=6"
    infoList = []
    hotlist = []
    #处理页面
    url = start_url
    html = getHtmlText(url)
    fillUnivList(infoList,hotlist,html)
    hotlist.insert(0,"Top")
    #print(infoList)
    #print(hotlist)

    #print(len(infoList))
    #print(len(hotlist))
    #记录当前时间
    time = dt.datetime.now().strftime('%F %R')
    #数据存储进mysql
    db = pymysql.connect(host='localhost',
                             user='root',
                             password='wy654383369',
                             db='crawldata',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)
    cursor = db.cursor()

    for i in range(len(infoList)):
        print(i)
        name= infoList[i]
        hot = hotlist[i]
        url = "https://s.weibo.com/weibo?q=%23"+name+"%23&Refer=top"
        sql = "INSERT INTO crawlsina(name,hot,url,time) VALUES(%s,%s,%s,%s)"
        cursor.execute(sql, (name, hot,url,time))
        db.commit()  # 提交数据
    cursor.close()
    db.close()

main()






