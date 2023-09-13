package usl.amaruk.presenter
/*
class Hungarian {

    companion object {

        val poems = mutableMapOf<String, String>().also {

            it["1"]= "<b>Hold</b><br><br>Nagy változások<br>azért vannak a földön,<br>mert sok a halott -<br>csak a Hold őszi éjen<br>soha nem változik."

            it["2"]= "<b>Égbolt</b><br><br>Halványkék égbolt,<br>felhők el nem takarják -<br>bárcsak bensőmben,<br>lelkemnek legmélyén<br>így ragyogna fel az ég."

            it["3"]= "<b>Megérint a pillanat</b><br><br>Hőség, rekkenő<br>rizsföldön izzik a lég –<br>s légyen akármi,<br>azért rendületlenül<br>műveljük földjeinket!"

            it["3.Okuden"]= "<b>A drágakő</b><br><br>Felhős a lélek,<br>homályosak a szavak,<br>e drágakövek, -<br>ha a lélek ragyogó,<br>ragyognak szavaink is."

            it["4"]= "<b>Szélfútta levelek</b><br><br>Mily sok eső kell,<br>hogy minden egyes<br>törpejuhar levélke<br>piros legyen – de egy szélfúvás<br>mind leszakítja."

            it["5"]= "<b>Megérint a pillanat</b><br><br>Akkor érted meg,<br>hogy mi az élet, mikor<br>ó, nézed az esőt,<br>amint mossa a követ,<br>s már látod a változást!"

            it["6"]= "<b>Megérint a pillanat</b><br><br>Ha bűneimre<br>sokszor visszagondolok,<br>soha nem fogom<br>hibáztatni, vádolni<br>kínjaimért az eget."

            it["7"]= "<b>Megérint a pillanat</b><br><br>Tenger sok hibát<br>követ el minden ember<br>a nagyvilágban,<br>ezért hát túlzottan<br>ne aggódjunk emiatt."

            it["8"]= "<b>Barátság</b><br><br>Ha van barátság,<br>akkor válik igazzá,<br>ha rámutatunk<br>egymás hibáira,<br>lelkünk így gazdagodik."

            it["9"]= "<b>Fenyő a sziklán</b><br><br>Vihar dúlja fel<br>lelkünket e világban -<br>de légy olyan, mint<br>sziklába kapaszkodó<br>fenyő: állj s meg se rezzenj!"

            it["10"]= "<b>Hullám</b><br><br>Nézd a hullámot:<br>hol viharos, hol nyugodt,<br>pontosan olyan,<br>úgy változik szüntelen,<br>mint az emberi lélek."

            it["11"]= "<b>Megérint a pillanat</b><br><br>Ha gazdag leszel,<br>s gondok nem gyötörnek már,<br>könnyen mulasztod<br>mindazt, mi emberként<br>legfőbb kötelességed."

            it["12"]= "<b>Testvérek</b><br><br>Családi viszály<br>szétfújhatja a házunk,<br>de múlik a baj,<br>ha családfánk ágai<br>rendre ég felé törnek."

            it["13"]= "<b>Lélek</b><br><br>Bármilyen dolog<br>történjen meg bármikor<br>e földi létben,<br>ám az emberi lélek<br>maradjon mindig gazdag."

            it["14"]= "<b>Orvosság</b><br><br>Orvosságot nyelsz,<br>sok gyógyszert nyakra-főre –<br>ehelyett inkább<br>nap mint nap vedd komolyan,<br>hogy törődj a testeddel!"

            it["15"]= "<b>Megérint a pillanat</b><br><br>Kihalt harcmezőn<br>szúnyogzúgás zavar fel,<br>s virrasztás közben<br>éjjel arra gondolok:<br>itt nyugszik sok harcosunk!"

            it["15.Okuden"]= "<b>Az öregek</b><br><br>Botra hajolva,<br>arra rátámaszkodva<br>ballag lefelé<br>már ezer éves múlttal<br>háta mögött – sok öreg."

            it["16"]= "<b>A nevelés</b><br><br>Legyen nevelő<br>mindaz, ki alkalmas rá,<br>segítsd őket,<br>adj erőt, hitet nekik,<br>hazám ékes szekfűi!"

            it["16.Okuden"]= "<b>A gyermek</b><br><br>Még nem is tudom,<br>hogy a gondolat vagy tett,<br>melyik fontosabb,<br>de azt tudom, gyönyörű<br>ez a gyermeki lélek!"

            it["17"]= "<b>Vízre hulló virágok</b><br><br>Tónak felszínén<br>növő virágok<br>mindig boldoggá tesznek,<br>mert a vízre hullva<br>ott lebegnek még tovább."

            it["18"]= "<b>Szentjánosbogár</b><br><br>Nádi levelek<br>sűrűjében megbúvó<br>szentjánosbogár<br>lám, tavon tükröződő<br>teliholdat utánoz."

            it["19"]= "<b>Drágakő</b><br><br>Legszebb drágakő<br>elveszíti a fényét,<br>a ragyogását<br>egy apró piszok miatt,<br>ha nem vigyázol reá."

            it["20"]= "<b>Megérint a pillanat</b><br><br>Ne gyorsaságban<br>versenyezzetek soha -<br>jobb, ha haladtok<br>apránként az úton<br>s úgy tanultok, gyerekek!"

            it["21"]= "<b>Szülők iránti kötelesség</b><br><br>Nyugtalan világ,<br>melyben zajlik életünk,<br>de ne feledd<br>örök feladatod:<br>gondoskodj szüleidről!"

            it["22"]= "<b>Füvek</b><br><br>Égetni való<br>vad gyomnövények között<br>találunk néha<br>- ha okosan keresünk -<br>gyógyító füveket is."

            it["23"]= "<b>Végzős diák</b><br><br>Ha ma megkapod<br>végső bizonyítványod,<br>tán úgy gondolod,<br>tanulásnak már vége…<br>De nem, tanulj örökké!"

            it["24"]= "<b>Szegfűk</b><br><br>Egyforma magok,<br>amiket elültettem,<br>s gondoztam egyre,<br>ám virágzó szegfűim<br>közt nincs két egyforma sem."

            it["25"]= "<b>Vízesés</b><br><br>Kemény kőszikla<br>úgy felerősítette<br>vízesés hangját,<br>víz zúgását sem halljuk,<br>csak a szikla robaját."

            it["26"]= "<b>A víz</b><br><br>Bármelyik edény<br>alakját felvenni kész<br>a rugalmas víz,<br>de ereje olyan nagy,<br>hogy sziklán is áthatol."

            it["27"]= "<b>Füvek</b><br><br>A japánkomló<br>visszataszító növény,<br>mindenre képes<br>burjánzó gyökere -<br>megfojt mindent, mit ültettél."

            it["28"]= "<b>Az öregember</b><br><br>Lóistállóban<br>ápolásban segített<br>az öregember,<br>de most mégis elém jött,<br>hogy illendőn fogadjon."

            it["28.Okuden"]= "<b>Múltidézés</b><br><br>Hegyeknek mélyét,<br>szigeteknek széléig<br>jó felkeresni,<br>de hát sok-sok embernek<br>ismeretlen e világ."

            it["29"]= "<b>Magányos fa</b><br><br>Gondolatok közt<br>nézem e magányos fát,<br>oly egyedül él!<br>Emberek között is van<br>olyan, kit magára hagytak…"

            it["30"]= "<b>Látogató a hófúvásban</b><br><br>Épp most érkezett<br>szakadó hóesésben<br>az öregember –<br>ide, tűz közelébe<br>hívom kedves vendégem."

            it["30.Okuden"]= "<b>Az út</b><br><br>Minél hamarabb<br>lám, el kell készíteni <br>egy útmutatót,<br>melyben az ÉLETÚTról<br>magasabb szinten szólunk."

            it["31"]= "<b>Írás</b><br><br>Csinos írásjegy,<br>vagy kimondottan csúnya?<br>Olvassuk könnyen,<br>a legfontosabb az, hogy<br>legyen áttekinthető."

            it["32"]= "<b>Szülők</b><br><br>Hogyha eléred<br>már az idős korodat,<br>bizony akkor is<br>szüleid szívük mélyén<br>kisgyermeknek éreznek."

            it["33"]= "<b>Megérint a pillanat</b><br><br>Lám, az öregek<br>elhagyják otthonukat,<br>nem késlekednek -<br>tiszta szívvel indulnak,<br>hogy megvédjék a hazát!"

            it["33.Okuden"]= "<b>A sziget</b><br><br>Mögöttem van már<br>a messziről látszódó,<br>keresett sziget,<br>eveztem csónakommal, –<br>ó, mikor történhetett?"

            it["34"]= "<b>Madarak</b><br><br>Bármily magasan<br>repülnek a madarak<br>nagy kéklő égen,<br>tudják merre találják,<br>s nem feledik fészküket."

            it["35"]= "<b>Szépírás</b><br><br>Ha megfigyeled,<br>hogyan tanulnak írni<br>a kisgyerekek,<br>megtanulhatod, hogyan<br>kell sikerrel tanulni."

            it["36"]= "<b>Szegfűk</b><br><br>Iskoláslányok,<br>ha együtt összegyűlnek,<br>olyan szépek ők,<br>mint virágzó szegfűk<br>csillogó harmatcseppel."

            it["37"]= "<b>Őszinte becsület</b><br><br>Csak egy őszinte<br>és becsületes lélek<br>képes megríkatni<br>a gonosz ördögöt is<br>lám, a mi világunkban."

            it["38"]= "<b>Megérint a pillanat</b><br><br>Csak munka után,<br>amit bevégeztél,<br>akkor láss hozzá<br>gyönyörködni, élvezni<br>csodás virágaidat."

            it["39"]= "<b>Megérint a pillanat</b><br><br>Emberek gyakran<br>nem törődnek magukkal,<br>csakis másokról,<br>többiekről beszélnek –<br>ilyen világban élünk."

            it["40"]= "<b>Hegycsúcs</b><br><br>Ha kék egekig<br>magasodó hegycsúcshoz<br>akarsz feljutni,<br>mindenképpen megmászni,<br>egy utat mindig találsz."

            it["41"]= "<b>Megérint a pillanat</b><br><br>Előbb szedd össze<br>jól gondolataidat,<br>és csak utána<br>írd le vagy meséld is el<br>mindezt más embereknek."

            it["42"]= "<b>Megérint a pillanat</b><br><br>Beteljesülnek<br>az elképzeléseid?<br>Akkor se feledd:<br>maradj te mindig szerény,<br>és légy tisztelettudó!"

            it["43"]= "<b>Megérint a pillanat</b><br><br>Sokat kell tennünk,<br>sok gondolat terheli<br>porhüvelyünket,<br>ezért hát tudd a mércét,<br>és ne vállald túl magad."

            it["44"]= "<b>Hó borította fenyő</b><br><br>Fenyőcske csúcsa –<br>hatalmas hó borítja<br>gyenge ágait.<br>Mentsd meg őt mielőbb,<br>takarítsd le a havat."

            it["45"]= "<b>Megérint a pillanat</b><br><br>Tágas nagyvilág<br>s benne sok bátor vitéz,<br>értünk harcoltak,<br>hazánkért, így nevüket<br>őrizzük mindörökké!"

            it["45.Okuden"]= "<b>Megérint a pillanat</b><br><br>Tanulás útja<br>előtt áll a gyermekünk<br>sehol senki sincs,<br>ki ellensége volna,<br>kit legyőzni kellene."

            it["46"]= "<b>A ventilátor</b><br><br>Déli hőségben<br>aki papírforgóval<br>hűsíti magát,<br>annak be kell kapcsolni<br>egy jó kis ventilátort."

            it["46.Okuden"]= "<b>A ló</b><br><br>Hosszú ideje <br>nevelt lovam egyre öregszik –<br>sajnáljuk nagyon,<br>vigyázunk rá, míg lehet,<br>erőben, egészségben."

            it["47"]= "<b>A lélek</b><br><br>Oly elbűvölő,<br>szép az emberi lélek,<br>ha akaratlan,<br>tisztán megmutatkozik,<br>feltárul dísztelenül."

            it["48"]= "<b>Figyelmeztetés</b><br><br>Folytasd, csak folytasd<br>teljes erővel,<br>még ha nehéz, akkor is –<br>csak így érsz el valamit<br>az emberi világban."

            it["49"]= "<b>Az oszlop</b><br><br>Parányi dolgok<br>sose bántsák lelkedet,<br>állj meg szilárdan,<br>ne inogj, légy a házad<br>tartóoszlopa!"

            it["49.Okuden"]= "<b>Íróasztal</b><br><br>Szabadidődnek,<br>úgy látod, híjával vagy.<br>Hát még akkor se<br>tűrd íróasztalodon<br>a port és a szemetet."

            it["50"]= "<b>Figyelmeztetés</b><br><br>Amikor tévedsz<br>és fűt-fát összehordasz<br>igaz szók helyett,<br>tudd: világunkban, sajnos<br>gyökeret eresztenek."

            it["51"]= "<b>Figyelmeztetés</b><br><br>Földi világban<br>folyón leúszó hajó,<br>könnyen felborul,<br>így mi is. Fogd erősen<br>azt a kormányrudat!"

            it["52"]= "<b>Figyelmeztetés a drágakövekről</b><br><br>Kevés drágakő,<br>mit értékesnek tartunk,<br>s bizony közöttük<br>alig találunk olyat,<br>mi teljesen hibátlan."

            it["53"]= "<b>Az utazásról</b><br><br>Utamat járom,<br>s fejem fűpárnán pihen -<br>ekkor mar a kín,<br>hogy ilyen alkalmakkor <br>nem törődöm a néppel."

            it["53.Okuden"]= "<b>Figyelmeztetés a kerülőútról</b><br><br>A fehér felhők<br>irányába kell tartanunk.<br>Világunk útja,<br>emberek igaz útja:<br>az ősi Sikisima.<br>(Sikisima: Japán egyik ősi neve – a ford. megj.)"

            it["54"]= "<b>Jóakarat</b><br><br>Hazádért bőszen<br>ölöd ellenségedet,<br>de soha ne feledd,<br>mindezt kik miatt teszed,<br>őket óvd s féltőn szeresd!"

            it["54.Okuden"]= "<b>Megérint a pillanat</b><br><br>Bizony akkor is,<br>ha a napos oldalon<br>előre haladsz,<br>vigyázz, mert megbotolhatsz<br>lám, széles e világban."

            it["55"]= "<b>Orvosság</b><br><br>Szép hazánk miatt<br>azt szeretném leginkább,<br>aki idős mind<br>kapjon olyan gyógyszert,<br>melytől halhatatlan lesz."

            it["56"]= "<b>Az öregemberek</b><br><br>Öregemberek<br>elismétlik ugyanazt -<br>ósdi szövegek,<br>de lám, szavaik közé<br>sok bölcs tanács is vegyül"

            it["56.Okuden"]= "<b>A hónapok és a napok</b><br><br>Hosszú napokat,<br>hónapokat kell várni,<br>nagy türelemmel,<br>hogy amit elgondoltunk,<br>mind beteljesüljenek."

            it["57"]= "<b>Este</b><br><br>Besötétedik...<br>ilyenkor egyre jobban<br>sajnálja lelkem,<br>hogy ma minden percemet<br>naplopóként töltöttem."

            it["58"]= "<b>A szülői szív</b><br><br>Tavaszi éjen,<br>az égő csatamezőn<br>gyermekeiért<br>aggódó fácánnak<br>álma fájdalmas, nehéz."

            it["59"]= "<b>Orvosság</b><br><br>A szívből jövő<br>jó tanács olyan fontos,<br>mint egy orvosság,<br>mely óriási segítség<br>még egészségesnek is."

            it["60"]= "<b>Megérint a pillanat</b><br><br>E világunkban<br>még ki mindig elfoglalt,<br>lám, talál időt,<br>hogy azt az utat járja,<br>amit igazán szeret."

            it["61"]= "<b>Nyári füvek</b><br><br>Ó, nyári füvek,<br>lám, olyanok vagytok, mint<br>e változó világ:<br>hiába irtunk, vágunk,<br>mégis nőtök örökké."

            it["62"]= "<b>A lélek</b><br><br>Amikor lelkünk<br>egyre jobban elgyengül,<br>nagyobb a veszély,<br>mintha ellenség lenne<br>most közvetlen mellettünk."

            it["63"]= "<b>Ösvény</b><br><br>Rizsföldek között,<br>hegyek alján, part mentén<br>szűk ösvény vezet,<br>ám előzékeny emberek<br>utat adnak egymásnak."

            it["63.Okuden"]= "<b>A lélek</b><br><br>Néha megesik, <br>hogy az emberi lélek<br>mely oly zavaros,<br>egyszerre úgy kitisztul,<br>akár a hegyi forrás."

            it["64"]= "<b>Földműves öregek</b><br><br>Mindenki harcol,<br>csatában védi a hont,<br>csak az öregek,<br>csak ők vannak most otthon,<br>s gondozzák a földeket."

            it["64.Okuden"]= "<b>Megérint a pillanat</b><br><br>Iszonokami<br>sintó szentélyében most<br>régi példáról <br>kérdezünk, de ez mégis<br>megszab egy új világot."

            it["65"]= "<b>Nap</b><br><br>A felkelő nap<br>reggeli sugarai<br>olyan üdítők –<br>szeretném, ha a lelkem<br>épp ugyanígy ragyogna."

            it["66"]= "<b>Esős évszak</b><br><br>Sokszor gondolom,<br>népemnek milyen nehéz<br>nyirkos tatamin,<br>mely nyáron nem szárad ki,<br>tölteni az éjszakát."

            it["66.Okuden"]= "<b>A gyermek</b><br><br>Az édesanya,<br>a szülők oltalmában<br>a kisgyermek<br>megtanulja az utat,<br>s bátran halad előre."

            it["67"]= "<b>Emlékezés egy hideg éjszakára</b><br><br>Egyszer éjszaka<br>viharra riadtam fel<br>kinn a tengeren -<br>milyen nehéz, - gondoltam -<br>jaj, kunyhók lakóinak!"

            it["67.Okuden"]= "<b>Szülők</b><br><br>Az édesanya,<br>ó, szülői nevelés<br>értéke, kincse<br>az évek múlásával<br>énünk részévé válik."

            it["68"]= "<b>Drágakő</b><br><br>Arra gondolok,<br>miért nem csillog-villog<br>e fehér gyöngysor, –<br>bizony elfelejtettem:<br>meg kéne tisztítani!"

            it["69"]= "<b>Óra</b><br><br>Az egyik siet,<br>a másik folyton késik,<br>mutatóik is<br>oly sokfélék lehetnek,<br>oly sokban különböznek."

            it["70"]= "<b>Az út</b><br><br>Ha gyorsabban mész,<br>hamarabb jutsz a célba.<br>De gondold meg jól:<br>veszélyes úton ne járj,<br>a csábító látszat csal."

            it["71"]= "<b>Megérint a pillanat</b><br><br>Mielőtt mennél,<br>válasszad ki pontosan,<br>mikor indulsz el,<br>mi a legalkalmasabb,<br>különben veszély vár rád."

            it["72"]= "<b>A lélek</b><br><br>Ó, milyen nagy kár<br>elfeledni őszinte,<br>szelíd gyermeki<br>lelkünknek tisztaságát,<br>hamvas egyenességét!"

            it["73"]= "<b>A gyermek</b><br><br>Az ifjú bambusz<br>a kertben egyenesen<br>nőjön, sudáran,<br>bár tudjuk, könnyen hajlik,<br>akármelyik irányban."

            it["74"]= "<b>Felhőre hasonlító virágzó fa</b><br><br>Vadcseresznyefa,<br>ó, de szépen virágzik<br>kis fenyők között,<br>ha az égre felnézünk,<br>felhőként látjuk viszont."

            it["75"]= "<b>Nyáron a házakban</b><br><br>Folytonos hőség…<br>városi lakásokban<br>kibírhatatlan,<br>ablakokon nem jut át<br>még szél fúvása sem."

            it["75.Okuden"]= "<b>A családi nevelés</b><br><br>Ha egy kis bambusz<br>életével törődünk,<br>jusson eszünkbe:<br>a családi nevelést<br>ó, ne hanyagoljuk el!"

            it["76"]= "<b>A szülők iránti kötelesség</b><br><br>Édes szüleink<br>iránti gondoskodás,<br>így kezdődik el<br>az emberi világban<br>őszinte tisztesség"

            it["77"]= "<b>A szülők lelke</b><br><br>Édes szüleink<br>lelkét akkor érezzük,<br>értjük igazán,<br>amikorra már mi is<br>jócskán megöregedtünk."

            it["78"]= "<b>A családi nevelés</b><br><br>Az édes szülők<br>kertjében ha nevelkedsz,<br>csupa apróság,<br>mit megtanulsz, ám mindez<br>jól jön a nagyvilágban."

            it["79"]= "<b>A virágok akarata és szándéka</b><br><br>Könnyen virágzik<br>harag, rosszallás nélkül,<br>minden tavasszal,<br>lám, ismétli ugyanazt –<br>áldott vadcseresznyefa."

            it["80"]= "<b>A por</b><br><br>Mikor nekilátsz,<br>hogy eltakaríts mindent,<br>bárhogy szeretnéd, <br>mást nem, csak a port tudod<br>onnan letörölgetni."

            it["80.Okuden"]= "<b>A tükör</b><br><br>Szaszaki levél<br>mellé helyezett tükör, –<br>szívem úgy érzi,<br>hogy e tükör emberek<br>lelkét teszi fényessé."

            it["81"]= "<b>Tanulás</b><br><br>Most már úgy bánom,<br>hogy még gyermekkoromban<br>arra gondoltam:<br>nincs értelme tanulni,<br>lusta voltam én hozzá."

            it["82"]= "<b>Emlékezés</b><br><br>Mindig izgatott:<br>vajon hogyan él a nép?<br>Derűs napsütés,<br>legyen, vagy borult idő -<br>munkálkodnak szüntelen."

            it["82.Okuden"]= "<b>Cselekedet</b><br><br>Nem könnyű dolog<br>elérni azt nekünk itt,<br>e világunkban,<br>hogy emberhez méltóan,<br>éljünk és cselekedjünk."

            it["83"]= "<b>Az út</b><br><br>Messzire tartasz?<br>Azt az utat válasszad,<br>melyen embernek kell menni,<br>mert azt hiszem, hogy jó lesz,<br>veszély tán nem fenyeget."

            it["84"]= "<b>Megérint a pillanat</b><br><br>Hónapok, évek<br>szállnak, mint repülő nyíl,<br>melyet kilőttek.<br>Ezért tégy mindent gyorsan,<br>hogy végezhess sikerrel."

            it["85"]= "<b>Csónak a nádasban</b><br><br>A kis csónak, –<br>mint tű a szövetben, –<br>evezőivel<br>lassan halad előre<br>burjánzó nádak között."

            it["86"]= "<b>Az út</b><br><br>Ha félúton jársz<br>és persze megpihensz ott,<br>mert rögös az út,<br>akkor is folytatnod kell:<br>lásd, tanulni érdemes."

            it["87"]= "<b>Megérint a pillanat</b><br><br>Ha életedben<br>úgy leszel magas korú,<br>hogy tétlen maradsz,<br>hogy semmit nem is csinálsz,<br>úgy élned nem érdemes."

            it["88"]= "<b>Az emberek</b><br><br>Ha bármi marad<br>és nem változik semmi,<br>ahogy szeretnénk,<br>ám magunkra fordítva<br>a mi életünk lesz jó."

            it["89"]= "<b>A lélek</b><br><br>Mikor szélcsend van,<br>épp akkor kell tartani<br>a kapitánynak<br>a legfigyelmesebben<br>hajójának kormányát."

            it["90"]= "<b>Az ú​t</b><br><br>Mikor az úton<br>a veled haladóktól<br>kissé lemaradsz,<br>irányt soha ne tévessz,<br>folytasd a helyes utat."

            it["91"]= "<b>Megérint a pillanat</b><br><br>Szegfű virága,<br>ha nem rázzák le róla<br>a hűs harmatot,<br>ó, bármelyik irányban<br>eldőlhet, elhajolhat."

            it["92"]= "<b>A drágakő</b><br><br>Nagyon sok ember<br>drágaköveket választ,<br>ám valamelyik<br>ékkövön sérülés van --<br>Ilyen a mi világunk."

            it["93"]= "<b>A szülői szív</b><br><br>A szülői szív,<br>ha az utódja felnő,<br>kicsinek érzi<br>még akkor is gyermekét,<br>bár tudja, független már."

            it["94"]= "<b>A szülők</b><br><br>Önállóan élsz,<br>de akkor se feledd el,<br>emlékezz mindig<br>szüleid áldására,<br>nevelő szavaira."

            it["95"]= "<b>A bánya</b><br><br>A még fel nem tárt<br>aranytól virágzó hegy<br>kincse nem látszik,<br>ha nem hozza fel senki,<br>hogy látnánk ragyogását?"

            it["96"]= "<b>Megérint a pillanat</b><br><br>Ha a sztrádára<br>hajtasz, s utad ott vezet,<br>óvatos szívvel<br>haladj: a mi világunk<br>buktatókkal van tele."

            it["97"]= "<b>Visszaemlékezés</b><br><br>A nagyvilágban,<br>amelyben léteznünk kell,<br>számtalan dolog<br>megzavarja lelkünket<br>vigyázzunk, ne hulljon szét!"

            it["98"]= "<b>A lélek</b><br><br>Tágas világunk<br>már-már összemosódik,<br>mondják, kisebb lett,<br>de inkább egyes emberek<br>nézőpontja szűkült be."

            it["99"]= "<b>Öregek</b><br><br>Lám, mérséklettel<br>is mehetünk az úton,<br>ha jól vigyázunk,<br>ügyelünk a testünkre,<br>óvjuk egészségünket."

            it["100"]= "<b>A családfő</b><br><br>Ha a ház ura,<br>a családfő szálfaként <br>mozdulatlanul<br>áll, virágzik örökké<br>családja, háza népe."

            it["100.Okuden"]= "<b>A gyermek</b><br><br>Nyíltan kimondja,<br>közli gondolatait<br>őszinte szívvel --<br>ilyen a gyermek lelke:<br>őszinte ártatlanság."

            it["101"]= "<b>Figyelmeztetés</b><br><br>A politikában<br>az ország szolgálata:<br>teljes erőből<br>mindent úgy tegyenek meg,<br>hogy igaz hazánk legyen."

            it["102"]= "<b>A tanár</b><br><br>Aki a tudást,<br>az iskolázottságot<br>választotta ki,<br>érezzen hálát mindig<br>a tanítója iránt."

            it["103"]= "<b>Napilapok</b><br><br>Forrásként sokan<br>olvasnak újságokat,<br>de ott nem írják,<br>világban mi zajlik<br>mily hullám zúdul reánk."

            it["103.Okuden"]= "<b>A szépírás</b><br><br>A kicsi gyerek<br>napról napra gyakorol,<br>a tanulásnak<br>meglesz az eredménye:<br>szép a leírt írásjegy."

            it["104"]= "<b>A víz</b><br><br>A forrás tiszta,<br>de ha az iszapos folyó<br>medrébe zúdul,<br>sajnos a tiszta víz is<br>végül beszennyeződik."

            it["105"]= "<b>A szarvasmarha</b><br><br>A szarvasmarha<br>súlyos szekeret vonszol<br>testi erővel,<br>nem siet, lassan halad, –<br>lám, nem botlik meg soha."

            it["106"]= "<b>Égi és földi istenek</b><br><br>Emberi szemnek<br>láthatatlan istenek<br>odafordulnak,<br>hol nincs szégyen, ott tárul fel<br>az emberi lélek igazsága."

            it["107"]= "<b>Megérint a pillanat</b><br><br>Gondolatod az,<br>hogy az ügyeid állnak<br>és nem haladnak,<br>de valójában magad<br>voltál lusta és hanyag."

            it["108"]= "<b>A barátok</b><br><br>Egymást segítik<br>meghitt, mély szeretetben,<br>ők a barátok,<br>érzésük a nagyvilágban<br>legyen legnagyobb erő."

            it["109"]= "<b>Öreg fenyőfa</b><br><br>Ezeréves fa,<br>kertünk vén fenyőfája,<br>óvlak, védlek én,<br>hogy sokáig élhess még,<br>közöttünk élhess tovább."

            it["110"]= "<b>Földművesek</b><br><br>Mag ültetéstől<br>az aratás végéig<br>a szántóvetők<br>szakadatlan művelik<br>a hegyi rizsföldeket."

            it["110.Okuden"]= "<b>A családi nevelés</b><br><br>Féltő szeretet<br>vegye körül a szegfűt,<br>nevelgessük őt<br>kertünkben nagy gondosan,<br>és ne hanyagoljuk el."

            it["111"]= "<b>A fenyő</b><br><br>Nagy hóesésben,<br>komoly viharban tűr,<br>állja a próbát,<br>ezért újra meg újra<br>magasra értékeljük."

            it["112"]= "<b>Az ország</b><br><br>Felkarolni jót,<br>elvetni mindazt, mi rossz<br>azt szeretnénk,<br>ha országunk felérne<br>idegen országokhoz."

            it["113"]= "<b>Megérint a pillanat</b><br><br>A nagyvilágban<br>ha elterjed hírneved,<br>ismer mindenki,<br>maradj akkor is szerény,<br>így ragyog fel személyed."

            it["114"]= "<b>A csiga</b><br><br>Milyen a világ?<br>Ez érdekli a csigát,<br>mikor kibújik:<br>körül akar nézni jól<br>a széles nagyvilágban."

            it["115"]= "<b>Az út</b><br><br>A mi világunk<br>tele van veszélyekkel,<br>ezért jól vigyázz:<br>csakis az igaz úton<br>haladj mindig előre."

            it["116"]= "<b>A kincs</b><br><br>A mi világunk<br>arra szólít: egyedül<br>állj talpra fejleszd<br>képességed, tudásod:<br>ez az igazi kincsed."

            it["117"]= "<b>A diák</b><br><br>A mi világunk,<br>viharai ha dúlnak,<br>nyugodt lélekkel<br>fordítsa a figyelmét<br>a tanulmányozásra."

            it["118"]= "<b>Megérint a pillanat</b><br><br>A mi világunk<br>már olyan természetű,<br>nem szabad késni,<br>különben lemaradunk,<br>s nem haladunk előre."

            it["119"]= "<b>A cselekedet</b><br><br>A mi világunk<br>legyen olyan, amelyben<br>a vezetőink<br>összes cselekedete<br>ó, igazul hangozzék."

            it["120"]= "<b>A cselekedet</b><br><br>Ha nem őszinte,<br>igaz munkát végeznél,<br>gondot okozna<br>másokat tanítani<br>lám, a mi világunkban."

            it["121"]= "<b>Őszinte érzelmek</b><br><br>Tengereken túl,<br>mindenütt a világon<br>minden azonos,<br>akkor miért zúdul fel<br>gyakran hullámok szele?"

            it["122"]= "<b>Megérint a pillanat</b><br><br>Éji hullámok<br>verdesik a partokat,<br>közben elterül,<br>kínok között kifekszik,<br>s mégis virul a szegfű."

            it["123"]= "<b>A játék</b><br><br>Ne hanyagold el<br>kötelességed, munkád!<br>Még akkor se tedd,<br>ha szíved játék vonzza,<br>ha szórakozni szeretsz."

            it["124"]= "<b>Megérint a pillanat</b><br><br>Lelkedre vigyázz,<br>néha-néha figyelj rá,<br>mert ha nem teszed,<br>fájdalmat, bajt okozol."

            it["125"]= "<b>A tükör</b><br><br>Én is szeretnék<br>egyre jobb és jobb lenni,<br>ezért hát mások<br>felhőtlen lelkében<br>ragyogjak fel tükörként!"

        }
    }
}
*/
