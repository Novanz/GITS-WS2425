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
title: Grundlagen der IT-Sicherheit
subtitle: Aufgabenblatt 3
author: Anatoly Naprimerov 275093,  Luisa Schmid 275300
date: 13.11.2024
---

## Aufgabe 1 + 2

[Source](https://github.com/Novanz/GITS-WS2425/blob/main/B3/src/Vignere.java)

## Aufgabe 3

1. Wie groß ist der Schlüsselraum? Das bedeutet wie viele möglich Schlüssel gibt es?

	 `26⁴ = 456976`

1. Was wäre, wenn der Schlüssel doppelt so viele Stellen hätte, also acht Stellen? 
	 `26⁸ = 208827064576`

1. Könnten Sie einen achtstelligen Schlüssel immer noch brechen? 
	 `i.A. ja`

1. Wie groß wäre der Schlüsselraum bei einem vierstelligen Schlüssel, der nicht nur aus A-Z, sondern aus {a-z, A-Z} besteht, also aus doppelt so vielen Zeichen?
	 `52⁴ = 7311616`
	
1. Argumentieren Sie, was die Sicherheit eines Schlüssels mehr verbessern würde: Ein größeres Alphabet (d.h. mehr Möglichkeiten pro Stelle) oder mehr Stellen. Wie berechnen Sie die Anzahl möglicher Permutationen? Die Änderung welches Parameters lässt die Anzahl der Permutationen schneller steigen?
	 `Mehr Stellen, da auf diese Weise wächst die Anzahl möglicher Permutationen exponenziell.`
	
1. Wieso kann eine EC-Karte dennoch (einigermaßen) sicher angesehen werden, obwohl eine PIN lediglich vierstellig und aus den Zeichen 0-9 aufgebaut ist?
	 `Weil die EC-Karte nach 3 Fehlversuchen gesperrt wird.`
