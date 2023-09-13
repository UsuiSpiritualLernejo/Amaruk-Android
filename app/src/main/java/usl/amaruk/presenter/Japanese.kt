package usl.amaruk.presenter
/*
class Japanese {

    companion object {

        val poems = mutableMapOf<String, String>().also {

            it["1"] = "<br>秋の夜の<br>月は昔に<br>かはらねど<br>世になき人の<br>多くなりぬる<br><br>(月)"

            it["2"] = "<br>あさみどり<br>澄みわたりたる<br>大空の<br>広きをおのが<br>心ともがな<br><br>(天)"

            it["3"] = "<br>暑しとも<br>いはれざりけり<br>にえかへる<br>水田にたてる<br>しづを思へば<br><br>(をりにふれて)"

            it["3.Okuden"] = "<br>曇りなき<br>心のそこの<br>しらるゝは<br>ことばのたまの<br>ひかりなりけり<br><br>(玉)"

            it["4"] = "<br>あまたたび<br>しぐれて染めし<br>もみじ葉を<br>ただひと風の<br>ちらしけるかな<br><br>(落葉風)"

            it["5"] = "<br>雨だりに<br>窪める石を<br>見ても知れ<br>かたき業とて<br>思ひすてめや<br><br>(をりにふれて)"

            it["6"] = "<br>天を恨み<br>人をとがむる<br>こともあらじ<br>わがあやまちを<br>思ひかへさば<br><br>(をりにふれて)"

            it["7"] = "<br>あやまたむ<br>こともこそあれ<br>世の中は<br>あまりに物を<br>思ひすぐさば<br><br>(をりにふれて)"

            it["8"] = "<br>あやまちを<br>諫めかはして<br>親しむが<br>まことの友の<br>こゝろなるらむ<br><br>(友)"

            it["9"] = "<br>あらし吹く<br>世にも動くな<br>人ごころ<br>いはほに根ざす<br>松のごとくに<br><br>(巌上松)"

            it["10"] = "<br>荒る>かと<br>見ればなぎゆく<br>海原の<br>波こそ人の<br>世に似たりけれ<br><br>(波)"

            it["11"] = "<br>家富みて<br>あかぬことなき<br>身なりとも<br>人のつとめに<br>おこたるなゆめ<br><br>(をりにふれて)"

            it["12"] = "<br>家の風<br>ふきそはむ世も<br>みゆるかな<br>つらなる枝の<br>茂りあひつゝ<br><br>(兄弟)"

            it["13"] = "<br>いかならむ<br>ことある時もつ<br>つせみの<br>人の心よ<br>ゆたかならなむ<br><br>(心)"

            it["14"] = "<br>いく薬<br>もとめむよりも<br>常に身の<br>やしなひ草を<br>つめよとぞおもふ、<br><br>(薬)"

            it["15"] = "<br>いくさ人<br>いかなる野辺に<br>あかすらむ<br>蚊の声しげく<br>なれる夜ごろを<br><br>(をりにふれて)"

            it["15.Okuden"] = "<br>つく杖に<br>すがるともよし<br>老人の<br>千年の坂を<br>こえよとぞおもふ、<br><br>(老人)"

            it["16"] = "<br>いさをある<br>人を教の<br>おやにして<br>おほしたてなむ<br>やまとなでしこ<br><br>(教育)"

            it["16.Okuden"] = "<br>思ふこと<br>つくろふことも<br>まだしらぬ<br>をさなこころの<br>うつくしきかな<br><br>(子)"

            it["17"] = "<br>池のおもに<br>のぞめる花の<br>うれしきは<br>ちりても水に<br>浮ぶなりけり<br><br>(水上落花)"

            it["18"] = "<br>いけのおもは<br>月にゆづりて<br>芦の葉の<br>しげみがくれに<br>ゆく蛍かな<br><br>(蛍)"

            it["19"] = "<br>いさゝかの<br>きずなき玉も<br>ともすれば<br>ちりに光を<br>失ひにけり<br><br>(玉)"

            it["20"] = "<br>いちはやく<br>進まむよりも<br>怠るな<br>学びの道に<br>たてるわらはべ<br><br>(をりにふれて)"

            it["21"] = "<br>いとまなき<br>世にはたつとも<br>たらちねの<br>親につかふる<br>道な忘れそ<br><br>(孝)"

            it["22"] = "<br>いぶせしと<br>思ふなかにも<br>えらびなば<br>薬とならむ<br>草もあるべし<br><br>(草)"

            it["23"] = "<br>今はとて<br>学のみちに<br>おこたるな<br>ゆるしの文を<br>えたるわらはべ<br><br>(卒業生)"

            it["24"] = "<br>色々に<br>咲きかはりけり<br>おなじ種<br>まきて育てし<br>撫子の花<br><br>(瞿麦)"

            it["25"] = "<br>岩がねに<br>せかりざりせば<br>滝つ瀬の<br>水のひゞきも<br>世にはきこえじ<br><br>(滝)"

            it["26"] = "<br>器には<br>したがひながら<br>いはがねも<br>とほすは水の<br>ちからなりけれ<br><br>(水)"

            it["27"] = "<br>うとましと<br>思ふむぐらは<br>ひろごりて<br>植ゑてし草の<br>根はたえにけり<br><br>(草)"

            it["28"] = "<br>うまごにや<br>たすけられつゝ<br>いでつらむ<br>われを迎へて<br>たてる老人<br><br>(翁)"

            it["28.Okuden"] = "<br>山の奥<br>しまの果てまで<br>たづねみむ<br>世に知られざる<br>人もありやと<br><br>(述懐)"

            it["29"] = "<br>うもれ木を<br>見るにつけても<br>思ふかな<br>しづめるままの<br>人もありやと<br><br>(埋木)"

            it["30"] = "<br>埋火(うずめび)の<br>もとにいざなへ<br>ふる雪の<br>はれまもまたで<br>来る老人<br><br>(雪中人来)"

            it["30.Okuden"] = "<br>わけばやと<br>思ひ入りぬる<br>道にこそ<br>高きしをりも<br>見えそめにけれ<br><br>(道)"

            it["31"] = "<br>うるはしく<br>かきもかゝずも<br>文字はたゞ<br>読みやすくこそ<br>あらまほしけれ<br><br>(書)"

            it["32"] = "<br>老の坂<br>こえぬる子をも<br>をさなしと<br>思ふや親の<br>こゝろなるらむ<br><br>(親)"

            it["33"] = "<br>老人を<br>家にのこして<br>いくさびと<br>国のためにと<br>出づるをゝしさ<br><br>(をりにふれて)"

            it["33.Okuden"] = "<br>うしろには<br>いつなりにけむ<br>漕ぐ舟の<br>ゆくへはるかに<br>みえし島山<br><br>(島)"

            it["34"] = "<br>大空を<br>心のまゝに<br>とぶ島も<br>やどるねぐらは<br>忘れざるらむ<br><br>(島)"

            it["35"] = "<br>幼児が<br>もの書く跡を<br>みても知れ<br>習へばならふ<br>しるしある世を<br><br>(手習)"

            it["36"] = "<br>をしへある<br>庭にさきたる<br>撫子の<br>花は露にも<br>みだりざりけり<br><br>(露)"

            it["37"] = "<br>鬼神も<br>なかするものは<br>世の中の<br>人のこゝろの<br>まことなりけり<br><br>(誠)"

            it["38"] = "<br>おのがじじ<br>つとめを終へし<br>後にこそ<br>花のかげには<br>たつべかりけれ<br><br>(をりにふれて)"

            it["39"] = "<br>おのが身は<br>かへりみずして<br>ともすれば<br>人のうへのみ<br>いふ世なりけり<br><br>(をりにふれて)"

            it["40"] = "<br>おほぞらに<br>そびえて見ゆる<br>たかねにも<br>登ればのぼる<br>道はありけり<br><br>(峰)"

            it["41"] = "<br>おもふこと<br>思ひ定めて<br>後にこそ<br>人にはかくと<br>いふべかりけれ<br><br>(をりにふれて)"

            it["42"] = "<br>おもふこと<br>思ふがまゝに<br>なれりとも<br>身を慎まむ<br>ことな忘れそ<br><br>(をりにふれて)"

            it["43"] = "<br>及ばざる<br>事な思ひそう<br>つせみの<br>みはほどほどの<br>ありけるものを<br><br>(をりにふれて)"

            it["44"] = "<br>おりたちて<br>とくうちはらへ<br>枝よわき<br>小松のうへに<br>雪のつもれる<br><br>(雪中松)"

            it["45"] = "<br>かぎりなき<br>世にのこさむと<br>国の為<br>たふれし人の<br>名をぞとゞさむる<br><br>(をりにふれて)"

            it["45.Okuden"] = "<br>ものまなぶ<br>道にたつ子よ<br>怠りに<br>まされるあだは<br>なしと知らなん<br><br>(をりにふれて)"

            it["46"] = "<br>かざぐるま<br>いざかけさせよ<br>日ざかりの<br>署さいとはず<br>人のまゐくる<br><br>(扇風器)"

            it["46.Okuden"] = "<br>久しくも<br>わが飼ふ駒の<br>老いゆくを<br>惜しむは人に<br>かはらざりけり<br><br>(馬)"

            it["47"] = "<br>かざらむと<br>思はざりせば<br>なかなかに<br>うるはしからむ<br>人のこころは<br><br>(心)"

            it["48"] = "<br>かたしとて<br>思ひたゆまば<br>なにことも<br>なることあらじ<br>人の世の中<br><br>(述懐)"

            it["49"] = "<br>かりそめの<br>事に心を<br>うごかすな<br>家の柱と<br>たてらるゝ身は<br><br>(柱)"

            it["49.Okuden"] = "<br>よりそはん<br>暇はなくとも<br>文机の<br>上には塵を<br>するずもあらなん<br><br>(机)"

            it["50"] = "<br>かりそめの<br>言の葉草も<br>ともすれば<br>ものの根ざしと<br>なる世なりけり<br><br>(述懐)"

            it["51"] = "<br>川青の<br>くだるはやすき<br>世なりとて<br>棹に心を<br>ゆるさゞらなむ<br><br>(述懐)"

            it["52"] = "<br>きずなきは<br>すくなかりけり<br>世の中に<br>もてはやさるゝ<br>玉といへども<br><br>(寄玉述懐)"

            it["53"] = "<br>革まくら<br>旅にいでては<br>思ふかな<br>民のなりはひ<br>さまたげむかと<br><br>(旅中情)"

            it["53.Okuden"] = "<br>白雲の<br>よそにもとむな<br>世の人の<br>まことの道ぞ <br>しきしまの道<br><br>(寄道述懐)"

            it["54"] = "<br>国のため<br>あだなす仇は<br>くだくとも<br>いつくしむべき<br>事な忘れそ<br><br>(仁)"

            it["54.Okuden"] = "<br>ひらけゆく<br>道に出でても<br>心せよ<br>躓くことの<br>ある世なりけり<br><br>(をりにふれて)"

            it["55"] = "<br>国のため<br>ながかれと思ふ<br>老人に<br>死なぬ薬を<br>さづけてしがな<br><br>(薬)"

            it["56"] = "<br>くりかへす<br>昔がたりに<br>おのづから<br>いさめことばの<br>まじる老人<br><br>(老人)"

            it["56.Okuden"] = "<br>おもふこと<br>貫ぬかむよを<br>まつほどの<br>月日は長き<br>ものにぞありける<br><br>(月日)"

            it["57"] = "<br>暮れぬべく<br>なりていよいよ<br>惜しむかな<br>なすことなくて<br>過ぎし一日を<br><br>(夕)"

            it["58"] = "<br>子を思ふ<br>焼野のきじは<br>はるの夜の<br>ゆめもやすくは<br>結ばさるらむ<br><br>(親心)"

            it["59"] = "<br>こころある<br>人のいさめの<br>言の葉は<br>病なき身の<br>薬なりけり<br><br>(薬)"

            it["60"] = "<br>ことしげき<br>世にふる人も<br>わがこのむ<br>道にわけいる<br>ひまはありけり<br><br>(をりにふれて)"

            it["61"] = "<br>事繁き<br>世にも似たるか<br>夏草は<br>払ふあとより<br>おひ茂りつゝ<br><br>(夏草)"

            it["62"] = "<br>ことなしと<br>ゆるぶ心<br>はなかなかに<br>仇あるよりも<br>あやふかりけり<br><br>(心)"

            it["63"] = "<br>小山田の<br>畔のほそ<br>道細けれど<br>ゆづりあひてぞ<br>しづは通へる<br><br>(細径)"

            it["63.Okuden"] = "<br>ともすれば<br>かき濁りけり<br>山水の<br>澄せばすます<br>人の心を<br><br>(心)"

            it["64"] = "<br>こらは皆<br>軍のにはに<br>いではてゝ<br>翁やひとり<br>山田まもらむ<br><br>(田家翁)"

            it["64.Okuden"] = "<br>いそのかみ<br>古きためしを<br>たづねつつ<br>新しき世の<br>ことも定めむ<br><br>(をりにふれて)"

            it["65"] = "<br>さしのぼる<br>朝日のごとく<br>さわやかに<br>もたまほしきは<br>心なりけり<br><br>(日)"

            it["66"] = "<br>梅雨 (さみだれ) に<br>たゝみの上も<br>しめれるを<br>たむろのうちぞ<br>思ひやらるゝ<br><br>(梅雨)"

            it["66.Okuden"] = "<br>たらちねの<br>おやのをしへを<br>守る子は<br>学びのみちも<br>まどはざるらむ<br><br>(子)"

            it["67"] = "<br>さゆる夜の<br>嵐のおとに<br>夢さめて<br>しづがふせやを<br>思ひやるかな<br><br>(寒夜述懐)"

            it["67.Okuden"] = "<br>たらちねの<br>みおやのをしへ<br>新玉の<br>年ふるままに<br>身にぞしみける<br><br>(親)"

            it["68"] = "<br>しら玉を<br>光なしとも<br>思ふかな<br>磨きたらざる<br>ことを忘れて<br><br>(玉)"

            it["69"] = "<br>進むあり<br>おくるゝもあり<br>時はかる<br>うつはの針も<br>まちまちにして<br><br>(時計)"

            it["70"] = "<br>すゝむには<br>よし早くとも<br>あやうしと<br>思ふ道には<br>入らずもあらなむ<br><br>(道)"

            it["71"] = "<br>すゝむべき<br>時をはかりて<br>進まずば<br>危うき道に<br>いりもこそすれ<br><br>(をりにふれて)"

            it["72"] = "<br>すなほなる<br>をさな心を<br>いつとなく<br>忘れはつるが<br>惜しくもあるかな<br><br>(心)"

            it["73"] = "<br>すなほにも<br>おほしたてなむ<br>いづれにも<br>かたぶきやすき<br>庭のわか竹<br><br>(子)"

            it["74"] = "<br>たかゝらぬ<br>松のこのまに<br>さきながら<br>雲かとみゆる<br>山桜かな<br><br>(花以雪)"

            it["75"] = "<br>たちつづく<br>市の家居は<br>署からむ<br>風の吹入る<br>窓せばくして<br><br>(夏住居)"

            it["75.Okuden"] = "<br>若竹の<br>生ひゆく末を<br>思ふ世に<br>庭の訓を<br>おろそかにすな<br><br>(庭訓)"

            it["76"] = "<br>たらちねの<br>親につかへて<br>まめなるが<br>人のまことの<br>始なりけり<br><br>(孝)"

            it["77"] = "<br>たらちねの<br>親の心は<br>誰もみな<br>年ふるまゝに<br>おもい知るらむ<br><br>(親心)"

            it["78"] = "<br>たらちねの<br>にはの教は<br>せばけれど<br>ひろき世に立つ<br>もとゐとぞなる<br><br>(庭訓)"

            it["79"] = "<br>散りやすき<br>うらみはいはじ<br>いく春も<br>かわらでにほへ<br>山ざくら花<br><br>(対花言志)"

            it["80"] = "<br>つもりなば<br>払ふ方たく<br>なりぬべし<br>塵ばかりなる<br>事と思へど<br><br>(塵)"

            it["80.Okuden"] = "<br>桶葉に<br>かけし鏡を<br>かがみにて<br>人もこころを<br>磨けとぞ思ふ、<br><br>(鏡)"

            it["81"] = "<br>手ならひを<br>ものうきことに<br>思ひつる<br>をさな心を<br>今くゆるかな<br><br>(手習)"

            it["82"] = "<br>照るにつけ<br>くもるにつけて<br>思ふかな<br>わだ民草の<br>うへはいかにと<br><br>(述懐)"

            it["82.Okuden"] = "<br>やすくして<br>なし得がたきは<br>世の中の<br>ひとの人たる<br>おこなひにして<br><br>(行)"

            it["83"] = "<br>遠くとも<br>人の行くべき<br>道ゆかば<br>危き事は<br>あらじとぞ思ふ<br><br>(道)"

            it["84"] = "<br>歳月は<br>射る矢のごとし<br>物はみな<br>すみやかにこそ<br>なすべかりけれ<br><br>(をりにふれて)"

            it["85"] = "<br>とる枯の<br>こゝろ長くも<br>こぎよせむ<br>薦間の小舟<br>さはりありとも<br><br>(蘆間舟)"

            it["86"] = "<br>なかばにて<br>やすらふことの<br>なくもがな<br>学の道の<br>わけがたしとて<br><br>(道）"

            it["87"] = "<br>なすことの<br>なくて終らば<br>世に長き<br>よはひを保つ<br>かひやなからむ<br><br>(をりにふれて)"

            it["88"] = "<br>なにごとも<br>思ふがまゝに<br>ならざるが<br>かへりて人の<br>身の為にこそ<br><br>(人)"

            it["89"] = "<br>波風の<br>しづかなる日も<br>ふなびとは<br>舵にこゝろを<br>許さゞらなむ<br><br>(心)"

            it["90"] = "<br>ならび行く<br>人にはよしや<br>おくるとも<br>たゞしき道を<br>ふみなたがへそ<br><br>(道)"

            it["91"] = "<br>払はずば<br>思はぬかたに<br>かたぶかむ<br>つゆおきあまる<br>なでしこの花<br><br>(をりにふれて)"

            it["92"] = "<br>人みなの<br>えらびしうへに<br>えらびたる<br>玉にもきずの<br>ある世なりけり<br><br>(玉)"

            it["93"] = "<br>ひとりたつ<br>身となりし子<br>を幼なしと<br>おもふや親の<br>こゝろなるらむ<br><br>(親心)"

            it["94"] = "<br>ひとりたつ<br>身になりぬとも<br>おほしたてし<br>親の恵を<br>わすれざらなむ<br><br>(親)"

            it["95"] = "<br>ひらかずば<br>いかで光の<br>あらはれむ<br>こがね花さく<br>山はありとも<br><br>(鉱山)"

            it["96"] = "<br>開けゆく<br>道に出でても<br>こゝろせよ<br>つまづく事の<br>ある世なりけり<br><br>(をりにふれて)"

            it["97"] = "<br>ひろき世に<br>たつべき人は<br>数ならぬ<br>ことに心を<br>くだかざらなむ<br><br>(述懐)"

            it["98"] = "<br>ひろき世に<br>まじりながら<br>ともすれば<br>狭くなりゆく<br>ひとごころかな<br><br>(心)"

            it["99"] = "<br>ほどほどに<br>たつべき道も<br>あるものを<br>老いにけりとて<br>身をばかこちそ<br><br>(老人)"

            it["100"] = "<br>槇ばしら<br>たち栄ゆるも<br>うごきなき<br>家のあるじの<br>あればなりけり<br><br>(家主)"

            it["100.Okuden"] = "<br>おもふこと<br>おもふがまゝに<br>いひ出づる<br>をさな心や<br>まことなるらむ<br><br>(子)"

            it["101"] = "<br>まつりごと<br>たぐしき国と<br>いはれなむ<br>百のつかさよ<br>ちから尽くして<br><br>(述懐)"

            it["102"] = "<br>学びえて<br>道のはかせと<br>なる人も<br>をしえのおやの<br>恵わするな<br><br>(師)"

            it["103"] = "<br>みな人の<br>見るにいぶみに<br>世の中の<br>あとなしごとは<br>かかずもあらなむ<br><br>(新聞紙)"

            it["103.Okuden"] = "<br>幼子が<br>ならへばならふ<br>ほどみえて<br>きよくなりゆく<br>水くきのあと<br>(手習)"

            it["104"] = "<br>みなもとは<br>清くすめるを<br>濁り江に<br>おちいる水の<br>をしくもあるかな<br><br>(水)"

            it["105"] = "<br>身にあまる<br>重荷車を<br>ひきながら<br>いそがぬ牛は<br>つまづかずして<br><br>(牛)"

            it["106"] = "<br>目に見えぬ<br>神に向かひて<br>はぢざるは<br>人の心の<br>まことなりけり<br><br>(神祇)"

            it["107"] = "<br>ものごとに<br>進まずとのみ<br>思ふかな<br>身のおこたりは<br>かへりみずして<br><br>(おりにふれて)"

            it["108"] = "<br>もろともに<br>たすけかはして<br>むつびあふ<br>友ぞ世にたつ<br>力なるべき<br><br>(友)"

            it["109"] = "<br>やしないて<br>なほも齢を<br>たもたせむ<br>庭に千代ふる<br>松のひともと<br><br>(老松)"

            it["110"] = "<br>山田もる<br>しづが心は<br>やすからじ<br>種おろすより<br>刈りあぐるまで<br><br>(農夫)"

            it["110.Okuden"] = "<br>いつくしと<br>めでのあまりに<br>撫子の<br>庭のをしへを<br>おろそかにすな<br><br>(庭訓)"

            it["111"] = "<br>ゆきにたへ<br>嵐にたへし<br>後にこそ<br>松のくらいも<br>高く見えけれ<br><br>(松)"

            it["112"] = "<br>よきをとり<br>あしきをすてゝ<br>外国に<br>おとらぬ国と<br>なすよしもがな<br><br>(国)"

            it["113"] = "<br>世に広く<br>しらるゝふまゝに<br>人みなの<br>つゝしむべきは<br>おのが身にして<br><br>(をりにふれて)"

            it["114"] = "<br>世のさまは<br>いかゞあらむと<br>かたつぶり<br>をりをり家を<br>いでて見るらむ<br><br>(蝸牛)"

            it["115"] = "<br>世の中に<br>危きことは<br>なかるべし<br>正しき道を<br>ふみたがへずば<br><br>(道)"

            it["116"] = "<br>世の中に<br>ひとりたつまで<br>をさめえし<br>業こそ人の<br>たからなりけり<br><br>(宝)"

            it["117"] = "<br>世の中の<br>風にこゝろを<br>さわがすな<br>まなびの窓に<br>こもるわらはべ<br><br>(学生)"

            it["118"] = "<br>世の中の<br>人におくれを<br>とりぬべし<br>すゝまむときに<br>進まざりせば<br><br>(をりにふれて)"

            it["119"] = "<br>世の中の<br>人の司と<br>なる人の<br>身のおこなひよ<br>たゞしからなむ<br><br>(行)"

            it["120"] = "<br>世の人を<br>をしふる事も<br>かたからむ<br>身のおこなひの<br>正しからずば<br><br>(行)"

            it["121"] = "<br>よもの海<br>みなはらからと<br>思ふ世に<br>など波風の<br>たちさわぐら<br><br>(正述心緒)"

            it["122"] = "<br>よる波に<br>打あげられて<br>恥しながら<br>花咲きにけり<br>かはらなでしこ<br><br>(をりにふれて)"

            it["123"] = "<br>世わたりの<br>道のつとめに<br>怠るな<br>心にかなふ<br>あそびありとも<br><br>(遊戯)"

            it["124"] = "<br>わが心<br>われとをりをり<br>かへりみよ<br>知らず知らずも<br>迷ふことあり<br><br>(をりにふれて)"

            it["125"] = "<br>われもまた<br>さらにみがかむ<br>曇なき<br>人の心を<br>かがみにはして<br><br>(鐘)"
        }
    }
}
*/