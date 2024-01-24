![MPAndroidChart icon](https://github.com/MihaMlin/poraKolokvij/assets/99204980/bc45eb3e-56a9-4647-8a3e-05b58e5a0332)  
===============
## Uporaba MPAndroidChart v projektu
[Projekt StatisticsFragment](https://github.com/feri-segmentation-fault/saferoute-android/blob/main/app/src/main/java/com/segmentationfault/saferoute/fragment/StatisticsFragment.kt)

# Zakaj MPAndroidChart?
MPAndroidChart je knjižnica za risanje grafov v Android aplikacijah.  
Razvita je za enostavno vključevanje vizualnih elementov, kot so linije, stolpci in krogi.  
S svojo podporo za interaktivnost omogoča uporabnikom dotikanje, približevanje in pomikanje grafov za boljše raziskovanje podatkov.

## Prednosti  
1.  **Vizualizacija Podatkov:** Podpira razne vrste grafov, zato je primerna za vizualizacijo različnih podatkov.  
2.  **Prilagodljivost:** Izgled grafov lahko prilagodiš glede na izgled aplikacije (barva, velikost, oblika).  
3.  **Dokumentacija:** Dostop do [example projekta](https://github.com/PhilJay/MPAndroidChart/tree/master/MPChartExample) z jasnimi primer in dobra [dokumentacija](https://weeklycoding.com/mpandroidchart-documentation/).  

## Slabosti  
1. **Kompleksnost prilagodljivosti:** Doseči bolj specifične prilagoditve, je bolj zahtevno, potrebno je globje znanje knjižnice.
2. **Omejene podpora animacij:** Čeprav podpira animacije, so možnosti precej omejene.

## Licenca :page_facing_up:

Copyright 2020 Philipp Jahoda

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.  

## Uporabniki  
MPAndroidChart je izjemno priljubljena knjižnica med razvijalci Android aplikacij.  
Trenutno ima več kot 37 tisoč zvezdic (starred) in več kot 9,1 tisoč forkov (forked) na [GitHubu](https://github.com/PhilJay/MPAndroidChart).  

## Vzdrževanje projekta  
MPAndroidChart je aktivno vzdrževana knjižnica.  
Do zdaj je bilo izdanih 44 različic, pri čemer je najnovejša različica [3.1.0](https://github.com/PhilJay/MPAndroidChart/releases/tag/v3.1.0), ki je izšla 20. marca 2019.  
Do zdaj je k projektu prispevalu 69 različnih razvijalcev.

# Primer Uporabe  
**PIE CHART:** prikez prometnih nesreč za letne čase, po procentih.  
![PieChart Example](https://github.com/MihaMlin/poraKolokvij/assets/99204980/8d812d1f-0185-4c13-922c-9f747d8a7d18)

**LINE CHART:** prikaz raznih funkcij.  
![LineChart Example](https://github.com/MihaMlin/poraKolokvij/assets/99204980/29628337-4c85-4231-b185-39a5ecd07283)

**BAR CHART:** prikaz prometnih nesreč za letne čase, po številu.  
![BarChart Example](https://github.com/MihaMlin/poraKolokvij/assets/99204980/734a90ae-f8d6-42b4-84a4-02715d8b5412)

# Kako bi vključili v lasten projekt?  
V našem projektu SafeRoute, delamo z podatki o prometnih nesrečah in zasedenostjo cest.  
Te podatke bi s pomočjo MPAndroidChart, lahko prikazali na grafih.
**Primeri:**  
1. Prikaz števila nesreč ob letnih časih, vremenskih pogojih, ...
2. Prikaz zasedenosti cest, ob določenih urah
