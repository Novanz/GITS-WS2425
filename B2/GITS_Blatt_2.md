---
papersize:
  - a4
fontsize:
  - 12pt
geometry:
  - margin=1in
fontfamily: 
header-includes:
  - \setlength\parindent{24pt}
title: Computernetzwerke 2
subtitle: Aufgabenblatt 1
author: Anatoly Naprimerov 275093,  Luisa Schmid 275300
date: 30.10.2024
---
\maketitle
\thispagestyle{empty} 
\clearpage 
\pagenumbering{roman} 
\clearpage 
\pagenumbering{arabic} 
\setcounter{page}{1}
## Aufgabe 1
    TODO: make scrot
SSID = **HFURZPraktikum** 
IP-Adresse **10.42.0.1** 
login = **01-30**
pass = **123**
- a. OK
- b. OK
- c. Nummer 1234 wählen, man hört "Hello world" Ansage
- d. 999 wählen, man hört sich selbst.
## Aufgabe 2
### a

```sh
ip -c a # make scrot

```
  
       
       TODO:
    Wie lautet der Name Ihrer WLAN-Karte? 
    
    Wie haben Siedies herausgefunden? 
    
    Tipp: Ihre WLAN-Karte hat keine zugewiesene IP-Adresse. Weswegen?

### b

https://www.geeksforgeeks.org/how-to-put-wifi-interface-into-monitor-mode-in-linux/
```sh
# airmon ist doof
# phy Gerätename herausfinden
sudo iw dev 
sudo iw phy phy1 interface add mon0 type monitor
sudo iw phy phy1 info 
sudo iw dev wlx8416f9189541 del # remove managed one
sudo ip link set mon0 up
# find right channel and switch to it
sudo iw dev mon0 set freq 2447
# optional capture 
sudo tcpdump -i mon0 -n -w wireless.cap
```

TODO:

    Was mussten Sie machen, damit der Monitor-Modus ungestört arbeiten konnte? 
    Weswegen? 
    Zeigen Sie die Ausgabe. 
    Wie lautete der Befehl zum korrekten Ausführen von airmon-ng? 
    Welche Parameter benutzten Sie?

### c

https://sandilands.info/sgordon/capturing-wifi-in-monitor-mode-with-iw

```sh
sudo ./airodump-ng mon0 --encrypt wep

```


    TODO:
    . Dokumentieren Sie: Auf welchem Kanal wird das Netzwerk ausgestrahlt. 
    Was können Sie aus der Ausgabe von airodump sonst noch herausfinden?
    Weswegen Sehen Sie die WLAN-Stationen auf allen Kanälen? 
    Was muss airodump hierfür machen?



## 3

### a
 Starten Sie den Monitormode mit dem richtigen Kanal erneut 
```sh
# find right channel and switch to it
sudo iw dev mon0 set freq 2447
```
